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
package com.sobetech.common.enums;

/**
 * A StringEnum that also has an alternative description. Therefore there are 2 strings associated with
 * this enum. A String value and a String description
 *
 * @author John.Murray
 *
 * @since Jan 22, 2024
 *
 */
public interface StringDescriptionEnum extends StringEnum
{
	/**
	 * Gets the description String value of the Enum
	 * 
	 * @return The description String value of the Enum
	 */
	String getDescription();
}
