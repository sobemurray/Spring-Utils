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
    
    /**
     * Clear all of the content in this line. It will not make the line <code>null</code>, but an empty String
     */
    public void clear()
    {
    	this.line = new String();
    }

    /**
     * Replace all occurrences of a String within this line
     * 
     * @param targetToReplaceRegex A Regex of a what is to be replaced
     * @param replacement The String to replace it with
     */
    public void replaceAllInLine(String targetToReplaceRegex, String replacement)
    {
    	this.line = this.line.replaceAll(targetToReplaceRegex, replacement);
    }
    
    /**
     * Get the first character in this line. If the line is empty or null, and empty character will be returned
     * 
     * @return The first character in this line. If the line is empty or null, and empty character will be returned
     */
    public char firstCharacter()
    {
    	if(this.line == null || this.line.isBlank())
    	{
    		return ' ';
    	}
    	
    	return this.line.charAt(0);
    }
    
    /**
     * Check to see if this character is the first one in this line. If the line is empty or null, a test 
     * character of an empty character will return <code>true</code>
     * 
     * @param testCharacter The character to check
     * @return <code>true</code) if the test character is the first character in the line
     */
    public boolean isFirstCharacter(char testCharacter)
    {
    	return testCharacter == firstCharacter();
    }
    
    /**
     * Check to see if this character is NOT the first one in this line. If the line is empty or null, a test 
     * character of an empty character will return <code>false</code>
     * 
     * @param testCharacter The character to check
     * @return <code>true</code) if the test character is NOT the first character in the line
     */
    public boolean isFirstCharacterNot(char testCharacter)
    {
    	return testCharacter != firstCharacter();
    }
    
    /**
     * See of this line start with this String
     * 
     * @param leadingString The String to test with
     * @return <code>true</code> if this line leads with this String
     */
    public boolean leadsWith(String leadingString)
    {
    	return this.line.startsWith(leadingString);
    }
    
    /**
     * See of this line end with this String
     * 
     * @param leadingString The String to test with
     * @return <code>true</code> if this line ends with this String
     */
    public boolean endsWith(String leadingString)
    {
    	return this.line.endsWith(leadingString);
    }
}