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
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for when object cannot be found
 *
 * @author John Murray
 *
 */

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Entity not found")
public class EntityNotFoundException extends ApiRuntimeException 
{
	private static final long serialVersionUID = 1392039531666321901L;

	/**
	 * A default constructor that will set the error code to ErrorCode.ENTITY_NOT_FOUND
	 */
	public EntityNotFoundException()
	{
		super(ErrorCode.ENTITY_NOT_FOUND);
	}

	/**
	 * A constructor that will set the error code to ErrorCode.ENTITY_NOT_FOUND and a readable
	 * version of the entity type that will be used in messaging
	 * 
	 * @param entityType A readable version of the entity type that will be used in messaging
	 */
	public EntityNotFoundException(String entityType)
	{
		super(entityType, ErrorCode.ENTITY_NOT_FOUND, new String[] {entityType}, new String[] {entityType});
	}
}
