/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Team Focus / Peak6, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.service.spring.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sobetech.common.enums.StringEnum;
import com.sobetech.common.enums.UiEnum;
import com.sobetech.common.model.annotation.SkipNullCopyAttribute;

/**
 * A Spring service used to do Reflection functionality
 *
 * @author John Murray
 *
 * @since May 21, 2024
 *
 */
@Service
public class ReflectionUtil
{
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Look for a StringEnum with the name provided and output each of there values as UiEnum
	 * instances for UI consumption
	 * 
	 * @param className The simple class name of the StringEnum. There is NO package names included
	 * @return A List of UiEnum instances from the StringEnums sorted by description
	 */
	public List<UiEnum> getUiEnumsByClassName(String className)
	{
		List<UiEnum> uiEnums = new ArrayList<>();
		
		try
		{
			Reflections reflections = new Reflections(
	                new ConfigurationBuilder()
	                        .setUrls(ClasspathHelper.forJavaClassPath())
	                        .setScanners(Scanners.TypesAnnotated, Scanners.SubTypes)
	        );
			
			Class<? extends StringEnum> foundClass = null;

	        // Retrieve all classes from the classpath
	        Set<Class<? extends StringEnum>> uiEnumClasses = reflections.getSubTypesOf(StringEnum.class);

	        for (Class<? extends StringEnum> uiEnumClass : uiEnumClasses) 
	        {
	        	LOG.trace("See if class {} is {}", uiEnumClass.getSimpleName(), className);
	        	
	        	
	            if (uiEnumClass.getSimpleName().equals(className)) 
	            {
	            	LOG.trace("Found class {}", uiEnumClass.getName());
	            	foundClass = uiEnumClass;
	            }
	        }
	        
	        if(foundClass != null)
	        {
	        	// Get the 'values' method
			    Method valuesMethod = foundClass.getMethod("values");
			    
			    // Invoke the 'values' method
			    Object[] enumValues = (Object[]) valuesMethod.invoke(null);
			    
			    for(Object stringEnum : enumValues)
			    {
			    	StringEnum newStringEnum =  (StringEnum)stringEnum;
			    	
			    	if(newStringEnum.isActive() && !newStringEnum.isPrivate())
			    	{
			    		uiEnums.add(new UiEnum(newStringEnum.name(), newStringEnum.getDescription()));
			    	}
			    }
	        }	    
		}
		catch(NoSuchMethodException | SecurityException | IllegalAccessException
				| InvocationTargetException  e)
		{
			LOG.error("Reflection Error", e);
		}
		
		uiEnums.sort((enum1, enum2) -> enum1.getDescription().compareTo(enum2.getDescription()));
		
		return uiEnums;
	}
	
	/**
	 * Create a new class and populate it with the matching attributes of the source. The matching
	 * attributes have the same name in both classes as well as the same types
	 * 
	 * @param <O> The Class that is being returned
	 * @param sourceObject The object to be copied
	 * @param destinationObjectClass The type of object to be created and populated
	 * @param returnNullIfEmpty If <code>true</code> this will return a null object if nothing was copied
	 * from the source to the destination
	 * @return A new instance of a class of the destination type with the common attributes of the source 
	 * object copied over to the new instance.
	 * 
	 * If the source object is <code>null</code> then null will be returned.
	 * 
	 * If the returnNullIfEmpty parameter has been set to <code>true</code> this then this will return a null object 
	 * if nothing was copied from the source to the destination
	 * @throws ReflectiveOperationException
	 */
	public <O extends Object> O createAndCopyAttributes(Object sourceObject, Class<O> destinationObjectClass,
			boolean returnNullIfEmpty) throws ReflectiveOperationException
	{
		if(sourceObject == null)
		{
			return null;
		}
		
		O destinationObject  = destinationObjectClass.getDeclaredConstructor().newInstance();

        return copyObjectAttributes(sourceObject, destinationObject, returnNullIfEmpty);
	}

	/**
	 * Copy the attributes from one object to another as long as the names and types are identical
	 * 
	 * @param sourceObject The object to copy from
	 * @param destinationObject The object to copy to
	 * @return The updated destinationObject
	 * @throws IllegalAccessException If any issues occur in the reflection process
	 * @throws IllegalArgumentException If any issues occur in the reflection process
	 */
	public <O extends Object> O copyObjectAttributes(Object sourceObject, O destinationObject) throws IllegalArgumentException, IllegalAccessException
	{
        return copyObjectAttributes(sourceObject, destinationObject, false);
	}

	/**
	 * Copy the attributes from one object to another as long as the names and types are identical.
	 * If the sourceObject is <code>null</code> then the destinationObject will be returned
	 * unchanged
	 * 
	 * @param sourceObject The object to copy from
	 * @param destinationObject The object to copy to
	 * @param returnNullIfEmpty If <code>true</code> this will return a null object if nothing was copied
	 * from the source to the destination. If the sourceObject is <code>null</code> then the 
	 * destinationObject will be returned unchanged
	 * @return The updated destinationObject
	 * @throws IllegalAccessException If any issues occur in the reflection process
	 * @throws IllegalArgumentException If any issues occur in the reflection process
	 */
	public <O extends Object> O  copyObjectAttributes(Object sourceObject, O destinationObject, boolean returnNullIfEmpty) 
			throws IllegalArgumentException, IllegalAccessException
	{
		if(sourceObject == null)
		{
			return destinationObject;
		}
		
		Field[] sourceFields = sourceObject.getClass().getDeclaredFields();
        Field[] destinationFields = destinationObject.getClass().getDeclaredFields();
        
        boolean noDataTransfered = true;

        for (Field sourceField : sourceFields) 
        {
        	sourceField.setAccessible(true);
        	
        	if(sourceField.get(sourceObject) == null && sourceField.isAnnotationPresent(SkipNullCopyAttribute.class))
        	{
        		LOG.trace("Skipping {} because it was flagged as SkipNullCopyAttribute", sourceField.getName());
        		continue;
        	}
        	
            for (Field destinationField : destinationFields) 
            {
            	if (sourceField.getName().equals(destinationField.getName()))         	
            	{
	                if(sourceField.getType().equals(destinationField.getType())) 
	                {
	                    destinationField.setAccessible(true);
	                    destinationField.set(destinationObject, sourceField.get(sourceObject));
	                    noDataTransfered = false;
	                }
	            	else
	            	{
	            		LOG.debug("{}.{} is {}, but {} expected {}", sourceObject.getClass().getSimpleName(), 
	            				sourceField.getName(), sourceField.getType(),
	            				destinationObject.getClass().getSimpleName(), destinationField.getType());
	            	}
                }
            }
        }
        
        if(noDataTransfered && returnNullIfEmpty)
        {
        	return null;
        }
        
        return destinationObject;
	}
}