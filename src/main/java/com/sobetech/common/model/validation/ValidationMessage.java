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
package com.sobetech.common.model.validation;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.sobetech.common.enums.ValidationType;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Details of a validation error
 *
 *
 * @author John.Murray
 *
 * @since Sep 9, 2022
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Details of a validation request")
public class ValidationMessage 
{
	@Schema(description = "The type of validation that failed", example = "Null")
	private final ValidationType type;
	
	@Schema(description = "Where in the object tree or JSON payload the validation failed", example = "locationAddress.state")
	private final String location;
	
	@Schema(description = "A user friendly message of the failed validation that can be displayed", example = "State must not be null")
	private final String message;
	
	public ValidationMessage(ValidationType type, String location, String message) 
	{
		this.type = type;
		this.location = location;
		this.message = message;
	}
	
	public ValidationType getType()
	{
		return type;
	}
	
	public String getLocation() 
	{
		return location;
	}
	
	public String getMessage()
	{
		return message;
	}
}
