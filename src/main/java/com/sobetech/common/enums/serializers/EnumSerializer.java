/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.enums.serializers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This is for classes that need a StdSerializer, but want the option to be strict or not
 *
 * @author John Murray
 *
 * @since May 20, 2024
 *
 * @param <E> The type of Enum to be serialized. This extends Object because many of the enums that need
 * serialization are annotated on the interface level
 * 
 */
public abstract class EnumSerializer <E extends Object> extends StdSerializer<E> 
{
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

	protected EnumSerializer(Class<E> enumClass)
	{
		super(enumClass);
	}
	
	/**
	 * Get the message key in application.properties to be used to check to use strict serialization. If the 
	 * key is not present, the serializer will be strict
	 * 
	 * @return The message key in application.properties to be used to check to use strict serialization
	 */
	protected abstract String getMessageKey();

	/**
	 * Will this Serializer or De-Serializer be strict with this Enum. If it is strict, it will
	 * not do any custom logic in the process and essentially skip this serializer. 
	 * @return
	 */
	@SuppressWarnings("resource")
	protected boolean isStrict()
	{
		/*
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String propertyFilePath = rootPath + "application.properties";

        Properties applicationProps = new Properties();
        try
		{
			applicationProps.load(new FileInputStream(propertyFilePath));
			return Boolean.valueOf(applicationProps.getProperty(getMessageKey(), "true"));
		}
		catch(FileNotFoundException e)
		{
			LOG.error("Could not find " + propertyFilePath, e);
		}
		catch(IOException e)
		{
			LOG.error("Issue in reading " + propertyFilePath, e);
		}	
        
        return true;
        */
		
		String rootPath = this.getClass().getResource("").getPath();
        String propertyFilePath = rootPath + "application.properties";
        Properties applicationProps = new Properties();
        
        try (InputStream inputStream = EnumSerializer.class.getClassLoader().getResourceAsStream(propertyFilePath)) 
        {
            if (inputStream != null) 
            {
            	applicationProps.load(new FileInputStream(propertyFilePath));
            	String keyValue = applicationProps.getProperty(getMessageKey(), "true");
    			return Boolean.valueOf(keyValue);
            } 
        } 
        catch (IOException e) 
        {
        	LOG.error("Issue in reading " + propertyFilePath, e);
        }
        
        return true;
	}
}