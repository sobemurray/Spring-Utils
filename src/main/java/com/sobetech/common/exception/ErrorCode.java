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
	BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED),
	FORBIDDEN(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN),
	NOT_FOUND(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND),
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED),
	NOT_ACCEPTABLE(HttpStatus.NOT_ACCEPTABLE.value(), HttpStatus.NOT_ACCEPTABLE),
	CONFLICT(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT),
	PAYLOAD_TOO_LARGE(HttpStatus.PAYLOAD_TOO_LARGE.value(), HttpStatus.PAYLOAD_TOO_LARGE),
	UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY.value(), HttpStatus.UNPROCESSABLE_ENTITY),
	LOCKED(HttpStatus.LOCKED.value(), HttpStatus.LOCKED),
	
	/*
	 * API System Issues
	 * 1000 - 1999
	 */
	
	SYSTEM_ERROR(1000, HttpStatus.INTERNAL_SERVER_ERROR),
	PROVIDER_CALL_FAILURE(1001, HttpStatus.INTERNAL_SERVER_ERROR),
	CALLBACK_TIMEOUT(1002, HttpStatus.INTERNAL_SERVER_ERROR),
	QUOTE_ENGINE_CREDENTIALS_FAILURE(1003, HttpStatus.INTERNAL_SERVER_ERROR),
	QUOTE_ENGINE_CREDENTIALS_FAILURE_WITH_DETAILS(1004, HttpStatus.INTERNAL_SERVER_ERROR),
	CALLBACK_FAILURE(1005, HttpStatus.INTERNAL_SERVER_ERROR),
	SELECT_NOT_APPLICABLE(1006, HttpStatus.BAD_REQUEST),
	ISSUE_NOT_APPLICABLE(1007, HttpStatus.BAD_REQUEST),
	CARRIER_CONFIGUATION_ERROR(1008, HttpStatus.INTERNAL_SERVER_ERROR),
	FILE_LOADING_ERROR(1009, HttpStatus.INTERNAL_SERVER_ERROR),
	FILE_WRITING_ERROR(1010, HttpStatus.INTERNAL_SERVER_ERROR),
	
	/*
	 * General Domain and Entity based errors
	 * 
	 * 2000 - 2999
	 */
	//TODO replace many of the HttpStatus.BAD_REQUEST with HttpStatus.UNPROCESSABLE_ENTITY
	MALFORMED_ENITIY(2000, HttpStatus.BAD_REQUEST),
	DUPLICATE_ENITIY(2001, HttpStatus.BAD_REQUEST),
	MISSING_ATTRIBUTE(2002, HttpStatus.BAD_REQUEST),
	DATE_FORMAT_ERROR(2003, HttpStatus.BAD_REQUEST),
	MISSING_ENTITY(2004, HttpStatus.BAD_REQUEST),
	STATUS_INVALID(2005, HttpStatus.BAD_REQUEST),
	ROLE_MISSING(2006, HttpStatus.INTERNAL_SERVER_ERROR),
	USER_INVALID(2007, HttpStatus.BAD_REQUEST),
	INVALID_ATTRIBUTE(2008, HttpStatus.BAD_REQUEST),
	ATTRIBUTE_CONFLICT(2009, HttpStatus.BAD_REQUEST),
	VALIDATION_FAILURE(2010, HttpStatus.BAD_REQUEST),
	INVALID_ENUM(2011, HttpStatus.BAD_REQUEST),
	CALLBACK_INVALID_METHOD(2012, HttpStatus.METHOD_NOT_ALLOWED),
	INVALID_ATTRIBUTE_VALUE(2013, HttpStatus.BAD_REQUEST),
	CONDO_NOT_ALLOWED(2014, HttpStatus.BAD_REQUEST),
	XML_MAPPING_FAILURE(2015, HttpStatus.INTERNAL_SERVER_ERROR),
	TENANT_CONFIGURATION(2016, HttpStatus.UNPROCESSABLE_ENTITY),
	INVALID_FORMAT(2017, HttpStatus.BAD_REQUEST),
	INVALID_YEAR(2018, HttpStatus.UNPROCESSABLE_ENTITY),
	INVALID_MONTH(2019, HttpStatus.UNPROCESSABLE_ENTITY),
	ENTITY_ALREADY_PROCESSED(2020, HttpStatus.UNPROCESSABLE_ENTITY),

	/*
	 * Application security based errors
	 * 3000 - 3999
	 */
	TOKEN_ERROR(3000, HttpStatus.INTERNAL_SERVER_ERROR),
	MISSING_TOKEN(3001, HttpStatus.UNAUTHORIZED),
	UNKNOWN_TOKEN_TYPE(3002, HttpStatus.BAD_REQUEST),
	MISSMATCHED_TOKEN_TYPE(3003, HttpStatus.BAD_REQUEST),
	EXPIRED_TOKEN(3004, HttpStatus.UNAUTHORIZED),
	UNKNOWN_TENANT(3005, HttpStatus.UNAUTHORIZED),
	DISABLED_TENANT(3006, HttpStatus.UNAUTHORIZED),

	/*
	 * External System based errors
	 * 4000 - 4999
	 */
	GENERIC_CARRIER_ERROR(4000, HttpStatus.SERVICE_UNAVAILABLE),
	CARRIER_AUTH_ERROR(4001, HttpStatus.SERVICE_UNAVAILABLE),
	HISCOX_QUOTE_ERROR(4002, HttpStatus.SERVICE_UNAVAILABLE),
	HISCOX_FIND_ERROR(4003, HttpStatus.SERVICE_UNAVAILABLE),
	HISCOX_BIND_ERROR(4004, HttpStatus.SERVICE_UNAVAILABLE),
	AZURE_USER_UPDATE_ERROR(4005, HttpStatus.BAD_REQUEST),
	AZURE_USER_CREATE_ERROR(4006, HttpStatus.BAD_REQUEST),
	AZURE_USER_MISSING_ERROR(4007, HttpStatus.BAD_REQUEST),
	CHUBB_FIND_ERROR(4008, HttpStatus.SERVICE_UNAVAILABLE),
	WRIGHT_FLOOD_ID_MISSING(4009, HttpStatus.UNAUTHORIZED),
	WRIGHT_FLOOD_AUTH_ERROR(4010, HttpStatus.BAD_REQUEST),
	WRIGHT_FLOOD_LENDER_ERROR(4011, HttpStatus.BAD_REQUEST),
	CARRIER_QUOTING_ERROR(4012, HttpStatus.BAD_REQUEST),
	CARRIER_UNKNOWN_ERROR(4013, HttpStatus.BAD_REQUEST),
	CARRIER_QUOTING_ERROR_NO_RESOLUTION(4014, HttpStatus.BAD_REQUEST),
	
	/*
	 * Logic based errors
	 * 5000 - 5999
	 */
	MALFORMED_ARGUMENT(5000, HttpStatus.BAD_REQUEST),
	AGENCY_CONFIG_NEEDED(5001, HttpStatus.UNAUTHORIZED),
	UPLOAD_FAILED(5002, HttpStatus.INTERNAL_SERVER_ERROR),
	EMAIL_FAILED(5003, HttpStatus.INTERNAL_SERVER_ERROR),
	STATUS_INVALID_FOR_OPERATION(5004, HttpStatus.BAD_REQUEST),
	FEE_CALCULATION_FAILURE(5005, HttpStatus.INTERNAL_SERVER_ERROR),
	FEE_SCHEDULE_UNAVAILABLE(5006, HttpStatus.INTERNAL_SERVER_ERROR),
	RATE_OPTIONS_ERROR(5007, HttpStatus.INTERNAL_SERVER_ERROR),
	RANGE_GAP(5008, HttpStatus.BAD_REQUEST),
	RANGE_OVERLAP(5009, HttpStatus.BAD_REQUEST),
	DATE_PAST(5010, HttpStatus.BAD_REQUEST),
	DATE_FUTURE(5011, HttpStatus.BAD_REQUEST),
	DATES_BEFORE(5012, HttpStatus.BAD_REQUEST),
	RISK_ADDRESS_UPDATED(5013, HttpStatus.UNPROCESSABLE_ENTITY),
	UNKNOWN_AGENT_PROCESSING(5014, HttpStatus.CONFLICT),
	OBJECT_MISSING_ATTRIBUTE(5015, HttpStatus.UNPROCESSABLE_ENTITY),
	INVALID_POLICY_TYPE(5016, HttpStatus.UNPROCESSABLE_ENTITY),
	LARGER_THAN(5017, HttpStatus.UNPROCESSABLE_ENTITY),
	LESS_THAN(5018, HttpStatus.UNPROCESSABLE_ENTITY),
	EQUALS(5019, HttpStatus.UNPROCESSABLE_ENTITY),
	NOT_EQUALS(5020, HttpStatus.UNPROCESSABLE_ENTITY),
	
	/*
	 * Auto model object errors
	 * 6000 - 6999
	 */
	INVALID_VIN(6005, HttpStatus.BAD_REQUEST),
	
	/*
	 * HO model object errors
	 * 7000 - 7999
	 */
	RENO_DATE_BEFORE_BUILD(7005, HttpStatus.BAD_REQUEST),
	
	/*
	 * Concept One errors
	 * 7000 - 7999
	 */
	C1_SERVER_NOT_FOUND(8000, HttpStatus.NOT_FOUND),
	C1_BROKER_NOT_FOUND(8001, HttpStatus.NOT_FOUND),
	AGENCY_ID_TOO_LONG(8002, HttpStatus.UNPROCESSABLE_ENTITY);
	
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
