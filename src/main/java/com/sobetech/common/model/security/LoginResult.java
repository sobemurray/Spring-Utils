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
package com.sobetech.common.model.security;

/**
 * The positive results of a login request
 *
 * @author John Murray
 *
 * @since Jun 11, 2024
 *
 * @param <U> The User that will be returned as part of the result. The user
 * will be returned because it can contain data such as display names, user 
 * preferences, Roles, etc
 * 
 */
public class LoginResult <U extends CommonUser<?>>
{
	private final U user;

	private final String authToken;

	/**
	 * Construct a new LoginResult
	 * 
	 * @param user The user that logged in
	 * @param authToken The authToken that was generated from the login
	 */
	public LoginResult(U user, String authToken)
	{
		user.clearInternalFields();
		this.user = user;
		this.authToken = authToken;
	}

	/**
	 * Getter for attribute user
	 *
	 * @return the user
	 */
	public U getUser()
	{
		return this.user;
	}

	/**
	 * Getter for attribute authToken
	 *
	 * @return the authToken
	 */
	public String getAuthToken()
	{
		return this.authToken;
	}
}
