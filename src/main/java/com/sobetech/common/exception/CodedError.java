/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.exception;

import org.springframework.http.HttpStatus;

/**
 * An interface that contains all of the potential methods needed to access an
 * error that has a code. Most often, these kinds of errors will be enums, but
 * can be regular POJOs 
 *
 * @author John.Murray
 *
 * @since Mar 19, 2024
 *
 */
public interface CodedError
{
	/**
	 * Get the numeric error code
	 * 
	 * @return The numeric error code
	 */
	int getCode();
 
	/**
	 * Get the numeric error code as a String
	 * 
	 * @return The numeric error code as a String
	 */
	default String getStringCode()
	{
		return String.valueOf(getCode());
	}

	/**
	 * Get the HttpStatus associated with this error
	 * 
	 * @return The HttpStatus associated with this error
	 */
	HttpStatus getHttpStatus(); 
	
	/**
	 * Are these two equal. It is determined by the equality of the codes. If null is 
	 * passed, false is returned
	 * 
	 * @param codedError The CodedError to check for equality
	 * @return <code>true</code> only of if the codes are equal
	 */
	default boolean equals(CodedError codedError)
	{
		if(codedError == null)
		{
			return false;
		}
		
		return this.getCode() == codedError.getCode();
	}
}
