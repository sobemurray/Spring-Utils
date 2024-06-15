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

import org.springframework.http.HttpStatus;

import com.sobetech.common.enums.CodedEnum;

/**
 * An Enum for errors occurring in the API. Use this for regular exceptions as well as runtime exceptions
 * 
 * @author John.Murray
 *
 */
public enum ErrorCode implements CodedEnum, CodedError
{
	/*
	 * These are error codes that match HTTP Status codes
	 * 
	 * < 1000
	 */
	
	/**
	 * Mirror of HttpStatus.BAD_REQUEST
	 */
	BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST),
	
	/**
	 * Mirror of HttpStatus.UNAUTHORIZED
	 */
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED),
	
	/**
	 * Mirror of HttpStatus.FORBIDDEN
	 */
	FORBIDDEN(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN),
	
	/**
	 * Mirror of HttpStatus.NOT_FOUND
	 */
	NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND),
	
	/**
	 * Mirror of HttpStatus.METHOD_NOT_ALLOWED
	 */
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED),
	
	/**
	 * Mirror of HttpStatus.NOT_ACCEPTABLE
	 */
	NOT_ACCEPTABLE(HttpStatus.NOT_ACCEPTABLE.value(), HttpStatus.NOT_ACCEPTABLE),
	
	/**
	 * Mirror of HttpStatus.CONFLICT
	 */
	CONFLICT(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT),
	
	/**
	 * Mirror of HttpStatus.PAYLOAD_TOO_LARGE
	 */
	PAYLOAD_TOO_LARGE(HttpStatus.PAYLOAD_TOO_LARGE.value(), HttpStatus.PAYLOAD_TOO_LARGE),

	/**
	 * Mirror of HttpStatus.UNPROCESSABLE_ENTITY
	 */
	UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * Mirror of HttpStatus.LOCKED
	 */
	LOCKED(HttpStatus.LOCKED.value(), HttpStatus.LOCKED),
	
	/*
	 * API System Issues
	 * 1000 - 1999
	 */
	
	/**
	 * A generic system error has occurred and a 500 will be returned
	 */
	SYSTEM_ERROR(1000, HttpStatus.INTERNAL_SERVER_ERROR),
	
	/**
	 * An error has occurred when attempting to perform Reflection logic
	 */
	REFLECTION_ERROR(1001, HttpStatus.INTERNAL_SERVER_ERROR),
	
	/*
	 * General Domain and Entity based errors
	 * 
	 * 2000 - 2999
	 */
	
	/**
	 * The entity being processed is malformed
	 */
	MALFORMED_ENITIY(2000, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * There is a duplicate entity that is preventing the operation
	 */
	DUPLICATE_ENITIY(2001, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * There is an attribute missing from either the request or entity
	 */
	MISSING_ATTRIBUTE(2002, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * A date string has been sent that cannot be translated
	 */
	DATE_FORMAT_ERROR(2003, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * An entity that was expected is missing. This is generally used in missing body
	 */
	MISSING_ENTITY(2004, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * A role that was expected is missing
	 */
	ROLE_MISSING(2005, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * The user is invalid. Not to be used for permissions issues
	 */
	USER_INVALID(2006, HttpStatus.BAD_REQUEST),
	
	/**
	 * The value of an attribute is invalid. If there is a defined list of values for the attribute, use INVALID_ATTRIBUTE_VALUE
	 */
	INVALID_ATTRIBUTE(2007, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * Two attributes for an entity are in conflict
	 */
	ATTRIBUTE_CONFLICT(2008, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * A String that is trying to be translated into an Enum is invalid
	 */
	INVALID_ENUM(2009, HttpStatus.BAD_REQUEST),
	
	/**
	 * The value of an attribute is invalid. This is different from INVALID_ATTRIBUTE, because the attribute in question 
	 * has a defined list of possible values
	 */
	INVALID_ATTRIBUTE_VALUE(2010, HttpStatus.BAD_REQUEST),

	/**
	 * This tenant is not configured and needs to be address before it can use the system. This is not a security issue, but 
	 * a configuration issue
	 */
	TENANT_CONFIGURATION(2011, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * The item in question is not in the correct format
	 */
	INVALID_FORMAT(2012, HttpStatus.BAD_REQUEST),
	
	/**
	 * The year that is being sent is not valid
	 */
	INVALID_YEAR(2013, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * The month that is being sent is not valid
	 */
	INVALID_MONTH(2014, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * The day that is being sent is not valid
	 */
	INVALID_DAY(2015, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * The parameter sent in the request is not valid
	 */
	INVALID_REQUEST_PARAMETER(2016, HttpStatus.UNPROCESSABLE_ENTITY),

	/*
	 * Application security based errors
	 * 3000 - 3999
	 */
	
	/**
	 * There is a generic issue with the token
	 */
	TOKEN_ERROR(3000, HttpStatus.INTERNAL_SERVER_ERROR),
	
	/**
	 * This operation requires a valid request token
	 */
	MISSING_TOKEN(3001, HttpStatus.UNAUTHORIZED),
	
	/**
	 * The token that was sent in the request is of an unknown type
	 */
	UNKNOWN_TOKEN_TYPE(3002, HttpStatus.BAD_REQUEST),
	
	/**
	 * The token that was sent in the request is not the correct type
	 */
	MISSMATCHED_TOKEN_TYPE(3003, HttpStatus.BAD_REQUEST),
	
	/**
	 * The token sent in the request has expired
	 */
	EXPIRED_TOKEN(3004, HttpStatus.UNAUTHORIZED),
	
	/**
	 * The tenant making the request is not known
	 */
	UNKNOWN_TENANT(3005, HttpStatus.UNAUTHORIZED),
	
	/**
	 * This tenant has been disabled from the system
	 */
	DISABLED_TENANT(3006, HttpStatus.UNAUTHORIZED),
	
	/**
	 * This login request has been denied
	 */
	LOGIN_DENIED(3007, HttpStatus.UNAUTHORIZED),
	
	/**
	 * This login request has been denied
	 */
	USER_LOGGED_OUT(3008, HttpStatus.UNAUTHORIZED),
	
	/**
	 * A new password request has a mismatch
	 */
	PASSWORD_MISMACH(3009, HttpStatus.BAD_REQUEST),

	/*
	 * External System based errors
	 * 4000 - 4999
	 */
	
	/**
	 * A general error has occurred calling an external system
	 */
	GENERIC_EXTERNAL_ERROR(4000, HttpStatus.SERVICE_UNAVAILABLE),
	
	/**
	 * The system had issues getting authorization from an external system
	 */
	AUTH_ERROR_EXTERNAL(4001, HttpStatus.SERVICE_UNAVAILABLE),
	
	/**
	 * The system had issues uploading to an external system
	 */
	UPLOAD_FAILED(4003, HttpStatus.SERVICE_UNAVAILABLE),
	
	/**
	 * The system had issues sending an email
	 */
	EMAIL_FAILED(4003, HttpStatus.SERVICE_UNAVAILABLE),
	
	/*
	 * Logic based errors
	 * 5000 - 5999
	 */
	
	/**
	 * The arguments for this method are not valid
	 */
	MALFORMED_ARGUMENT(5000, HttpStatus.BAD_REQUEST),
	
	/**
	 * The status of this object is invalid for the operation being requested
	 */
	STATUS_INVALID_FOR_OPERATION(5001, HttpStatus.BAD_REQUEST),

	/**
	 * If an entity has a list of attributes with ranges, this list has a gap in it that makes it invalid
	 */
	RANGE_GAP(5002, HttpStatus.BAD_REQUEST),
	
	/**
	 * If an entity has a list of attributes with ranges, this list has an overlap in it that makes it invalid
	 */
	RANGE_OVERLAP(5003, HttpStatus.BAD_REQUEST),
	
	/**
	 * This date attribute cannot be in the past
	 */
	DATE_PAST(5004, HttpStatus.BAD_REQUEST),

	/**
	 * This date attribute cannot be in the future
	 */
	DATE_FUTURE(5005, HttpStatus.BAD_REQUEST),

	/**
	 * This date attribute cannot be in the before another
	 */
	DATES_BEFORE(5006, HttpStatus.BAD_REQUEST),

	/**
	 * This date attribute cannot be in the before another
	 */
	DATES_AFTER(5007, HttpStatus.BAD_REQUEST),

	/**
	 * An attribute cannot be larger than another
	 */
	LARGER_THAN(5008, HttpStatus.UNPROCESSABLE_ENTITY),

	/**
	 * An attribute cannot be less than another
	 */
	LESS_THAN(5009, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/**
	 * An attribute cannot be equal another
	 */
	EQUALS(5010, HttpStatus.UNPROCESSABLE_ENTITY),

	/**
	 * An attribute must equal another
	 */
	NOT_EQUALS(5011, HttpStatus.UNPROCESSABLE_ENTITY);
	
	int code;
	
	HttpStatus httpStatus;
	
	private ErrorCode(int code, HttpStatus httpStatus)
	{
		this.code = code;
		this.httpStatus = httpStatus;
	}
	
	public static ErrorCode fromHttpStatus(HttpStatus httpStatus)
	{
		for(ErrorCode errorCode : ErrorCode.values())
		{
			if(errorCode.getCode() == httpStatus.value())
			{
				return errorCode;
			}
		}
		
		return SYSTEM_ERROR;
	}
	
	@Override
	public int getCode()
	{
		return this.code;
	}

	@Override
	public HttpStatus getHttpStatus() 
	{
		return this.httpStatus;
	}
}
