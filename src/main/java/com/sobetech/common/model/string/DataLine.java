/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2019 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 * 
 */
package com.sobetech.common.model.string;

/**
 * A wrapper class that allows delimited string data lines to be created easily
 * 
 * @author John Murray
 *
 * @since 0.0.2
 */
public class DataLine
{
    private String line;

    /**
     * Constructs a new instance containing an empty string
     */
    public DataLine()
    {
        this.line = new String();
    }

    /**
     * Constructs a new instance containing the incoming string
     * 
     * @param line The string that the line will be initialized to.
     */
    public DataLine(String line)
    {
        this.line = line;
    }

    /**
     * Dumps out the entire content of the line.
     */
    @Override
    public String toString()
    {
        return this.line;
    }

    /**
     * Sets the contents of the line with the incoming string.
     * 
     * @param line The string to set the line to.
     */
    public void setLine(String line)
    {
        this.line = line;
    }

    /**
     * Sets the contents of the line. If either of the arguments are null, then the method will return without doing 
     * anything.
     * 
     * @param fields An array of data elements that the data line will be constructed from
     * @param delimiter The delimiter that is to be used
     */
    public void setLine(String[] fields, String delimiter)
    {
        if(fields == null || delimiter == null)
        {
            return;
        }

        StringBuffer lineBuffer = new StringBuffer();
        boolean addDelimiter = false;
        
        for(int i = 0; i < fields.length; i++)
        {
        	if(addDelimiter)
        	{
        		lineBuffer.append(delimiter);
        	}
        	
            lineBuffer.append(fields[i]);
            
            addDelimiter = true;
        }
        
        this.line = lineBuffer.toString();
    }
}