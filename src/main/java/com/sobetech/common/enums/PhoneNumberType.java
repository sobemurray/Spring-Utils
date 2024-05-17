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
package com.sobetech.common.enums;

/**
 * An enum describing types of phone numbers
 *
 * @author John.Murray
 *
 * @since Jul 25, 2022
 *
 */
public enum PhoneNumberType
{
	/**
	 * Home number. Can be land line or mobile in nature
	 */
	HOME, 
	
	/**
	 * Business number. Can be land line or mobile in nature
	 */
	BUSINESS, 
	
	/**
	 * Mobile number
	 */
	MOBILE, 
	
	/**
	 * Fax number. These still exist. really
	 */
	FAX
}
