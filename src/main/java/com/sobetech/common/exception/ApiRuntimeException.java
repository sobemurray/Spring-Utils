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
package com.sobetech.common.exception;

/**
 * A specific RuntimeException used for exceptions in an API
 *
 * @author John Murray
 *
 * @since Apr 28, 2024
 *
 */
public class ApiRuntimeException extends RuntimeException
{

	/**
	 * 
	 */
	public ApiRuntimeException()
	{
	}

	/**
	 * @param message
	 */
	public ApiRuntimeException(String message)
	{
		super(message);
	}

	/**
	 * @param cause
	 */
	public ApiRuntimeException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApiRuntimeException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ApiRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
