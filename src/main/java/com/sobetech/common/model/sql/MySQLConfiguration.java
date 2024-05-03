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

/**
 * A class containing the information pertaining to a server connection
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
public class MySQLConfiguration extends DatabaseConfiguration
{ 
	@SuppressWarnings("hiding")
	protected int port = 3306;
    protected static String DEFAULT_DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    
    /**
     * Constructs a connection to a database
     * 
     * @param address Address of the database
     * @param username The user name on the database to login to
     * @param password The password on the database for the user name
     * @param port The port to connect to this database upon
     */
    public MySQLConfiguration(String address, String username, String password, int port)
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
    public MySQLConfiguration(String address, String username, String password, int port, String defaultSchema)
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
                return "jdbc:mysql://" + getAddress() + ":" + getPort();
            return "jdbc:mysql://" + getAddress() + ":" + getPort() + "/" + getDefaultSchema(); 
        }
        return "INVALID MySQLConfiguration";
    }
    
    @Override
    public boolean isValid()
    {
        return super.isValid() && !this.driverClassName.isEmpty();
    }
} 