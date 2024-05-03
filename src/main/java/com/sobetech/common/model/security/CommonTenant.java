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
 */
public interface CommonTenant
{
	String getAuthKey();
	
	String getId();
}
