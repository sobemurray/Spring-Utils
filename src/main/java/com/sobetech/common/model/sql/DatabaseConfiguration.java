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
package com.sobetech.common.model.sql;

import com.sobetech.common.exception.io.IllegalPortNumberException;
import com.sobetech.common.model.io.ServerConfiguration;

/**
 * A class containing the information pertaining to a server connection
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
public abstract class DatabaseConfiguration extends ServerConfiguration
{ 
	protected int port;
    private String defaultSchema;
    protected String driverClassName;
    
    /**
     * Constructs a connection to a database
     * 
     * @param address Address of the database
     * @param username The user name on the database to login to
     * @param password The password on the database for the user name
     * @param port The port to connect to this database upon
     */
    protected DatabaseConfiguration(String address, String username, String password, int port)
    {
        this(address, username, password, port, "");
    }
    
    /**
     * Constructs a connection to a database
     * 
     * @param address Address of the database
     * @param username The user name on the database to login to
     * @param password The password on the database for the usern ame
     * @param port The port to connect to this database upon
     * @param defaultSchema The default schema to use on this database
     */
    protected DatabaseConfiguration(String address, String username, String password, int port, String defaultSchema)
    {
        super(address, username, password);
        setPort(port);
        this.defaultSchema = defaultSchema;
    }
    
    public abstract String getURLString();
    
    @Override
    public boolean isValid()
    {
        return super.isValid() && this.port > 0;
    }
    
    public int getPort()
    {
        return this.port;
    }
    
    public void setPort(int port)
    {
    	if(port < 1)
    	{
    		throw new IllegalArgumentException(new IllegalPortNumberException(port));
    	}
    	
        this.port = port;
    }

    public String getDefaultSchema()
    {
        return this.defaultSchema;
    }

    public void setDefaultSchema(String defaultSchema)
    {
        this.defaultSchema = defaultSchema;
    }

    public String getDriverClassName()
    {
        return this.driverClassName;
    }

    public void setDriverClassName(String driverClassName)
    {
        this.driverClassName = driverClassName;
    }
} 