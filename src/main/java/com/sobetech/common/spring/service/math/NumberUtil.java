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
package com.sobetech.common.spring.service.math;

import org.springframework.stereotype.Service;

/**
 * This class contains a number of static methods used to handle numeric functions.
 *
 * @author John Murray
 *
 * @since 0.0.2
 */
@Service
public class NumberUtil
{
	/**
	 *  Take a currency float that may contain fractions of a cent and round it to the nearest cent
     *  
     *  @deprecated
	 */
    @Deprecated
	public float formatAsCurrency(float inputNumber)
    {
        return ((float)StrictMath.round(inputNumber * 100) / 100);
    }
    
    /**
     * Gets a random int value within a specified range
     * 
     * @param min The smallest value of int to be returned
     * @param max The largest value of int to be returned
     * @return A random int value within a specified range
     */
    public int getRandomInt(int min, int max) 
    {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    /**
     * Safely converts a String into a double
     * 
     * @param doubleString The string to convert into a double
     * @return The String as a double or 0 if the String cannot be converted into a double
     */
    public double toDouble(String doubleString)
    {
        return toDouble(doubleString, 0d);
    }
    
    /**
     * Safely converts a String into a double
     * 
     * @param doubleString The string to convert into a double
     * @param nullErrorValue The value to use if the String cannot be converted into a double
     * @return The String as a double or the value of nullErrorValue if the String cannot be converted 
     * into a double
     */
    public double toDouble(String doubleString, double nullErrorValue)
    {
        if(doubleString == null || doubleString.isEmpty() || doubleString.isBlank()) return nullErrorValue;
        try
        {
            return Double.parseDouble(doubleString);
        }
        catch(NumberFormatException e)
        {
            return nullErrorValue;
        }
    }
    
    /**
     * Safely converts a String into a float
     * 
     * @param floatString The string to convert into a float
     * @return The String as a float or 0 if the String cannot be converted into a float
     */
    public float toFloat(String floatString)
    {
        return toFloat(floatString, 0f);
    }
    
    /**
     * Safely converts a String into a float
     * 
     * @param floatString The string to convert into a float
     * @param nullErrorValue The value to use if the String cannot be converted into a float
     * @return The String as a float or the value of nullErrorValue if the String cannot be converted 
     * into a float
     */
    public float toFloat(String floatString, float nullErrorValue)
    {
        if(floatString == null || floatString.isEmpty() || floatString.isBlank()) return nullErrorValue;
        try
        {
            return Float.parseFloat(floatString);
        }
        catch(NumberFormatException e)
        {
            return nullErrorValue;
        }
    }

    /**
     * Safely converts a String into a int
     * 
     * @param intString The string to convert into a int
     * @return The String as a int or 0 if the String cannot be converted into a int
     */
    public int toInteger(String intString)
    {
        return toInteger(intString, 0);
    }
    
    /**
     * Safely converts a String into a int
     * 
     * @param intString The string to convert into a int
     * @param nullErrorValue The value to use if the String cannot be converted into a int
     * @return The String as a int or the value of nullErrorValue if the String cannot be converted 
     * into a int
     */
    public int toInteger(String intString, int nullErrorValue)
    {
        if(intString == null || intString.isEmpty() || intString.isBlank()) return nullErrorValue;
        try
        {
            return Integer.parseInt(intString);
        }
        catch(NumberFormatException e)
        {
            return nullErrorValue;
        }
    }
    
    /**
     * Safely converts a String into a long
     * 
     * @param longString The string to convert into a long
     * @return The String as a long or 0 if the String cannot be converted into a long
     */
    public long toLong(String longString)
    {
        return toLong(longString, 0);
    }
    
    /**
     * Safely converts a String into a long
     * 
     * @param longString The string to convert into a long
     * @param nullErrorValue The value to use if the String cannot be converted into a long
     * @return The String as a long or the value of nullErrorValue if the String cannot be converted 
     * into a long
     */
    public long toLong(String longString, long nullErrorValue)
    {
        if(longString == null || longString.isEmpty() || longString.isBlank()) return nullErrorValue;
        try
        {
            return Long.parseLong(longString);
        }
        catch(NumberFormatException e)
        {
            return nullErrorValue;
        }
    }
    
    /**
     * Safely converts a String into a short
     * 
     * @param shortString The string to convert into a short
     * @return The String as a short or 0 if the String cannot be converted into a short
     */
    public short toShort(String shortString)
    {
        return toShort(shortString, (short)0);
    }
    
    /**
     * Safely converts a String into a short
     * 
     * @param shortString The string to convert into a short
     * @param nullErrorValue The value to use if the String cannot be converted into a short
     * @return The String as a short or the value of nullErrorValue if the String cannot be converted 
     * into a short
     */
    public short toShort(String shortString, short nullErrorValue)
    {
        if(shortString == null || shortString.isEmpty() || shortString.isBlank()) return nullErrorValue;
        
        try
        {
            return Short.parseShort(shortString);
        }
        catch(NumberFormatException e)
        {
            return nullErrorValue;
        }
    }
}