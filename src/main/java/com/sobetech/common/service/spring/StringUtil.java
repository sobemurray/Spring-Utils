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
package com.sobetech.common.service.spring;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.sobetech.common.enums.BooleanFormat;

/**
 * A utility class working with Java Strings. All operation are null safe unless specified.
 * 
 * @author John Murray Holdings LLC $Author$
 
 * @since 0.0.2
 */
@Service
public class StringUtil
{
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Test a String to see if it is either null or blank
	 * 
	 * @param string The String to test
	 * @return <code>true</true> if the String to test is <code>null</code> or blank
	 */
	public boolean isNullOrBlank(String string)
	{
		if(string == null)
		{
			return true;
		}
		
		return string.isBlank();
	}
	
	/**
	 * Test a String to see if it is either not null nor blank
	 * 
	 * @param string The String to test
	 * @return <code>true</true> if the String to test is not <code>null</code> nor blank
	 */
	public boolean isNotNullOrBlank(String string)
	{
		if(string == null)
		{
			return true;
		}
		
		return !isNullOrBlank(string);
	}
	
	/**
	 * Test a String to see if it is not null nor blank
	 * 
	 * @param string The String to test
	 * @return <code>true</true> if the String to test is not <code>null</code> not blank
	 */
	public boolean isPresent(String string)
	{
		return !isNullOrBlank(string);
	}
	
    /**
     * 
     * Safely compares 2 String objects for equality regardless if the either of the arguments are null. If both
     * arguments are null, then the method will return <code>true</code>
     *
     * @param string1 The first String argument for comparison
     * @param string2 The second String argument for comparison
     * @return <code>true</code> if the strings are equal or both null. Otherwise <code>false</code>
     *
     */
    public boolean nullSafeEquals(String string1, String string2)
    {
        return nullSafeEquals(string1, string2, false);
    }
    
    /**
     * 
     * Safely compares 2 String objects for equality regardless if the either of the arguments are null. If both
     * arguments are null, then the method will return <code>true</code>
     *
     * @param string1 The first String argument for comparison
     * @param string2 The second String argument for comparison
     * @param trimStrings If set to <code>true</code> the strings will be trimmed before doing the comparison
     * @return <code>true</code> if the strings are equal or both null. Otherwise <code>false</code>
     *
     */
    public boolean nullSafeEquals(String string1, String string2, boolean trimStrings)
    {
        // If both are null then they are equal in the fact that they are both null
        if(string1 == null && string2 == null)
        {
            return true;
        }
        
        // Check if one of the strings are null
        if(string1 == null || string2 == null)
        {
            return false;
        }
        
        // Trim the strings if necessary
        if(trimStrings)
        {
            string1 = string1.trim();
            string2 = string2.trim();
        }
        
        // Do the equals check
        return string1.equals( string2 );
    }

    /**
     * 
     * Safely compares 2 String objects for case-less equality regardless if the either of the arguments are null. If both
     * arguments are null, then the method will return <code>true</code>
     *
     * @param string1 The first String argument for comparison
     * @param string2 The second String argument for comparison
     * @return <code>true</code> if the strings are equal while ignoring case or both null. Otherwise <code>false</code>
     *
     */
    public boolean nullSafeEqualsIgnoreCase(String string1, String string2)
    {

        return nullSafeEqualsIgnoreCase(string1, string2, false);
    }
    
    /**
     * 
     * Safely compares 2 String objects for case-less equality regardless if the either of the arguments are null. If both
     * arguments are null, then the method will return <code>true</code>
     *
     * @param string1 The first String argument for comparison
     * @param string2 The second String argument for comparison
     * @param trimStrings If set to <code>true</code> the strings will be trimmed before doing the comparison
     * @return <code>true</code> if the strings are equal while ignoring case or both null. Otherwise <code>false</code>
     *
     */
    public boolean nullSafeEqualsIgnoreCase(String string1, String string2, boolean trimStrings)
    {
        // If both are null then they are equal in the fact that they are both null
        if(string1 == null && string2 == null)
        {
            return true;
        }
        
        // Check if one of the strings are null
        if(string1 == null || string2 == null) 
        {
            return false;
        }
        
        // Trim the strings if necessary
        if(trimStrings)
        {
            string1 = string1.trim();
            string2 = string2.trim();
        }
        
        // Do the equals check
        return string1.equalsIgnoreCase( string2 );
    }
    
    /**
     * Checks to see if a string is all lower case
     * 
     * @param string The string to check
     * @return <code>true</code> if the string is not null and it is all in lower case
     */
    public boolean isLowerCase(String string)
    {
    	if(string == null)
    	{
    		return false;
    	}
    	
    	return string.equals(string.toLowerCase());
    }
    
    /**
     * Checks to see if a string is all upper case
     * 
     * @param string The string to check
     * @return <code>true</code> if the string is not null and it is all in upper case
     */
    public boolean isUpperCase(String string)
    {
    	if(string == null)
    	{
    		return false;
    	}
    	
    	return string.equals(string.toUpperCase());
    }
    
    /**
     * Checks this string to see of it can be converted into a real number. This method is null-safe
     * so if the input parameter is null then it will return false instead of throwing an exception
     * 
     * @param string The string to check
     * @return <code>true</code> if the string can be converted into a Java Double. Otherwise <code>false</code>
     */
    public boolean isNumeric(String string)
    {
    	if(string == null)
    	{
    		return false;
    	}
    	
    	try
    	{
    		Double.valueOf(string);
    		return true;
    	}
    	catch(NumberFormatException ignore)
    	{
    		return false;
    	}
    }
    
    /**
     * Checks this string to see of it can be converted into a Java UUID. This method is null-safe
     * so if the input parameter is null then it will return false instead of throwing an exception
     * 
     * @param string The string to check
     * @return <code>true</code> if the string can be converted into a Java UUID. Otherwise <code>false</code>
     */
    public boolean isUUID(String string)
    {
    	if(string == null)
    	{
    		return false;
    	}
    	
    	try
    	{
    		UUID.fromString(string);
    		return true;
    	}
    	catch(IllegalArgumentException ignore)
    	{
    		return false;
    	}
    }
    
    /**
     * Take an unknown amount of chars and convert them into a string
     * 
     * @param chars The chars to convert to a string
     * @return The chars as a string. If null is sent, an empty String is returned
     */
    public String toCharString(char... chars)
    {
    	StringBuilder stringBuilder = new StringBuilder();

    	if(chars != null)
    	{
	    	for(char charToAdd : chars)
	    	{
	    		stringBuilder.append(charToAdd);
	    	}
    	}
    	
		return stringBuilder.toString();
    }
    
    /**
     * Create a random alphabetic string of a specified length. This string will not have any spaces
     * 
     * @param targetStringLength The length of the string required
     * @return A random alphabetic string targetStringLength characters long
     * 
     * @see <a href="https://asciitable.com">https://www.asciitable.com for ASCII codes</a>
     */
    public String getRandomAlphabeticString(int targetStringLength)
    {
    	int leftLimit = 65; // letter 'A'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 90 || i >= 97))
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        System.out.println(generatedString);
        
        return generatedString;
    }
    
    /**
     * Create a random alphanumeric string of a specified length. This string will not have any spaces
     * 
     * @param targetStringLength The length of the string required
     * @return A random alphanumeric string targetStringLength characters long
     * 
     * @see <a href="https://asciitable.com">https://www.asciitable.com for ASCII codes</a>
     */
    public String getRandomAlphanumericString(int targetStringLength)
    {
    	int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
        
        return generatedString;
    }
	
	/**
	 * Take any object and convert it into a String safely
	 * 
	 * @param objectToTurnIntoString The object to turn into String
	 * @return The object as a String or an empty String if the object is null
	 */
	public String safeToString(Object objectToTurnIntoString)
	{
		return safeToString(objectToTurnIntoString, "");
	}
	
	/**
	 * Take any object and convert it into a String safely
	 * 
	 * @param objectToTurnIntoString The object to turn into String
	 * @param defaultIfNull What to return if the object is null
	 * @return The object as a String or defaultIfNull if the object is null
	 */
	public String safeToString(Object objectToTurnIntoString, String defaultIfNull)
	{
		if(objectToTurnIntoString == null)
		{
			return defaultIfNull;
		}
		
		return objectToTurnIntoString.toString();
	}
	
	/**
	 * Check a String to see if it equals (case insensitive) one of these strings
	 * 
	 * @param stringToTest The String to test
	 * @param validStrings An array of the valid Strings to test
	 * @return <code>true</code> if the String to test equals one of the valid Strings
	 */
	public boolean isOneOfTheseStrings(String stringToTest, String... validStrings)
	{
		return isOneOfTheseStrings(stringToTest, true, validStrings);
	}
	
	/**
	 * Check a String to see if it equals one of these strings
	 * 
	 * @param stringToTest The String to test
	 * @param ignoreCase If <code>true</code> the test will ignore case
	 * @param validStrings An array of the valid Strings to test
	 * @return <code>true</code> if the String to test equals one of the valid Strings
	 */
	public boolean isOneOfTheseStrings(String stringToTest, boolean ignoreCase, String... validStrings)
	{
		if(stringToTest == null || validStrings.length == 0)
		{
			return false;
		}
		
		for(String validString : validStrings)
		{
			if(ignoreCase)
			{
				boolean isEqual = validString.equalsIgnoreCase(stringToTest);
				if(isEqual)
				{
					return true;
				}
			}
			else
			{
				boolean isEqual = validString.equals(stringToTest);
				if(isEqual)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * Check a String to see if it does not equal (case insensitive) one of these strings
	 * 
	 * @param stringToTest The String to test
	 * @param validStrings An array of the valid Strings to test
	 * @return <code>true</code> if the String to test does not equal one of the valid Strings
	 */
	public boolean isNotOneOfTheseStrings(String stringToTest, String... validStrings)
	{
		return !isOneOfTheseStrings(stringToTest, validStrings);
	}
	
	/**
	 * Check a String to see if it does not equal one of these strings
	 * 
	 * @param stringToTest The String to test
	 * @param ignoreCase If <code>true</code> the test will ignore case
	 * @param validStrings An array of the valid Strings to test
	 * @return <code>true</code> if the String to test does not equal one of the valid Strings
	 */
	public boolean isNotOneOfTheseStrings(String stringToTest, boolean ignoreCase, String... validStrings)
	{
		return !isOneOfTheseStrings(stringToTest, ignoreCase, validStrings);
	}
	
	/**
	 * Checks a String if it has a pattern that would translate to a boolean true
	 * 
	 * @param value The String to check
	 * @return <code>true</code> if this String can be translated into a boolean true
	 */
	public boolean isTrue(String value)
	{
		if(value == null)
		{
			return false;
		}

		if("yes".equalsIgnoreCase(value) || "y".equalsIgnoreCase(value) || "Yes - Finished".equalsIgnoreCase(value)
				|| "Yes - Unfinished".equalsIgnoreCase(value))
		{
			return true;
		}

		return false;
	}
	
	/**
	 * Convert a Boolean object into the desired String format
	 * 
	 * @param booleanString The Boolean to convert. It can be null
	 * @param format The format to use for the string
	 * @return A String representation of the Boolean based on the requested format
	 */
	public String toString(Boolean booleanString, BooleanFormat format)
	{
		if(format == null)
		{
			throw new IllegalArgumentException("Boolean cannot be converted without a format");
		}
		
		if(booleanString == null)
		{
			return format.getNullString();
		}
		
		if(Boolean.TRUE == booleanString)
		{
			return format.getTrueString(); 
		}
		
		return format.getFalseString();
	}
	
	/**
	 * Convert the current Date at midnight into a date string with a specified format
	 * 
	 * @param dateFormatString The date format to use to build the string
	 * @return The current Date at midnight as a String
	 */
	public String todayAsString(String dateFormatString)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatString);
		
		LocalDate today = LocalDate.now();
		
		LocalDateTime now = today.atStartOfDay();
		
        return now.format(formatter);
	}
	
	/**
	 * Convert the current Date into a date string with a specified format
	 * 
	 * @param dateFormatString The date format to use to build the string
	 * @return The current Date as a String
	 */
	public String nowAsString(String dateFormatString)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatString);
		
		LocalDateTime now = LocalDateTime.now();
		
        return now.format(formatter);
	}
	
	/**
	 * Format a number based on a pattern
	 * 
	 * @param number The number to format. If null, zero will be substituted
	 * @param pattern The format to use
	 * @return The number formatted per the pattern
	 */
	public String formatNumber(Number number, String pattern) 
	{
        if(number == null) 
        {
        	number = BigDecimal.ZERO;
        }
        
        if (pattern == null )
        {
            pattern = "#,##0,###.##;-#,##0,###.#0";
        }

        return new DecimalFormat(pattern).format(number);
    }
	
	/**
	 * Format a number a the number of thousands of dollars. ie. 250000 will return $250k
	 * @param number The number to format
	 * @return The number as a $###k String or an empty String if the number is null
	 */
	public String formatDollarsAsK(Number number) 
	{
        if(number == null) 
        {
            return "";
        }
        
        int intValue = number.intValue();
        
        int thousands = (intValue - (intValue % 1000))/1000;
        
        return "$" + formatNumber(thousands, "#,###,###")+ "k";
    }
	
	/**
	 * Inspects a String a determines how many Strings it would be turned into if split based on a delimiter
	 * 
	 * @param stringToSplit The String to inspect
	 * @param delimiter The delimiter character
	 * @return The number of Strings this would be split into. If the String to split is <code>null</code> or blank, 
	 * 0 will be returned
	 */
	public int splitCount(String stringToSplit, char delimiter)
	{
		if(stringToSplit == null || stringToSplit.isBlank())
		{
			return 0;
		}
		
		return stringToSplit.split(String.valueOf(delimiter)).length;
	}
	
	/**
	 * Get a substring between to portions of the String. An example for a stringToParse of
	 * 'I would like you to parse this string for me'
	 * 
	 * A leadingString of 'like you ' and a trailingString of ' for' would return
	 * 'to parse this string'
	 * 
	 * @param stringToParse The String to parse
	 * @param leadingString The marker for where to start
	 * @param trailingString The marker for where to end
	 * @return The first substring found between the leading and trailing strings. If nothing 
	 * could be found, then an empty String will be returned. If any of the arguments are 
	 * <code>null</code> or empty, then an IllegalArgumentException will be returned
	 */
	public String getSubstringBetween(String stringToParse, String leadingString, String trailingString)
	{
		if(stringToParse == null || stringToParse.isEmpty())
		{
			throw new IllegalArgumentException("Cannot get a substring from a null or empty string");
		}
		
		if(leadingString == null || leadingString.isEmpty())
		{
			throw new IllegalArgumentException("Cannot get a substring from a null or empty "
					+ "leading string");
		}
		
		if(trailingString == null || trailingString.isEmpty())
		{
			throw new IllegalArgumentException("Cannot get a substring from a null or empty "
					+ "trailing string");
		}
		
		int startIndex = stringToParse.indexOf(leadingString) + leadingString.length();
		
		if(startIndex == -1)
		{
			return "";
		}
		
		int endIndex = stringToParse.indexOf(trailingString);
		
		if(startIndex >= endIndex)
		{
			return "";
		}
		
		return stringToParse.substring(startIndex, endIndex);
	}
	
	/**
	 * Convert any object into a JSON String
	 * 
	 * @param object The object to convert to JSON
	 * @return The object as JSON or as toString if a Jackson issue occurred
	 */
	public String toJsonString(Object object)
	{
		return toJsonString(object, false);
	}
	
	/**
	 * Convert any object into a JSON String
	 * 
	 * @param object The object to convert to JSON
	 * @param removeWhitespace Remove whitespace from the resultant JSON
	 * @return The object as JSON or as toString if a Jackson issue occurred
	 */
	public String toJsonString(Object object, boolean removeWhitespace)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try
		{
			String jsonString = objectMapper.writeValueAsString(object);
			
			if(removeWhitespace)
			{
				return removeJsonWhitespace(jsonString);
			}
			
			return jsonString;
		}
		catch(JsonProcessingException e)
		{
			LOG.error("A Jackson error occurred converting object to JSON", e);
		}
		
		return object.toString();
	}
	
	/**
	 * Take a JSON string and remove all whitespace characters for storage or transmission using
	 * Jackson
	 * 
	 * @param jsonString The JSON String to format
	 * @return The JSON with all whitespace removed. If the input is <code>null</code> then null 
	 * will be returned. If there was an issue with Jackson performing the formatting then the
	 * issue will be logged and the original String will be returned
	 */
	public String removeJsonWhitespace(String jsonString)
	{
		if(jsonString == null)
		{
			return null;
		}

		try
		{
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = objectMapper.readTree(jsonString);
		    return objectMapper.writeValueAsString(jsonNode); 
		}
		catch(JsonProcessingException e)
		{
			LOG.error("An error has occurred processing this JSON:\n" + jsonString, e);
		}
		
	    return jsonString;
	}
}
