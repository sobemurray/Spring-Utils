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
package com.sobetech.common.model.security;

import java.io.Serializable;

/**
 * The basis of all users in any system
 *
 * @author John.Murray
 *
 * @since Jan 26, 2024
 *
 * @param <I> The object used as the ID for the user. Number, UUID, String, etc.
 */
public interface CommonUser<I extends Object> extends Serializable
{

	/**
	 * Get the ID for this user
	 * 
	 * @return The user's ID
	 */
	I getId();
	
	/**
	 * The user's email address
	 * 
	 * @return The ID for this user
	 */
	String getEmail();
	
	/**
	 * The name to be displayed for this user
	 * 
	 * @return The name to be displayed for this user
	 */
	String getDisplayName();

	/**
	 * The user's name
	 * 
	 * @return The user's name
	 */
	String getName();
}
