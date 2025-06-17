/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2022 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

/**
 * Model object containing the details of an error in a request
 *
 * @author John.Murray
 *
 * @since Sep 9, 2022
 *
 */
@JsonInclude(Include.NON_NULL)
public class ErrorResponse 
{
	@Schema(description = "Http Status code of the response", example = "400")
	private final int httpStatus;
	
	@Schema(accessMode = AccessMode.READ_ONLY, description = "MOUS application error code for tracing", 
			example = "2000")
	private final int errorCode;
	
	@Schema(accessMode = AccessMode.READ_ONLY, description = "A user friendly message of the error encountered", 
			example = "Quote Body Invalid")
	private final String errorDisplay;
	
	@Schema(accessMode = AccessMode.READ_ONLY, description = "A user friendly message on how to resolve the error", 
			example = "The user you have selected is not a valid user")
	private final String errorResolution;
	
	@Schema(accessMode = AccessMode.READ_ONLY, 
			description = "Further details on this error. Not commonly used. Do not count on this being populated", 
			example = "Not normally included")
	private final String moreInfo;
	
	/**
	 * Build a ErrorResponse
	 * 
	 * @param errorCode The error code to use
	 */
	public ErrorResponse(ErrorCode errorCode)
	{
		this(errorCode.getHttpStatus(), errorCode);
	}
	
	/**
	 * Build a ErrorResponse
	 * 
	 * @param status The HttpStatus to use in the response
	 * @param errorCode The error code to use
	 */
	public ErrorResponse(HttpStatus status, ErrorCode errorCode)
	{
		this(status, errorCode.getCode(), null, null);
	}
	
	/**
	 * Build a generic ErrorResponse from an Exception
	 * 
	 * @param ex The Exception to display
	 */
	public ErrorResponse(Exception ex)
	{
		this(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCode.SYSTEM_ERROR.getCode(), ex.getMessage(), null);
	}
	
	/**
	 * Build a ErrorResponse
	 * 
	 * @param status The HttpStatus to use in the response
	 * @param errorCode The error code number to use
	 */
	public ErrorResponse(HttpStatus status, int errorCode)
	{
		this(status, errorCode, null, null);
	}
	
	/**
	 * Build a ErrorResponse
	 * 
	 * @param status The HttpStatus to use in the response
	 * @param errorCode The error code number to use
	 * @param errorDisplay The display message of the error
	 * @param errorResolution The resolution message of the error
	 */
	public ErrorResponse(HttpStatus status, int errorCode, String errorDisplay, String errorResolution)
	{
		this(status, errorCode, errorDisplay, errorResolution, null);
	}
	
	/**
	 * Build a ErrorResponse
	 * 
	 * @param statusCode The HttpStatusCode to use in the response
	 * @param errorCode The error code number to use
	 * @param errorDisplay The display message of the error
	 * @param errorResolution The resolution message of the error
	 */
	public ErrorResponse(HttpStatusCode statusCode, int errorCode, String errorDisplay, String errorResolution)
	{
		this(HttpStatus.valueOf(statusCode.value()), errorCode, errorDisplay, errorResolution, null);
	}
	
	/**
	 * Build a ErrorResponse
	 * 
	 * @param status The HttpStatus to use in the response
	 * @param errorCode The error code number to use
	 * @param errorDisplay The display message of the error
	 * @param errorResolution The resolution message of the error
	 * @param moreInfo Any additional information provided in the response
	 */
	public ErrorResponse(HttpStatus status, int errorCode, String errorDisplay, String errorResolution, 
			String moreInfo)
	{
		if(status == null)
		{
			throw new IllegalArgumentException("HttpStatus must be provided");
		}
		this.httpStatus = status.value();
		this.errorCode = errorCode;
		this.errorDisplay = errorDisplay;
		this.errorResolution = errorResolution;
		this.moreInfo = moreInfo;
	}

	/**
	 * Getter for attribute httpStatus
	 *
	 * @return the httpStatus
	 */
	public int getHttpStatus()
	{
		return this.httpStatus;
	}

	/**
	 * Getter for attribute errorCode
	 *
	 * @return the errorCode
	 */
	public int getErrorCode()
	{
		return this.errorCode;
	}

	/**
	 * Getter for attribute errorDisplay
	 *
	 * @return the errorDisplay
	 */
	public String getErrorDisplay()
	{
		return this.errorDisplay;
	}

	/**
	 * Getter for attribute errorResolution
	 *
	 * @return the errorResolution
	 */
	public String getErrorResolution()
	{
		return this.errorResolution;
	}

	/**
	 * Getter for attribute moreInfo
	 *
	 * @return the moreInfo
	 */
	public String getMoreInfo()
	{
		return this.moreInfo;
	}
}
