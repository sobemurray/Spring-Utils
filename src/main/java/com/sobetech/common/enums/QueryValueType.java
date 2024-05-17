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
package com.sobetech.common.enums;

/**
 * Type of query value that will be used in any database query
 *
 * @author Nicholas.Peterson
 *
 * @since May 24, 2023
 *
 */
public enum QueryValueType
{
	/**
	 * String type
	 */
	STRING, 
	
	/**
	 * Integer type
	 */
	INT, 
	
	/**
	 * Long integer type
	 */
	LONG, 
	
	/**
	 * A number type, integer or decimal
	 */
	NUMBER, 
	
	/**
	 * Date type
	 */
	DATE,
	
	/**
	 * Array type
	 */
	ARRAY;
}
