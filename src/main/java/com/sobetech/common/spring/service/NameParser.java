/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.spring.service;

import org.springframework.stereotype.Service;

/**
 * Service to take a string and parse names of people. This should be in a library
 *
 * @author John Murray
 *
 * @since Apr 30, 2024
 *
 */
@Service
public class NameParser
{
	/**
	 * From a String containing more than just the first name of a person, parse out just the first name.
	 * The expected format of the name is first name, middle name, last name, name suffix. If it cannot be parsed,
	 * an empty string will be returned. 
	 * 
	 * This will account for the following
	 *
	 * First names that are initials ex J. J.
	 * Last names that are 2 parts ex Van Ness
	 * Names that contain common middle names. See getMiddleName for details
	 * Names that contain suffixes. Set getSuffix for details
	 * 
	 * @param nameString The name of the person to be parsed
	 * @return The first name of the person if it can be parsed. Else an empty String is returned
	 */
	public String getFirstName(String nameString)
	{
		if(nameString == null)
		{
			return nameString;
		}
		
		// Clean up whitespace
		nameString = nameString.strip();
		
		if(nameString.isBlank())
		{
			return nameString;
		}
		
		// Find out how many spaces we have
		String[] namePortions = nameString.split(" ");
		
		// Single name person like Madonna
		if(namePortions.length == 1)
		{
			return nameString;
		}
		
		// Basic name pattern
		if(namePortions.length == 2)
		{
			return namePortions[0];
		}
		
		// Handle ones with suffixes
		if(namePortions.length == 3)
		{
			if(hasSuffix(nameString) || hasTwoPartLastName(nameString) || hasMiddleInitial(nameString) 
					|| hasCommonMiddleName(nameString))
			{
				return namePortions[0];
			}
			
			if(hasInitialedFirstName(nameString))
			{
				return getInitialedFirstName(nameString);
			}
		}

		return "";
	}
	
	/**
	 * From a String containing more than just the last name of a person, parse out just the last name.
	 * The expected format of the name is first name, middle name, last name, name suffix. If it cannot be parsed,
	 * an empty string will be returned. 
	 * 
	 * This will account for the following
	 *
	 * First names that are initials ex J. J.
	 * Last names that are 2 parts ex Van Ness
	 * Names that contain common middle names. See getMiddleName for details
	 * Names that contain suffixes. Set getSuffix for details
	 * 
	 * @param nameString The name of the person to be parsed
	 * @return The last name of the person if it can be parsed. Else an empty String is returned
	 */
	public String getLastName(String nameString)
	{
		if(nameString == null)
		{
			return nameString;
		}
		
		// Clean up whitespace
		nameString = nameString.strip();
		
		if(nameString.isBlank())
		{
			return nameString;
		}
		
		// Find out how many spaces we have
		String[] namePortions = nameString.split(" ");
		
		// Single name person like Madonna
		if(namePortions.length == 1)
		{
			return "";
		}
		
		// Basic name pattern
		if(namePortions.length == 2)
		{
			return namePortions[1];
		}
		
		// Handle ones with suffixes
		if(namePortions.length == 3)
		{
			if(hasSuffix(nameString))
			{
				return namePortions[1];
			}
			
			if(hasTwoPartLastName(nameString))
			{
				return getTwoPartLastName(nameString);
			}
			
			if(hasMiddleInitial(nameString) || hasCommonMiddleName(nameString) || hasInitialedFirstName(nameString))
			{
				return namePortions[2];
			}
		}

		return "";
	}
	
	/**
	 * From a String containing more than just the middle name of a person, parse out just the middle name.
	 * The expected format of the name is first name, middle name, last name, name suffix. If it cannot be parsed,
	 * an empty string will be returned. 
	 * 
	 * Expected middle names are either initials or these common middle names
	 * 
	 * JOE
	 * LEE
	 * HENRY
	 * DAVID
	 * MICHAEL
	 * DEAN
	 * TOM
	 * 
	 * This will account for the following
	 *
	 * First names that are initials ex J. J.
	 * Last names that are 2 parts ex Van Ness
	 * Names that contain suffixes. Set getSuffix for details
	 * 
	 * @param nameString The name of the person to be parsed
	 * @return The middle name of the person if it can be parsed. Else an empty String is returned
	 */
	public String getMiddleName(String nameString)
	{
		if(nameString == null)
		{
			return nameString;
		}
		
		// Clean up whitespace
		nameString = nameString.strip();
		
		if(nameString.isBlank())
		{
			return nameString;
		}
		
		// Find out how many spaces we have
		String[] namePortions = nameString.split(" ");

		// Handle ones with suffixes
		if(namePortions.length == 3)
		{
			if(hasMiddleInitial(nameString) || hasCommonMiddleName(nameString))
			{
				return namePortions[1];
			}
		}

		return "";
	}
	
	/**
	 * From a String containing more than just the first name of a person, parse out just the first name if it is
	 * a set of initials. For example J. J.
	 * The expected format of the name is first name, middle name, last name, name suffix. If it cannot be parsed,
	 * an empty string will be returned. 
	 * 
	 * This will account for the following

	 * Last names that are 2 parts ex Van Ness
	 * Names that contain common middle names. See getMiddleName for details
	 * Names that contain suffixes. Set getSuffix for details
	 * 
	 * @param nameString The name of the person to be parsed
	 * @return The first name of the person if it can be parsed as a set of initials. Else an empty String is returned
	 */
	public String getInitialedFirstName(String nameString)
	{
		if(nameString == null)
		{
			return nameString;
		}
		
		// Clean up whitespace
		nameString = nameString.strip();
		
		if(nameString.isBlank())
		{
			return nameString;
		}
		
		// Find out how many spaces we have
		String[] namePortions = nameString.split(" ");
		
		// Initialed first names normally will have 3 portions
		if(namePortions.length == 3)
		{
			if(hasSuffix(nameString))
			{
				//return namePortions[0];
				return "";
			}
			
			if(characterCount(nameString, '.') < 2)
			{
				return "";
			}
			
			return String.format("%s %s", namePortions[0], namePortions[1]);
		}

		return "";
	}
	
	
	/**
	 * From a String containing more than just the ame suffix of a person, parse out just the ame suffix.
	 * The expected format of the name is first name, middle name, last name, name suffix. If the suffix has a trailing
	 * period, it will be stripped off. If it cannot be parsed, an empty string will be returned. 
	 * 
	 * Expected suffixes are
	 * 
	 * JR
	 * SR
	 * II
	 * III
	 * IV
	 * 
	 * This will account for the following
	 *
	 * First names that are initials ex J. J.
	 * Last names that are 2 parts ex Van Ness
	 * Names that contain common middle names. See getMiddleName for details
	 * 
	 * @param nameString The name of the person to be parsed
	 * @return The ame suffix of the person if it can be parsed. Else an empty String is returned
	 */
	public String getSuffix(String nameString)
	{
		if(nameString == null)
		{
			return nameString;
		}
		
		// Clean up whitespace
		nameString = nameString.strip();
		
		if(nameString.isBlank())
		{
			return nameString;
		}
		
		// Find out how many spaces we have
		String[] namePortions = nameString.split(" ");

		// Handle ones with suffixes
		if(namePortions.length == 3)
		{
			String suffix = namePortions[2].toUpperCase();
			
			// Strip off trailing period
			if(suffix.endsWith("."))
			{
				suffix = suffix.substring(0, suffix.length() - 1);
			}
			
			switch (suffix)
			{
				case "JR":
				case "II":
				case "III":
				case "IV":
				case "SR":
					return suffix;
					
				default:
					return "";
			}
		}

		return "";
	}
	
	/**
	 * From a String, get the number of occurrences of a character
	 * 
	 * @param string The String to inspect
	 * @param character The character to search for
	 * @return The number of occurrences of the character in the String
	 */
	public int characterCount(String string, char character)
	{
		int count = 0;
		
		if(string == null)
		{
			return count;
		}

		for(int index = 0; index < string.length(); index++)
		{
			if(string.charAt(index) == character)
			{
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Does this name have a suffix. See getSuffix for details
	 * 
	 * @param nameString The name String to inspect
	 * @return <code>true</code> if the name String has a suffix that can be parsed from it
	 */
	public boolean hasSuffix(String nameString)
	{
		return !getSuffix(nameString).isBlank();
	}
	
	/**
	 * Does this name have an initialized first name. See getInitialedFirstName for details
	 * 
	 * @param nameString The name String to inspect
	 * @return <code>true</code> if the name String has an initialized first name that can be parsed from it
	 */
	public boolean hasInitialedFirstName(String nameString)
	{
		return !getInitialedFirstName(nameString).isBlank();
	}

	public String getTwoPartLastName(String nameString)
	{
		if(nameString == null)
		{
			return "";
		}
		
		// Clean up whitespace
		nameString = nameString.strip();
		
		if(nameString.isBlank())
		{
			return "";
		}
		
		// Weed out other cases
		if(hasSuffix(nameString) || hasInitialedFirstName(nameString))
		{
			return "";
		}
		
		// Find out how many spaces we have
		String[] namePortions = nameString.split(" ");
		
		if(namePortions.length == 3)
		{
			String middle = namePortions[1].toUpperCase();
			
			// Strip off trailing period
			if(middle.endsWith("."))
			{
				middle = middle.substring(0, middle.length() - 1);
			}
			
			switch (middle)
			{
				case "AH":
				case "ST":
				case "VAN":
				case "VANDEN":
				case "VANDER":
				case "VON":
					return String.format("%s %s", namePortions[1], namePortions[2]);
					
				default:
					return "";
			}
		}
		
		return "";
	}
	
	/**
	 * Does this name have a two part last name. See getTwoPartLastName for details
	 * 
	 * @param nameString The name String to inspect
	 * @return <code>true</code> if the name String has a two part last name that can be parsed from it
	 */
	public boolean hasTwoPartLastName(String nameString)
	{
		return !getTwoPartLastName(nameString).isBlank();
	}
	
	/**
	 * Does this name have a middle initial. The will only be true if the middle name has a single character with or 
	 * without a trailing period
	 * 
	 * @param nameString The name String to inspect
	 * @return <code>true</code> if the name String has a middle initial that can be parsed from it
	 */
	public boolean hasMiddleInitial(String nameString)
	{
		if(nameString == null)
		{
			return false;
		}
		
		// Clean up whitespace
		nameString = nameString.strip();
		
		if(nameString.isBlank())
		{
			return false;
		}
		
		// Weed out other cases
		if(hasSuffix(nameString) || hasInitialedFirstName(nameString))
		{
			return false;
		}
		
		// Find out how many spaces we have
		String[] namePortions = nameString.split(" ");
		
		if(namePortions.length == 3)
		{
			String middle = namePortions[1].toUpperCase();
			
			if(middle.length() == 1 || (middle.length() == 2 && middle.endsWith(".")))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Does this name have a common middle name. This is NOT a comprehensive list! The known common middle names are
	 * 
	 * David
	 * Dean
	 * Henry
	 * Joe
	 * Lee
	 * Michael
	 * Tom
	 * 
	 * @param nameString The name String to inspect
	 * @return <code>true</code> if the name String has a suffix that can be parsed from it
	 */
	public boolean hasCommonMiddleName(String nameString)
	{
		if(nameString == null)
		{
			return false;
		}
		
		// Clean up whitespace
		nameString = nameString.strip();
		
		if(nameString.isBlank())
		{
			return false;
		}
		
		// Weed out other cases
		if(hasSuffix(nameString) || hasInitialedFirstName(nameString) || hasTwoPartLastName(nameString))
		{
			return false;
		}
		
		// Find out how many spaces we have
		String[] namePortions = nameString.split(" ");
		
		if(namePortions.length == 3)
		{
			String middle = namePortions[1].toUpperCase();
			
			// Strip off trailing period
			if(middle.endsWith("."))
			{
				middle = middle.substring(0, middle.length() - 1);
			}
			
			switch (middle)
			{
				case "JOE":
				case "LEE":
				case "HENRY":
				case "DAVID":
				case "MICHAEL":
				case "DEAN":
				case "TOM":
					return true;
					
				default:
					return false;
			}
		}
		
		return false;
	}
	
	/**
	 * Check if this name String does NOT conform to any of the known parsing methods. If the name String is 
	 *  <code>null</code> or blank,  <code>true</code> will be returned.
	 * 
	 * First Name - Last Name
	 * Initialized First Name - Last Name
	 * First Name - Last Name = Suffix
	 * First Name - Last Name Part 1 - Last Name Part 2
	 * First Name - Middle Initial - Last Name
	 * First Name - Common Middle Name - Last Name
	 * 
	 * @param nameString The name String to inspect
	 * @return <code>true</code> if the name String has a suffix that can be parsed from it. Otherwise <code>false</code> 
	 */
	public boolean hasFunkyName(String nameString)
	{
		if(nameString == null)
		{
			return true;
		}
		
		// Clean up whitespace
		nameString = nameString.strip();
		
		if(nameString.isBlank())
		{
			return true;
		}
		
		// Find out how many spaces we have
		String[] namePortions = nameString.split(" ");
		
		// Single name person like Madonna
		if(namePortions.length > 2)
		{
			if(hasInitialedFirstName(nameString) || hasSuffix(nameString) || hasTwoPartLastName(nameString) 
					|| hasMiddleInitial(nameString) || hasCommonMiddleName(nameString))
			{
				return false;
			}
			
			return true;
		}

		return false;
	}
}
