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
package com.sobetech.common.model.annotation.sql;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation to use on a search criteria field to tell a criteria builder that this be used to build a 
 * 'OR' criteria.
 * 
 * Example: The search criteria field is called name. You want to see if the name is equal to the 
 * first name or the last name. 
 *
 * @author John Murray
 *
 * @since Jun 9, 2024
 *
 */
@Documented
@Inherited
@Retention(RUNTIME)
@Target(FIELD)
public @interface OrCriteria
{
	/**
	 * The first field name in the model object to attempt to match
	 * 
	 * @return The first field name in the model object to attempt to match
	 */
	String firstFieldName();
	
	/**
	 * The second field name in the model object to attempt to match
	 * 
	 * @return The second field name in the model object to attempt to match
	 */
	String secondFieldName();
}
