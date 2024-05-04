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
package com.sobetech.common.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * POJO holding information attributes of an application
 *
 * @author John Murray
 *
 * @since Apr 28, 2024
 *
 */
@JsonInclude(Include.NON_NULL)
public class ApiAppInfo
{
	private String applicationName;
	
	private String displayName;
	
	private String version;

	/**
	 * Getter for attribute applicationName
	 *
	 * @return the applicationName
	 */
	public String getApplicationName()
	{
		return this.applicationName;
	}

	/**
	 * Setter for attribute applicationName
	 *
	 * @param applicationName the applicationName to set
	 */
	public void setApplicationName(String applicationName)
	{
		this.applicationName = applicationName;
	}

	/**
	 * Getter for attribute displayName
	 *
	 * @return the displayName
	 */
	public String getDisplayName()
	{
		return this.displayName;
	}

	/**
	 * Setter for attribute displayName
	 *
	 * @param displayName the displayName to set
	 */
	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	/**
	 * Getter for attribute version
	 *
	 * @return the version
	 */
	public String getVersion()
	{
		return this.version;
	}

	/**
	 * Setter for attribute version
	 *
	 * @param version the version to set
	 */
	public void setVersion(String version)
	{
		this.version = version;
	}
}
