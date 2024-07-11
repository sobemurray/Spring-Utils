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
package com.sobetech.common.service.spring.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sobetech.common.exception.ApiRuntimeException;

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
    
    /**
     * A null-safe way to check if two Number object for equality
     * 
     * @param number1 The first Number to check
     * @param number2 The second Number to check
     * @return <code>true</code> if both of the number are equal or <code>false</code> if either is 
     * <code>null</code> or they are not equal
     */
    public boolean equals(Number number1, Number number2)
    {
    	if(number1 == null || number2 == null)
    	{
    		return false;
    	}
    	
    	return number1.equals(number2);
    }
    
    /**
     * A null-safe way to check if one Number is greater than another Number
     * 
     * @param number1 The first Number to check
     * @param number2 The second Number to check
     * @return <code>true</code> if the first number is greater than then second or 
     * <code>false</code> if either is <code>null</code> or the first number is greater than then 
     * second
     */
    public boolean greaterThan(Number number1, Number number2)
    {
    	if(number1 == null || number2 == null)
    	{
    		return false;
    	}
    	
    	return number1.doubleValue() > number2.doubleValue();
    }
    
    /**
     * A null-safe way to check if one Number is greater or equal to another Number
     * 
     * @param number1 The first Number to check
     * @param number2 The second Number to check
     * @return <code>true</code> if the first number is greater or equal to than then second or 
     * <code>false</code> if either is <code>null</code> or the first number is greater or equal to 
     * than then second
     */
    public boolean greaterThanEquals(Number number1, Number number2)
    {
    	if(number1 == null || number2 == null)
    	{
    		return false;
    	}
    	
    	return greaterThan(number1, number2) || equals(number1, number2);
    }
    
    /**
     * A null-safe way to check if one Number is less than another Number
     * 
     * @param number1 The first Number to check
     * @param number2 The second Number to check
     * @return <code>true</code> if the first number is less than then second or 
     * <code>false</code> if either is <code>null</code> or the first number is less than then 
     * second
     */
    public boolean lessThan(Number number1, Number number2)
    {
    	if(number1 == null || number2 == null)
    	{
    		return false;
    	}
    	
    	return number1.doubleValue() < number2.doubleValue();
    }
    
    /**
     * A null-safe way to check if one Number is less or equal to another Number
     * 
     * @param number1 The first Number to check
     * @param number2 The second Number to check
     * @return <code>true</code> if the first number is less or equal to than then second or 
     * <code>false</code> if either is <code>null</code> or the first number is less or equal to 
     * than then second
     */
    public boolean lessThanEquals(Number number1, Number number2)
    {
    	if(number1 == null || number2 == null)
    	{
    		return false;
    	}
    	
    	return lessThan(number1, number2) || equals(number1, number2);
    }
    
    /**
     * Calculate a mean using BigDecimal for accuracy using a default scale of '4'
     * 
     * @param part The numerator for the computation
     * @param total The denominator for the computation
     * @return The calculated mean using BigDecimal for accuracy
     */
    public BigDecimal calculateMean(int part, int total)
    {
    	return calculateMean(part, total, 4);
    }
    
    /**
     * Calculate a mean using BigDecimal for accuracy
     * 
     * @param part The numerator for the computation
     * @param total The denominator for the computation
     * @param scale The scale to use in BigDecimal calculations
     * @return The calculated mean using BigDecimal for accuracy
     */
    public BigDecimal calculateMean(int part, int total, int scale)
    {
    	if(total == 0)
    	{
    		return BigDecimal.ZERO;
    	}

        BigDecimal partDecimal = new BigDecimal(part);
        BigDecimal totalDecimal = new BigDecimal(total);

        return partDecimal.divide(totalDecimal, scale, RoundingMode.HALF_UP);
    }
    
    /**
     * Calculate a percentage using BigDecimal for accuracy with a default scale of '4'
     * 
     * @param part The numerator for the computation
     * @param total The denominator for the computation
     * @return The calculated percentage using BigDecimal for accuracy
     */
    public BigDecimal calculatePercentage(int part, int total)
    {
        return calculatePercentage(part, total, 4);
    }
    
    /**
     * Calculate a percentage using BigDecimal for accuracy
     * 
     * @param part The numerator for the computation
     * @param total The denominator for the computation
     * @param scale The scale to use in BigDecimal calculations
     * @return The calculated percentage using BigDecimal for accuracy
     */
    public BigDecimal calculatePercentage(int part, int total, int scale)
    {
    	if(total == 0)
    	{
    		throw new ApiRuntimeException("Percentage cannot be computed if the total is zero");
    	}

        BigDecimal fraction = calculateMean(part, total, scale);

        // fraction * 100
        BigDecimal percentage = fraction.multiply(BigDecimal.valueOf(100));

        // Setting scale for percentage
        percentage = percentage.setScale(scale, RoundingMode.HALF_UP);

        return percentage;
    }
    
    /**
     * Find the median from a list of integers
     * 
     * @param numbers A list if integers
     * @return The median of this list
     */
    public double calculateMedian(List<Integer> numbers)
    {
    	// Step 1: Sort the list
        Collections.sort(numbers);

        // Step 2: Calculate the median
        int size = numbers.size();
        if (size == 0) 
        {
            throw new IllegalArgumentException("List must not be empty");
        }

        if (size % 2 == 1) 
        {
            // Odd number of elements
            return numbers.get(size / 2);
        }
        
		// Even number of elements
		int middle1 = numbers.get(size / 2 - 1);
		int middle2 = numbers.get(size / 2);
		return (middle1 + middle2) / 2.0;
    }
}