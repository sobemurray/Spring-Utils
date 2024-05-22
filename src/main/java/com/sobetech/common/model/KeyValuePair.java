/**
 * Created by Sobetech Holdings LLC
 *
 * Copyright © 2023 Sobetech Holdings LLC, All Rights Reserved
 *
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with Sobetech Holdings LLC, or one of its affiliates,
 * and may not be used, disseminated, or distributed except in accordance with
 * the terms of that agreement.
 *
 */
package com.sobetech.common.model;

/**
 * Simple POJO for key/value pairs
 * 
 * @author John.Murray
 *
 */
public class KeyValuePair
{
	private String key;
	private String value;

	/**
	 * Getter for attribute key
	 *
	 * @return the key
	 */
	public String getKey()
	{
		return this.key;
	}

	/**
	 * Setter for attribute key
	 *
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * Getter for attribute value
	 *
	 * @return the value
	 */
	public String getValue()
	{
		return this.value;
	}

	/**
	 * Setter for attribute value
	 *
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

}
