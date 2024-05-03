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
 */
public interface CommonUser extends Serializable
{
	String getEmail();
	
	String getAgencyId();
	
	String getAgencyName();
	
	String getDisplayName();
	
	CommonRole getRole();

	Object getId();

	Object getName();
}
