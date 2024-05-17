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
package com.sobetech.common.exception.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sobetech.common.exception.ApiRuntimeException;
import com.sobetech.common.exception.CodedError;
import com.sobetech.common.exception.ExceptionParameterType;

/**
 *
 *
 * @author John Murray
 *
 * @since May 17, 2024
 *
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User not found")
public class UserNotFoundException extends ApiRuntimeException
{
	/**
	 *  Default constructor
	 */
	public UserNotFoundException()
	{
	}

	/**
	 * Build the exception with a message
	 * 
	 * @param message The message to include in the exception
	 */
	public UserNotFoundException(String message)
	{
		super(message);
		//Call the setters
	}

	/**
	 * Build the exception with custom error messaging
	 * 
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 */
	public UserNotFoundException(CodedError codedError)
	{
		super(codedError);
	}

	/**
	 * Create a new exception from an existing one
	 * 
	 * @param cause The parent Throwable that caused this exception
	 */
	public UserNotFoundException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * Build the exception with a message and custom error messaging
	 * 
	 * @param message The message to include in the exception
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 */
	public UserNotFoundException(String message, CodedError codedError)
	{
		super(message, codedError);
	}

	/**
	 * Create a new exception from an existing one and custom error messaging
	 * 
	 * @param cause The parent Throwable that caused this exception
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 */
	public UserNotFoundException(Throwable cause, CodedError codedError)
	{
		super(cause, codedError);
	}

	/**
	 * Build the exception with a message and an an existing exception
	 * 
	 * @param message The message to include in the exception
	 * @param cause The parent Throwable that caused this exception
	 */
	public UserNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Build the exception with custom error messaging, a String to used in building the display message,
	 * and a String to used in building the resolution message
	 * 
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 * @param errorDisplayParameter A String to used in building the display message
	 * @param errorResolutionParameter A String to used in building the resolution message
	 */
	public UserNotFoundException(CodedError codedError, String errorDisplayParameter, String errorResolutionParameter)
	{
		super(codedError, errorDisplayParameter, errorResolutionParameter);
	}

	/**
	 * Build the exception with custom error messaging with Strings to be used to build either the display
	 * or resolution messages
	 * 
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 * @param parameterType The type of parameter to apply the strings to
	 * @param parameters The Strings to be used in populating the exception parameter
	 */
	public UserNotFoundException(CodedError codedError, ExceptionParameterType parameterType, String... parameters)
	{
		super(codedError, parameterType, parameters);
	}

	/**
	 * Build the exception with custom error messaging with Strings to be used to build the display and 
	 * resolution messages
	 * 
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 * @param errorDisplayParameters An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable message to be sent in the response and displayed to a
	 * end user
	 * @param errorResolutionParameters An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable resolution to be sent in the response
	 */
	public UserNotFoundException(CodedError codedError, Object[] errorDisplayParameters,
			Object[] errorResolutionParameters)
	{
		super(codedError, errorDisplayParameters, errorResolutionParameters);
	}

	/**
	 * Build the exception with a message, an an existing exception and custom error messaging
	 * 
	 * @param message The message to include in the exception
	 * @param cause The parent Throwable that caused this exception
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 */
	public UserNotFoundException(String message, Throwable cause, CodedError codedError)
	{
		super(message, cause, codedError);
	}

	/**
	 * Build the exception with a message and custom error messaging with Strings to be used to build the 
	 * display and resolution messages
	 * 
	 * @param message The message to include in the exception
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 * @param errorDisplayParameter An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable message to be sent in the response and displayed to a
	 * end user
	 * @param errorResolutionParameter An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable resolution to be sent in the response
	 */
	public UserNotFoundException(String message, CodedError codedError, String errorDisplayParameter,
			String errorResolutionParameter)
	{
		super(message, codedError, errorDisplayParameter, errorResolutionParameter);
	}

	/**
	 * Build the exception with a message and custom error messaging with Strings to be used to build the 
	 * display and resolution messages
	 * 
	 * @param message The message to include in the exception
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 * @param errorDisplayParameters An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable message to be sent in the response and displayed to a
	 * end user
	 * @param errorResolutionParameters An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable resolution to be sent in the response
	 */
	public UserNotFoundException(String message, CodedError codedError, Object[] errorDisplayParameters,
			Object[] errorResolutionParameters)
	{
		super(message, codedError, errorDisplayParameters, errorResolutionParameters);
	}

	/**
	 * Build the exception with a message, an an existing exception and custom error messaging with Strings 
	 * to be used to build the display and resolution messages
	 * 
	 * @param message The message to include in the exception
	 * @param cause The parent Throwable that caused this exception
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 * @param errorDisplayParameter An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable message to be sent in the response and displayed to a
	 * end user
	 * @param errorResolutionParameter An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable resolution to be sent in the response
	 */
	public UserNotFoundException(String message, Throwable cause, CodedError codedError, String errorDisplayParameter,
			String errorResolutionParameter)
	{
		super(message, cause, codedError, errorDisplayParameter, errorResolutionParameter);
	}

	/**
	 * Build the exception with a message, an an existing exception and custom error messaging with Strings 
	 * to be used to build the display and resolution messages
	 * 
	 * @param message The message to include in the exception
	 * @param cause The parent Throwable that caused this exception
	 * @param codedError The custom error that contains messaging that can be easily displayed
	 * the the user
	 * @param errorDisplayParameters An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable message to be sent in the response and displayed to a
	 * end user
	 * @param errorResolutionParameters An array of Objects that will be converted into Strings. These
	 * Strings will be used to build a readable resolution to be sent in the response
	 */
	public UserNotFoundException(String message, Throwable cause, CodedError codedError,
			Object[] errorDisplayParameters, Object[] errorResolutionParameters)
	{
		super(message, cause, codedError, errorDisplayParameters, errorResolutionParameters);
	}
}
