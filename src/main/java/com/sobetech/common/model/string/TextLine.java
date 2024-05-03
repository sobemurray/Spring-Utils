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

import java.util.Objects;

/**
 * A wrapper class for the individual lines in a file
 * 
 * @author John Murray
 *
 * @since 0.3.1
 */
public class TextLine
{
    protected String line;

    /**
     * Constructs a new instance containing an empty string
     */
    public TextLine()
    {
        this.line = new String();
    }

    /**
     * Constructs a new instance containing the incoming string
     * 
     * @param line The string that the line will be initialized to
     * @throws NullPointerException if the incoming line is null
     */
    public TextLine(String line)
    {
        this.line = Objects.requireNonNull(line, "line must not be null");
    }

    @Override
	public boolean equals(Object obj)
	{
    	if(TextLine.class.isInstance(obj))
    	{
    		TextLine testLine = TextLine.class.cast(obj);
    		return testLine.toString().equals(this.toString());
    	}
    	
		return false;
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
     * @param line The string to set the line to
     * @throws NullPointerException if the incoming line is null
     */
    public void setLine(String line)
    {
        this.line = Objects.requireNonNull(line, "line must not be null");;
    }
    
    public void clear()
    {
    	this.line = new String();
    }

    public void replaceAllInLine(String targetToReplaceRegex, String replacement)
    {
    	this.line = this.line.replaceAll(targetToReplaceRegex, replacement);
    }
}