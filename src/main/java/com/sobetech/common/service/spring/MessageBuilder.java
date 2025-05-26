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

	protected ResponseEntity<ErrorResponse> getResponseByCodedError(CodedError errorCode)
	{
		ErrorResponse response = new ErrorResponse(errorCode.getHttpStatus(), errorCode.getCode(), 
				getMessageString(getDisplayStringKey(errorCode)), 
				getMessageString(getResolutionStringKey(errorCode)));
		
		return new ResponseEntity<>(response, errorCode.getHttpStatus());
	}

	protected String getDisplayStringKey(CodedError errorCode)
	{
		if(errorCode == null)
		{
			throw new IllegalArgumentException("Message string cannot be retrived without CodedError");
		}
		
		return i18nDisplayKey + errorCode.getCode();
	}
	
	protected String getResolutionStringKey(CodedError errorCode)
	{
		if(errorCode == null)
		{
			throw new IllegalArgumentException("Message string cannot be retrived without CodedError");
		}
		
		return i18nResolutionKey + errorCode.getCode();
	}
	
	protected String getMessageString(String messageKey)
	{
		return getMessageString(messageKey, null, UNKNOWN_MESSAGE);
	}
	
	protected String getMessageString(String messageKey, Object[] arguments)
	{
		return getMessageString(messageKey, arguments, UNKNOWN_MESSAGE);
	}
	
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
