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
package com.sobetech.common.service.spring;

/**
 * A service that will clean an Object's attributes
 *
 * @author John Murray
 *
 * @since Jun 19, 2024
 *
 *	@param <O> The type of object to be cleaned
 *
 */
public interface ObjectCleaner <O>
{
	/**
	 * Clean an object and populate missing or incorrect attributes of an object
	 * 
	 * @param objectToClean The object to clean
	 * @return The cleaned object
	 */
	O cleanAndPopulate(O objectToClean);
}