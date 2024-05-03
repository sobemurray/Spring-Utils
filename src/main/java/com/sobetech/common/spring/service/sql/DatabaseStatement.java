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
package com.sobetech.common.spring.service.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sobetech.common.model.sql.DatabaseConfiguration;

/**
 * A class used to create SQL statements
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
public abstract class DatabaseStatement<C extends DatabaseConfiguration>
{
    private C configuration;
    
    protected DatabaseStatement()
    {
    }
    
    protected DatabaseStatement(C configuration)
    {
        if(configuration != null && configuration.isValid())
            this.configuration = configuration;
        else
            throw new IllegalArgumentException("The Information passed to form a connection was invalid or null");
    }
    
    protected void runQuery(String sql) throws SQLException
    {
        if(this.configuration.getDriverClassName() == null)
            throw new SQLException("Queries cannot be run with a null driver class name");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            Class.forName(this.configuration.getDriverClassName());
            connection = DriverManager.getConnection(this.configuration.getURLString(), 
            		this.configuration.getUsername(), this.configuration.getPassword());   
            
            if(!connection.isClosed())
            {
            	statement = connection.createStatement();
            	
            	if(!statement.isClosed())
            	{
            		resultSet = statement.executeQuery(sql);
                    processResultSet(resultSet);
            	}
            	else
            	{
            		throw new SQLException("Query cannot be run on a closed statement");
            	}
            }
        	else
        	{
        		throw new SQLException("Query cannot be run on a closed connection");
        	}
        }
        catch(ClassNotFoundException e)
        {
            throw new SQLException(this.configuration.getDriverClassName() + " was not found in the classpath");
        }
        catch(SQLException rethrow)
        {
            throw rethrow;
        }
        finally
        {
        	if(resultSet != null)
        	{
        		resultSet.close();
        		resultSet = null;
        	}
        	
        	if(statement != null)
        	{
        		statement.close();
        		statement = null;
        	}
        	
            if(connection != null)
            {
                connection.close();
                connection = null;
            }
        }
    }
    
    public abstract void processResultSet(ResultSet resultSet) throws SQLException;

    public C getConfiguration()
    {
        return this.configuration;
    }

    public void setConfiguration(C configuration)
    {
        this.configuration = configuration;
    }
}