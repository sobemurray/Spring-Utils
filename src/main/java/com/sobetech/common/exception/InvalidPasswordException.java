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
 * Response for when password is invalid
 *
 * @author John Murray
 *
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Password is Invalid")
public class InvalidPasswordException extends RuntimeException 
{
	private static final long serialVersionUID = 7499197086589273875L;
}
