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

import java.util.Collection;

import org.springframework.http.HttpStatus;

import com.sobetech.common.model.validation.ValidationResult;

/**
 * An ErrorResponse for when a validation fails and it contains a number of specific errors that 
 *
 * @author John Murray
 *
 * @since Jun 3, 2024
 *
 */
public class ValidationErrorResponse extends ErrorResponse
{
	private final Collection<String> validationMessages;
	
	private final Collection<CodedError> childErrors;
	
	public ValidationErrorResponse(ValidationResult validationResult)
	{
		super(HttpStatus.UNPROCESSABLE_ENTITY, ErrorCode.MALFORMED_ENITIY.getCode(), 
				"The " + validationResult.getObjectTypeBeingValidated() + " sent could not be validated", 
				"Please address these issues and try again");
		
		this.validationMessages = validationResult.getMessages();
		
		this.childErrors = validationResult.getErrors();
	}

	/**
	 * Getter for attribute validationMessages
	 *
	 * @return the validationMessages
	 */
	public Collection<String> getValidationMessages()
	{
		return this.validationMessages;
	}

	/**
	 * Getter for attribute childErrors
	 *
	 * @return the childErrors
	 */
	public Collection<CodedError> getChildErrors()
	{
		return this.childErrors;
	}
}
