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

/**
 * The basis of a tenant in any multi-tenant application
 *
 * @author John.Murray
 *
 * @since Jan 26, 2024
 *
* @param <I> The object used as the ID for the user. Number, UUID, String, etc.
 */
public interface CommonTenant<I extends Object>
{
	/**
	 * The Auth Key this tenant has for access
	 * 
	 * @return The Auth Key this tenant has for access
	 */
	String getAuthKey();
	
	/**
	 * Get the ID for this user
	 * 
	 * @return The user's ID
	 */
	I getId();
}
