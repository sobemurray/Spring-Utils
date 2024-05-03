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
package com.sobetech.common.model.security;

import java.io.Serializable;

/**
 * Model object for a security role for a user
 * TODO Convert this to an ENUM
 * 
 * @author John.Murray
 *
 * @since Jul 10, 2023
 *
 */
@Deprecated
public class CommonRole implements Serializable 
{

	private static final long serialVersionUID = -4764435891915319393L;
	public static final String ADMIN_STRING = "ADMIN";
	public static final String AGENT_STRING = "AGENT";
	public static final String TENANT_STRING = "TENANT";
	public static final String UNDERWRITER_STRING = "UNDERWRITER";
	
	private CommonRole() 
	{
	}
	
	public CommonRole(Long id, String label)
	{
		this.id = id;
		this.label = label;
	}

    private Long id;

    private String label;
    
    public static CommonRole fromString(String roleString)
    {
    	if(roleString == null || roleString.isBlank())
    	{
    		throw new IllegalArgumentException("A role cannot be determinted from an empty or null String");
    	}
    	
    	CommonRole commonRole = new CommonRole();
    	switch (roleString)
        {
            case "1":
            	commonRole.setId(Long.valueOf(roleString));
            	commonRole.label = AGENT_STRING;
                return commonRole;

            case "2":
            	commonRole.setId(Long.valueOf(roleString));
            	commonRole.label = UNDERWRITER_STRING;
                return commonRole;

            case "3":
            	commonRole.setId(Long.valueOf(roleString));
            	commonRole.label = ADMIN_STRING;
                return commonRole;
                
            case AGENT_STRING:
            	commonRole.setId(1l);
            	commonRole.label = roleString;
                return commonRole;

            case UNDERWRITER_STRING:
            	commonRole.setId(2l);
            	commonRole.label = roleString;
                return commonRole;

            case ADMIN_STRING:
            	commonRole.setId(3l);
            	commonRole.label = roleString;
                return commonRole;
        }
    	return null;
    }

	/**
	 * Getter for attribute id
	 *
	 * @return the id
	 */
	public Long getId()
	{
		return this.id;
	}

	/**
	 * Setter for attribute id
	 *
	 * @param id the id to set
	 */
	public void setId(Long id)
	{
		this.id = id;
	}

	/**
	 * Getter for attribute label
	 *
	 * @return the label
	 */
	public String getLabel()
	{
		return this.label;
	}

	/**
	 * Setter for attribute label
	 *
	 * @param label the label to set
	 */
	public void setLabel(String label)
	{
		this.label = label;
	}
}