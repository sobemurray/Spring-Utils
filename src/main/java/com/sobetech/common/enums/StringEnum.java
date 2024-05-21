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
 * An interface used to indicate that an enum also has an alternative String value
 *
 * @author John.Murray
 *
 * @since Jul 27, 2022
 *
 */
//@JsonSerialize(using = StringEnumSerializer.class)
public interface StringEnum
{
	/**
	 * Gets the alternative String value of the Enum
	 * 
	 * @return The alternative String value of the Enum
	 */
	String getValue();
}
