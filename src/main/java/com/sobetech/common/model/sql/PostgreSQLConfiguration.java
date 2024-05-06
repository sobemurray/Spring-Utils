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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * A class containing the information pertaining to a server connection
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
@JsonInclude(Include.NON_NULL)
public class PostgreSQLConfiguration extends DatabaseConfiguration
{ 
	protected int port = 5432;
    protected static String DEFAULT_DRIVER_CLASS_NAME = "org.postgresql.Driver";
    
    /**
     * Constructs a connection to a database
     * 
     * @param address Address of the database
     * @param username The user name on the database to login to
     * @param password The password on the database for the user name
     * @param port The port to connect to this database upon
     */
    public PostgreSQLConfiguration(String address, String username, String password, int port)
    {
        this(address, username, password, port, "");
    }
    
    /**
     * Constructs a connection to a database
     * 
     * @param address Address of the database
     * @param username The user name on the database to login to
     * @param password The password on the database for the user name
     * @param port The port to connect to this database upon
     * @param defaultSchema The default schema to use on this database
     */
    public PostgreSQLConfiguration(String address, String username, String password, int port, String defaultSchema)
    {
        super(address, username, password, port, defaultSchema);
        setDriverClassName(DEFAULT_DRIVER_CLASS_NAME);
    }
    
    @Override
    public String getURLString()
    {
        if(isValid())
        {
            if(getDefaultSchema() == null || getDefaultSchema().isEmpty())
                return "jdbc:postgresql://" + getAddress() + ":" + getPort();
            return "jdbc:postgresql://" + getAddress() + ":" + getPort() + "/" + getDefaultSchema(); 
        }
        return "INVALID PostgreSQLConfiguration";
    }
    
    @Override
    public boolean isValid()
    {
        return super.isValid() && !getDriverClassName().isEmpty();
    }
} 