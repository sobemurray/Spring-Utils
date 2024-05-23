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
import java.net.URL;
import java.util.MissingResourceException;
import java.util.Properties;

import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * This is for classes that need a StdDeserializer, but want the option to be strict or not
 *
 * @author John Murray
 *
 * @since May 20, 2024
 *
 * @param <E> The type of Enum to be deserialized. This extends Object because many of the enums that need
 * deserialization are annotated on the interface level
 * 
 */
public abstract class EnumDeserializer <E extends Object> extends StdDeserializer<E>
{
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MessageSource messageSource;

	protected EnumDeserializer(Class<?> vc)
	{
		super(vc);
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
	protected boolean isStrict()
	{
		/*
		 
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String propertyFilePath = rootPath + "application.properties";

        Properties applicationProps = new Properties();
        try
		{
			String keyValue = messageSource.getMessage(getMessageKey(), null, "true", LocaleContextHolder.getLocale());
			return Boolean.valueOf(keyValue);
		}
		catch(NoSuchMessageException nsme)
		{
			LOG.debug("NoSuchMessageException key {}", getMessageKey(), nsme);
		}
		catch(MissingResourceException mre)
		{
			LOG.debug("MissingResourceException key {}", getMessageKey(), mre);
		}
		
		return true;
		*/
		
		/*
		String rootPath1 = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String rootPath2 = Thread.currentThread().getContextClassLoader().getResource("application.properties").getPath();
		
		URL classesDir = this.getClass().getResource("");
		String rootPath = classesDir.getPath();
        String propertyFilePath = rootPath1 + "application.properties";
        Properties applicationProps = new Properties();
        
        try (InputStream inputStream = EnumSerializer.class.getClassLoader().getResourceAsStream(propertyFilePath)) 
        {
            if (inputStream != null) 
            {
            	applicationProps.load(new FileInputStream(propertyFilePath));
            	String keyValue = applicationProps.getProperty(getMessageKey());
    			return Boolean.valueOf(keyValue);
            } 
        } 
        catch (IOException e) 
        {
        	LOG.error("Issue in reading " + propertyFilePath, e);
        }
        
        return true;
        */
        
        
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String propertyFilePath = rootPath + "application.properties";

        Properties applicationProps = new Properties();
        try
		{
        	applicationProps.load(new FileInputStream(propertyFilePath));
        	String keyValue = applicationProps.getProperty(getMessageKey());
			return Boolean.valueOf(keyValue);
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
	}
}
