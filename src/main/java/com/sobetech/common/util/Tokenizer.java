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
package com.sobetech.common.util;

import java.util.Enumeration;

/**
 * An <code>Enumeration</code> that is a more effective Tokenizer than java.util.StringTokenizer
 * 
 * @author John Murray
 * 
 * @since 0.0.2
 */

public class Tokenizer implements Enumeration<String>
{
    private int currentPosition;

    private int maxPosition;

    private String tokenizedString;

    private String delimiters;

    private char[] chars;

    /**
     * Stores the value of the delimiter character with the highest value. It is used to optimize the detection 
     * of delimiter characters.
     */
    private char maxDelim;

    /**
     * Set maxDelimChar to the highest char in the delimiter set.
     */
    private void setMaxDelimChar()
    {
        if(this.delimiters == null)
        {
        	this.maxDelim = 0;
            return;
        }

        char m = 0;
        for(int i = 0; i < this.delimiters.length(); i++)
        {
            char c = this.delimiters.charAt(i);
            if(m < c)
            {
                m = c;
            }
        }
        
        this.maxDelim = m;
    }

    /**
     * Constructs a string tokenizer for the specified string. All characters in
     * the <code>delimiters</code> argument are the delimiters for separating
     * tokens.
     * <p>
     * If the <code>bRetDelims</code> flag is <code>true</code>, then the
     * delimiter characters are also returned as tokens. Each delimiter is
     * returned as a string of length one. If the flag is <code>false</code>,
     * the delimiter characters are skipped and only serve as separators between
     * tokens.
     * 
     * @param tokenizedString A string to be parsed.
     * @param delimiters The delimiters.
     * @param returnDelims Flag indicating whether to return the delimiters as tokens.
     */
    public Tokenizer(String tokenizedString, String delimiters, boolean returnDelims)
    {
        if(delimiters == null)
        {
            delimiters = " \t\n\r\f";
        }
        this.currentPosition = 0;
        this.tokenizedString = tokenizedString;
        this.maxPosition = tokenizedString.length();
        this.delimiters = delimiters;
        setMaxDelimChar();
        this.chars = tokenizedString.toCharArray();
    }

    /**
     * Constructs a string tokenizer for the specified string. The characters in
     * the <code>sDelimiters</code> argument are the delimiters for separating
     * tokens. Delimiter characters themselves will not be treated as tokens.
     * 
     * @param tokenizedString A string to be parsed.
     * @param delimiters The delimiters.
     */
    public Tokenizer(String tokenizedString, String delimiters)
    {
        this(tokenizedString, delimiters, false);
    }

    /**
     * Constructs a string tokenizer for the specified string. The tokenizer
     * uses the default delimiter set, which is
     * <code>"&nbsp;&#92;t&#92;n&#92;r&#92;f"</code>: the space character,
     * the tab character, the newline character, the carriage-return character,
     * and the form-feed character. Delimiter characters themselves will not be
     * treated as tokens.
     * 
     * @param tokenizedString A string to be parsed.
     */
    public Tokenizer(String tokenizedString)
    {
        this(tokenizedString, " \t\n\r\f", false);
    }

    /**
     * Tests if there are more tokens available from this tokenizer's string. If
     * this method returns <code>true</code>, then a subsequent call to
     * <code>nextToken</code> with no argument will successfully return a token.
     * 
     * @return <code>true</code> if and only if there is at least one token in
     *         the string after the current position; <code>false</code>
     *         otherwise.
     */
    public boolean hasMoreTokens()
    {
        return this.currentPosition <= this.maxPosition;
    }

    /**
     * Returns the next token from this string tokenizer.
     * 
     * @return The next token from this string tokenizer.
     */
    public String nextToken()
    {
        if(this.currentPosition == 0 && this.delimiters.indexOf(this.chars[this.currentPosition]) >= 0)
        {
        	this.currentPosition++;
            return "";
        }
        if(this.currentPosition > this.maxPosition) return "";

        StringBuilder builder = new StringBuilder();
        while(this.currentPosition < this.maxPosition && ((this.chars[this.currentPosition] > this.maxDelim) || 
                        (this.delimiters.indexOf(this.chars[this.currentPosition]) < 0)))
        {
        	builder.append(this.chars[this.currentPosition]);
            this.currentPosition++;
        }
        this.currentPosition++;

        return builder.toString();
    }

    /**
     * Returns the same value as the <code>hasMoreTokens</code> method. It
     * exists so that this class can implement the <code>Enumeration</code>
     * interface.
     * 
     * @return <code>true</code> if there are more tokens; <code>false</code>
     *         otherwise.
     * @see java.util.Enumeration
     * @see java.util.StringTokenizer#hasMoreTokens()
     */
    @Override
	public boolean hasMoreElements()
    {
        return hasMoreTokens();
    }

    /**
     * Returns the same value as the <code>nextToken</code> method, except
     * that its declared return value is <code>Object</code> rather than
     * <code>String</code>. It exists so that this class can implement the
     * <code>Enumeration</code> interface.
     * 
     * @return the next token in the string.
     * @see java.util.Enumeration
     * @see java.util.StringTokenizer#nextToken()
     */
    @Override
	public String nextElement()
    {
        return nextToken();
    }

    /**
     * Calculates the number of times that this tokenizer's
     * <code>nextToken</code> method can be called before it generates an
     * exception. The current position is not advanced.
     * 
     * @return the number of tokens remaining in the string using the current
     *         delimiter set.
     * @see java.util.StringTokenizer#nextToken()
     */
    public int countTokens()
    {
        int iCount = 0;
        for(int i = 0; i < this.maxPosition; i++)
        {
            //if((chars[i] <= cMaxDelim) && (sDelimiters.indexOf(chars[i]) >= 0))
            if(this.delimiters.indexOf(this.chars[i]) >= 0)iCount++;
        }
        iCount++;
        return iCount;
    }
    
    /**
     * @return Returns the tokenizedString.
     */
    public String getTokenizedString()
    {
        return this.tokenizedString;
    }
    
    /**
     * @param tokenizedString The tokenizedString to set.
     */
    public void setTokenizedString(String tokenizedString)
    {
        this.tokenizedString = tokenizedString;
    }
}