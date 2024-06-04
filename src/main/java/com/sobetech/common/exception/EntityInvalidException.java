/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Team Focus / Peak6, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.exception;

import com.sobetech.common.model.validation.ValidationResult;

/**
 * An ApiRuntimeException for when an Entity fails validation
 *
 * @author John Murray
 *
 * @since Jun 3, 2024
 *
 */
public class EntityInvalidException extends ApiRuntimeException
{
	private final ValidationResult validationResult;
	
	public EntityInvalidException(ValidationResult validationResult)
	{
		super(ErrorCode.MALFORMED_ENITIY);
		this.validationResult = validationResult;
	}

	/**
	 * Getter for attribute validationResult
	 *
	 * @return the validationResult
	 */
	public ValidationResult getValidationResult()
	{
		return this.validationResult;
	}
}
