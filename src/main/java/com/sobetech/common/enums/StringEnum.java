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
	 * Get the name of the Enum
	 * 
	 * @return The name of the Enum. The same as Enum.name()
	 */
	String name();
	
	/**
	 * Gets the alternative String value of the Enum
	 * 
	 * @return The alternative String value of the Enum
	 */
	String getDescription();
	
	/**
	 * Is this enum active. This came about from NFLTeams where we had to account for teams that no longer
	 * exist. They are still in the data, but shouldn't be included anymore
	 * 
	 * @return <code>true</code> if this enum is still active. Will return <code>true</code> unless overridden
	 */
	default boolean isActive()
	{
		return true;
	}
	
	/**
	 * Is this enum private. Some enums are only for internal consumption. This allows them to be flagged as private and not
	 * sent to things like a UI
	 * 
	 * @return <code>true</code> if this enum is private. Will return <code>false</code> unless overridden
	 */
	default boolean isPrivate()
	{
		return false;
	}
}
