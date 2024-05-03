/**
 * Created by Sobetech Holdings LLC
 *
 * Copyright © 2022 Sobetech Holdings LLC, All Rights Reserved
 *
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with Sobetech Holdings LLC, or one of its affiliates,
 * and may not be used, disseminated, or distributed except in accordance with
 * the terms of that agreement.
 *
 */
package com.sobetech.common.exception;

import java.util.Collections;
import java.util.List;

/**
 * Exception for Logical List Errors
 *
 * @author John Murray
 *
 */

public class LogicalErrorsListException  extends ApiRuntimeException 
{
	private static final long serialVersionUID = -5699064419430098474L;
	
	/**
	 * A String list of error messages that are to be included in this exception
	 */
	private List<String> errorsList = Collections.emptyList();

	/**
	 * Create a LogicalErrorsListException with a message as well as an errors list
	 * 
	 * @param message The message to include with this exception
	 * @param errorsList A String list of error messages that are to be included in this exception
	 */
	public LogicalErrorsListException(String message, List<String> errorsList) 
	{
		super(message);
		this.errorsList = errorsList;
	}

	/**
	 * Create a generic LogicalErrorsListException with a ErrorCode.SYSTEM_ERROR error code
	 */
	public LogicalErrorsListException()
	{
		super();
	}

	/**
	 * Create an LogicalErrorsListException with a specific ErrorCode with any number of parameters of a type
	 * 
	 * @param errorCode The ErrorCode to include with this exception
	 * @param parameterType The type of parameter used for substitution in building the message
	 * @param parameters The parameters used for substitution in building the message
	 */
	public LogicalErrorsListException(ErrorCode errorCode, ExceptionParameterType parameterType, String... parameters)
	{
		super(errorCode, parameterType, parameters);
	}

	/**
	 * Create an LogicalErrorsListException with a specific ErrorCode with any number of display and resolution
	 * parameters
	 * 
	 * @param errorCode The ErrorCode to include with this exception
	 * @param errorDisplayParameters An array of parameters used as a substitution of the display message
	 * @param errorResolutionParameters An array of parameters used as a substitution of the resolution message
	 */
	public LogicalErrorsListException(ErrorCode errorCode, Object[] errorDisplayParameters,
			Object[] errorResolutionParameters)
	{
		super(errorCode, errorDisplayParameters, errorResolutionParameters);
	}

	/**
	 * Create an LogicalErrorsListException with a specific ErrorCode with singular display and resolution
	 * parameters
	 * 
	 * @param errorCode The ErrorCode to include with this exception
	 * @param errorDisplayParameter The single parameter used as a substitution of the display message
	 * @param errorResolutionParameter The single parameter used as a substitution of the resolution message
	 */
	public LogicalErrorsListException(ErrorCode errorCode, String errorDisplayParameter,
			String errorResolutionParameter)
	{
		super(errorCode, errorDisplayParameter, errorResolutionParameter);
	}

	/**
	 * Create an LogicalErrorsListException with a specific ErrorCode
	 * 
	 * @param errorCode The ErrorCode to include with this exception
	 */
	public LogicalErrorsListException(ErrorCode errorCode)
	{
		super(errorCode);
	}

	/**
	 * Create an LogicalErrorsListException with a message and a specific ErrorCode with any number of display and resolution
	 * parameters
	 * 
	 * @param message The message to include with this exception
	 * @param errorCode The ErrorCode to include with this exception
	 * @param errorDisplayParameters An array of parameters used as a substitution of the display message
	 * @param errorResolutionParameters An array of parameters used as a substitution of the resolution message
	 */
	public LogicalErrorsListException(String message, ErrorCode errorCode, Object[] errorDisplayParameters,
			Object[] errorResolutionParameters)
	{
		super(message, errorCode, errorDisplayParameters, errorResolutionParameters);
	}

	/**
	 * Create an LogicalErrorsListException with a message and a specific ErrorCode with singular display and resolution
	 * parameters
	 * 
	 * @param message The message to include with this exception
	 * @param errorCode The ErrorCode to include with this exception
	 * @param errorDisplayParameter The single parameter used as a substitution of the display message
	 * @param errorResolutionParameter The single parameter used as a substitution of the resolution message
	 */
	public LogicalErrorsListException(String message, ErrorCode errorCode, String errorDisplayParameter,
			String errorResolutionParameter)
	{
		super(message, errorCode, errorDisplayParameter, errorResolutionParameter);
	}

	/**
	 * Create an LogicalErrorsListException with a specific ErrorCode and message
	 * 
	 * @param message The message to include with this exception
	 * @param errorCode The ErrorCode to include with this exception
	 */
	public LogicalErrorsListException(String message, ErrorCode errorCode)
	{
		super(message, errorCode);
	}

	/**
	 * Create a complete LogicalErrorsListException with all possible parameters
	 * 
	 * @param message The message to include with this exception
	 * @param cause An exception that predicated the need to throw this exception
	 * @param errorCode The ErrorCode to include with this exception
	 * @param errorDisplayParameters An array of parameters used as a substitution of the display message
	 * @param errorResolutionParameters An array of parameters used as a substitution of the resolution message
	 */
	public LogicalErrorsListException(String message, Throwable cause, ErrorCode errorCode,
			Object[] errorDisplayParameters, Object[] errorResolutionParameters)
	{
		super(message, cause, errorCode, errorDisplayParameters, errorResolutionParameters);
	}

	/**
	 * Create an LogicalErrorsListException with a message, cause, and a specific ErrorCode with singular display and resolution
	 * parameters
	 * 
	 * @param message The message to include with this exception
	 * @param cause An exception that predicated the need to throw this exception
	 * @param errorCode The ErrorCode to include with this exception
	 * @param errorDisplayParameter The single parameter used as a substitution of the display message
	 * @param errorResolutionParameter The single parameter used as a substitution of the resolution message
	 */
	public LogicalErrorsListException(String message, Throwable cause, ErrorCode errorCode,
			String errorDisplayParameter, String errorResolutionParameter)
	{
		super(message, cause, errorCode, errorDisplayParameter, errorResolutionParameter);
	}

	/**
	 * Create a generic LogicalErrorsListException caused by another exception with a message and a 
	 * specific error code
	 * 
	 * @param message The message to include with this exception
	 * @param cause An exception that predicated the need to throw this exception
	 * @param errorCode The ErrorCode to include with this exception
	 */
	public LogicalErrorsListException(String message, Throwable cause, ErrorCode errorCode)
	{
		super(message, cause, errorCode);
	}

	/**
	 * Create a generic LogicalErrorsListException caused by another exception with a message and a 
	 * ErrorCode.SYSTEM_ERROR error code
	 * 
	 * @param message The message to include with this exception
	 * @param cause An exception that predicated the need to throw this exception
	 */
	public LogicalErrorsListException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Create an LogicalErrorsListException with a ErrorCode.SYSTEM_ERROR error code and a specific message
	 * 
	 * @param message The message to include with this exception
	 */
	public LogicalErrorsListException(String message)
	{
		super(message);
	}

	/**
	 * Create a generic LogicalErrorsListException caused by another exception with a specific error code
	 * 
	 * @param cause An exception that predicated the need to throw this exception
	 * @param errorCode The ErrorCode to include with this exception
	 */
	public LogicalErrorsListException(Throwable cause, ErrorCode errorCode)
	{
		super(cause, errorCode);
	}

	/**
	 * Create a generic LogicalErrorsListException caused by another exception with a ErrorCode.SYSTEM_ERROR error code
	 * 
	 * @param cause An exception that predicated the need to throw this exception
	 */
	public LogicalErrorsListException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @return the errorsList
	 */
	public List<String> getErrorsList() 
	{
		return errorsList;
	}

	/**
	 * @param errorsList the errorsList to set
	 */
	public void setErrorsList(List<String> errorsList) 
	{
		this.errorsList = errorsList;
	}
}
