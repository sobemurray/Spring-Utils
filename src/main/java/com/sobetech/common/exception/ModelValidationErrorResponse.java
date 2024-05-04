/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2023 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Model object extension that displays validation errors
 *
 * @author Nicholas.Peterson
 *
 * @since Dec 6, 2023
 *
 */
@JsonInclude(Include.NON_NULL)
public class ModelValidationErrorResponse extends ErrorResponse
{

	@Schema(description = "List containing strings of failed model valdiations")
	private final List<String> validationErrorList;
	
	public ModelValidationErrorResponse(HttpStatus status, int errorCode, String errorDisplay, String errorResolution,
			List<String> validations)
	{
		super(status, errorCode, errorDisplay, errorResolution);
		this.validationErrorList = validations;
	}

	/**
	 * Getter for attribute validationErrorMap
	 *
	 * @return the validationErrorMap
	 */
	public List<String> getValidationErrorMap()
	{
		return this.validationErrorList;
	}
}
