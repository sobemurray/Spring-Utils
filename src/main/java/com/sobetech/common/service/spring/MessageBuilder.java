/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2025 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.service.spring;

import java.util.MissingResourceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;

import com.sobetech.common.exception.CodedError;
import com.sobetech.common.exception.ErrorResponse;

/**
 * Get display and resolution messages from properties file and the code of the message find
 *
 * @author John Murray
 *
 * @since May 26, 2025
 *
 */
public abstract class MessageBuilder
{
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private static final String UNKNOWN_MESSAGE = "Unknown";
	
	@Value("${messaging.i18n.display.key}")
	private String i18nDisplayKey;
	
	@Value("${messaging.i18n.resolution.key}")
	private String i18nResolutionKey;

	@Autowired
	private MessageSource messageSource;

	/**
	 * Build a ResponseEntity from a CodedError
	 * 
	 * @param errorCode The CodedError to build the response from
	 * @return The ResponseEntity populated from the CodedError
	 */
	protected ResponseEntity<ErrorResponse> getResponseByCodedError(CodedError errorCode)
	{
		ErrorResponse response = new ErrorResponse(errorCode.getHttpStatus(), errorCode.getCode(), 
				getMessageString(getDisplayStringKey(errorCode)), 
				getMessageString(getResolutionStringKey(errorCode)));
		
		return new ResponseEntity<>(response, errorCode.getHttpStatus());
	}

	/**
	 * Get the full display key for the messages properties from a CodedError
	 * 
	 * @param errorCode The CodedError to build the key
	 * @return The DisplayStringKey from the CodedError
	 */
	protected String getDisplayStringKey(CodedError errorCode)
	{
		if(errorCode == null)
		{
			throw new IllegalArgumentException("Message string cannot be retrived without CodedError");
		}
		
		return i18nDisplayKey + errorCode.getCode();
	}
	
	/**
	 * Get the full resolution key for the messages properties from a CodedError
	 * 
	 * @param errorCode The CodedError to build the key
	 * @return The ResolutionStringKey from the CodedError
	 */
	protected String getResolutionStringKey(CodedError errorCode)
	{
		if(errorCode == null)
		{
			throw new IllegalArgumentException("Message string cannot be retrived without CodedError");
		}
		
		return i18nResolutionKey + errorCode.getCode();
	}
	
	/**
	 * Build a message String from the key and the arguments to substitute in from the properties 
	 * file
	 * 
	 * @param messageKey The message key
	 * @return The message String
	 */
	protected String getMessageString(String messageKey)
	{
		return getMessageString(messageKey, null, UNKNOWN_MESSAGE);
	}
	
	/**
	 * Build a message String from the key and the arguments to substitute in from the properties 
	 * file
	 * 
	 * @param messageKey The message key
	 * @param arguments The arguments to substitute in
	 * @return The message String
	 */
	protected String getMessageString(String messageKey, Object[] arguments)
	{
		return getMessageString(messageKey, arguments, UNKNOWN_MESSAGE);
	}
	
	/**
	 * Build a message String from the key and the arguments to substitute in from the properties 
	 * file
	 * 
	 * @param messageKey The message key
	 * @param arguments The arguments to substitute in
	 * @param defaultValue The value to return if any issued occurred in building the message
	 * @return The message String
	 */
	protected String getMessageString(String messageKey, Object[] arguments, String defaultValue)
	{
		try
		{
			return messageSource.getMessage(messageKey, arguments, LocaleContextHolder.getLocale());
		}
		catch(NoSuchMessageException nsme)
		{
			LOG.debug("NoSuchMessageException key {}", messageKey, nsme);
		}
		catch(MissingResourceException mre)
		{
			LOG.debug("MissingResourceException key {}", messageKey, mre);
			
		}
		
		return defaultValue;
	}
	
	/**
	 * Get the name of the attribute that was bad
	 * 
	 * @param pathReference The path reference
	 * @return The name of the attribute that was bad 
	 */
	protected String getBadAttribute(String pathReference)
	{
		int startIndex = pathReference.indexOf("[\"") + 2;
		
		if(startIndex == -1)
		{
			return "";
		}
		
		int endIndex = pathReference.indexOf("\"]");
		
		if(startIndex >= endIndex)
		{
			return "";
		}
		
		return pathReference.substring(startIndex, endIndex);
	}
}
