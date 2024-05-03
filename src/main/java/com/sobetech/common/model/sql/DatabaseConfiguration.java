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
 * 
 */
public abstract class DatabaseConfiguration extends ServerConfiguration
{ 
	private int port;
	
    private String defaultSchema;
    
    private String driverClassName;
    
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
    
    /**
     * Get the URL of the database
     * 
     * @return The URL of the database as a String
     */
    public abstract String getURLString();

    @Override
    public boolean isValid()
    {
        return super.isValid() && this.port > 0;
    }
    
    /**
     * Get the port the database is listening on
     * 
     * @return The port the database is listening on 
     */
    public int getPort()
    {
        return this.port;
    }
    
    /**
     * Set the port number the database is listening on
     * 
     * @param port The port the database is listening on 
     */
    public void setPort(int port)
    {
    	if(port < 1)
    	{
    		throw new IllegalArgumentException(new IllegalPortNumberException(port));
    	}
    	
        this.port = port;
    }

    /**
     * The name of the default schema to use for this database
     * 
     * @return The name of the default schema to use for this database
     */
    public String getDefaultSchema()
    {
        return this.defaultSchema;
    }

    /**
     * Set the name of the default schema to use for this database
     * 
     * @param defaultSchema The name of the default schema to use for this database
     */
    public void setDefaultSchema(String defaultSchema)
    {
        this.defaultSchema = defaultSchema;
    }

    /**
     * The fully qualified name of the class to use as a database driver
     * 
     * @return The fully qualified name of the class to use as a database driver
     */
    public String getDriverClassName()
    {
        return this.driverClassName;
    }

    /**
     * Set the fully qualified name of the class to use as a database driver
     * 
     * @param driverClassName The fully qualified name of the class to use as a database driver
     */
    public void setDriverClassName(String driverClassName)
    {
        this.driverClassName = driverClassName;
    }
} 