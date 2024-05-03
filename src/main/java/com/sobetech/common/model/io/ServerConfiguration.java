/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2005 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 * 
 */
package com.sobetech.common.model.io;

import java.net.MalformedURLException;
import java.net.URI;

/**
 * A class containing the information pertaining to a server connection
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
public class ServerConfiguration
{ 
    private String address;
    private String username;
    private String password;
    
    public ServerConfiguration()
    {
    }
     
    /**
     * Configuration information required to connect to a remote server
     * 
     * @param address Address of the remote server
     * @param username The user name on the remote server to login to
     * @param password The password on the remote server for the user name
     */
    public ServerConfiguration(String address, String username, String password)
    {
        if(address == null || address.isEmpty()) 
            throw new IllegalArgumentException("Server cannot be configuration without an address");
        this.address = address;
        this.username = username;
        this.password = password;
    }
    
	public boolean isValid()
    {
    	// Test the URL String
        try
        {
            URI.create("http://" + this.address).toURL();
        }
        catch(MalformedURLException ignore)
        {
            return false;
        }
        
        if(this.password != null && !this.password.isBlank())
        {
            if(this.username == null || this.username.isBlank())
                return false;
        }
        
        return true;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
} 