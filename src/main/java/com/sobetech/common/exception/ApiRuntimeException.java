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

/**
 * A RuntimeException for all possible exceptions in the API. This can be used by itself as well as being extended
 * for specific instances
 * 
 * @author John.Murray
 *
 */
public class ApiRuntimeException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -46660060574162151L;
	
	private final String message;
	
	private final CodedError codedError;
	
	private Object[] errorDisplayParameters;
	
	private Object[] errorResolutionParameters;

	/**
	 * Create a generic ApiRuntimeException with a ErrorCode.SYSTEM_ERROR error code
	 */
	public ApiRuntimeException()
	{
		this(ErrorCode.SYSTEM_ERROR);
	}
	
	/**
	 * Create an ApiRuntimeException with a ErrorCode.SYSTEM_ERROR error code and a specific message
	 * 
	 * @param message The message to include with this exception
	 */
	public ApiRuntimeException(String message)
	{
		this(message, ErrorCode.SYSTEM_ERROR);
	}
	
	/**
	 * Create an ApiRuntimeException with a specific ErrorCode
	 * 
	 * @param codedError The CodedError to include with this exception
	 */
	public ApiRuntimeException(CodedError codedError)
	{
		this(codedError.toString(), codedError);
	}
	
	/**
	 * Create an ApiRuntimeException with a specific ErrorCode and message
	 * 
	 * @param message The message to include with this exception
	 * @param codedError The CodedError to include with this exception
	 */
	public ApiRuntimeException(String message, CodedError codedError)
	{
		this(message, codedError, (String)null, (String)null);
	}
	
	/**
	 * Create an ApiRuntimeException with a specific ErrorCode with singular display and resolution
	 * parameters
	 * 
	 * @param codedError The CodedError to include with this exception
	 * @param errorDisplayParameter The single parameter used as a substitution of the display message
	 * @param errorResolutionParameter The single parameter used as a substitution of the resolution message
	 */
	public ApiRuntimeException(CodedError codedError, String errorDisplayParameter, String errorResolutionParameter)
	{
		this(codedError.toString(), codedError, errorDisplayParameter, errorResolutionParameter);
	}
	
	/**
	 * Create an ApiRuntimeException with a specific ErrorCode with any number of parameters of a type
	 * 
	 * @param codedError The CodedError to include with this exception
	 * @param parameterType The type of parameter used for substitution in building the message
	 * @param parameters The parameters used for substitution in building the message
	 */
	public ApiRuntimeException(CodedError codedError, ExceptionParameterType parameterType, String... parameters)
	{
		this(codedError);
		switch(parameterType)
		{
			case DISPLAY:
				this.errorDisplayParameters = parameters;
				break;
				
			case RESOLUTION:
				this.errorResolutionParameters = parameters;
				break;
				
			default:
				break;
		
		}
	}
	
	/**
	 * Create an ApiRuntimeException with a message and a specific ErrorCode with singular display and resolution
	 * parameters
	 * 
	 * @param message The message to include with this exception
	 * @param codedError The CodedError to include with this exception
	 * @param errorDisplayParameter The single parameter used as a substitution of the display message
	 * @param errorResolutionParameter The single parameter used as a substitution of the resolution message
	 */
	public ApiRuntimeException(String message, CodedError codedError, String errorDisplayParameter, String errorResolutionParameter)
	{
		this(message, codedError, new String[] { errorDisplayParameter },  new String[] { errorResolutionParameter });
	}
	
	/**
	 * Create an ApiRuntimeException with a message, cause, and a specific ErrorCode with singular display and resolution
	 * parameters
	 * 
	 * @param message The message to include with this exception
	 * @param cause An exception that predicated the need to throw this exception
	 * @param codedError The CodedError to include with this exception
	 * @param errorDisplayParameter The single parameter used as a substitution of the display message
	 * @param errorResolutionParameter The single parameter used as a substitution of the resolution message
	 */
	public ApiRuntimeException(String message, Throwable cause, CodedError codedError, String errorDisplayParameter, String errorResolutionParameter)
	{
		this(message, cause, codedError, new String[] { errorDisplayParameter },  new String[] { errorResolutionParameter });
	}

	/**
	 * Create an ApiRuntimeException with a specific ErrorCode with any number of display and resolution
	 * parameters
	 * 
	 * @param codedError The CodedError to include with this exception
	 * @param errorDisplayParameters An array of parameters used as a substitution of the display message
	 * @param errorResolutionParameters An array of parameters used as a substitution of the resolution message
	 */
	public ApiRuntimeException(CodedError codedError, Object[] errorDisplayParameters, Object[] errorResolutionParameters)
	{
		this(codedError.toString(), codedError, errorDisplayParameters, errorResolutionParameters);
	}

	/**
	 * Create an ApiRuntimeException with a message and a specific ErrorCode with any number of display and resolution
	 * parameters
	 * 
	 * @param message The message to include with this exception
	 * @param codedError The CodedError to include with this exception
	 * @param errorDisplayParameters An array of parameters used as a substitution of the display message
	 * @param errorResolutionParameters An array of parameters used as a substitution of the resolution message
	 */
	public ApiRuntimeException(String message, CodedError codedError, Object[] errorDisplayParameters, Object[] errorResolutionParameters)
	{
		this(message, null, codedError, errorDisplayParameters, errorResolutionParameters);
	}

	/**
	 * Create a generic ApiRuntimeException caused by another exception with a ErrorCode.SYSTEM_ERROR error code
	 * 
	 * @param cause An exception that predicated the need to throw this exception
	 */
	public ApiRuntimeException(Throwable cause) 
	{
		this(cause.getMessage(), cause);
	}

	/**
	 * Create a generic ApiRuntimeException caused by another exception with a specific error code
	 * 
	 * @param cause An exception that predicated the need to throw this exception
	 * @param codedError The CodedError to include with this exception
	 */
	public ApiRuntimeException(Throwable cause, CodedError codedError) 
	{
		this(cause.getMessage(), cause, codedError);
	}

	/**
	 * Create a generic ApiRuntimeException caused by another exception with a message and a 
	 * ErrorCode.SYSTEM_ERROR error code
	 * 
	 * @param message The message to include with this exception
	 * @param cause An exception that predicated the need to throw this exception
	 */
	public ApiRuntimeException(String message, Throwable cause) 
	{
		this(message, cause, ErrorCode.SYSTEM_ERROR);
	}

	/**
	 * Create a generic ApiRuntimeException caused by another exception with a message and a 
	 * specific error code
	 * 
	 * @param message The message to include with this exception
	 * @param cause An exception that predicated the need to throw this exception
	 * @param codedError The CodedError to include with this exception
	 */
	public ApiRuntimeException(String message, Throwable cause, CodedError codedError) 
	{
		this(message, cause, codedError, (String[])null, (String[])null);
	}
	
	/**
	 * Create a complete ApiRuntimeException with all possible parameters
	 * 
	 * @param message The message to include with this exception
	 * @param cause An exception that predicated the need to throw this exception
	 * @param codedError The CodedError to include with this exception
	 * @param errorDisplayParameters An array of parameters used as a substitution of the display message
	 * @param errorResolutionParameters An array of parameters used as a substitution of the resolution message
	 */
	public ApiRuntimeException(String message, Throwable cause, CodedError codedError, Object[] errorDisplayParameters, Object[] errorResolutionParameters)
	{
		super(message, cause);
		this.message = message;
		if(codedError == null)
		{
			codedError = ErrorCode.SYSTEM_ERROR;
		}
		this.codedError = codedError;
		this.errorDisplayParameters = errorDisplayParameters;
		this.errorResolutionParameters = errorResolutionParameters;
	}

	/**
	 * The message for this exception
	 * 
	 * @return the message
	 */
	@Override
	public String getMessage() 
	{
		return message;
	}

	/**
	 * The CodedError for this exception
	 * 
	 * @return the codedError
	 */
	public CodedError getCodedError() 
	{
		return codedError;
	}

	/**
	 * The errorDisplayParameters for this exception
	 * 
	 * @return the errorDisplayParameters
	 */
	public Object[] getErrorDisplayParameters() 
	{
		return errorDisplayParameters;
	}

	/**
	 * The errorResolutionParameters for this exception
	 * 
	 * @return the errorResolutionParameters
	 */
	public Object[] getErrorResolutionParameters() 
	{
		return errorResolutionParameters;
	}
}
