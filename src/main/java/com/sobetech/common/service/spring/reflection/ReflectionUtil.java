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
	        	LOG.debug("See if class {} is {}", uiEnumClass.getSimpleName(), className);
	        	
	        	
	            if (uiEnumClass.getSimpleName().equals(className)) 
	            {
	            	LOG.debug("Found class {}", uiEnumClass.getName());
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
			    	uiEnums.add(new UiEnum(newStringEnum.name(), newStringEnum.getDescription()));
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
}
