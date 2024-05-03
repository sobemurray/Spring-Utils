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
}
