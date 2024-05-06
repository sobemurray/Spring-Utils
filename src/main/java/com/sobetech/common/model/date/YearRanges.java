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
package com.sobetech.common.model.date;

import java.util.Set;
import java.util.TreeSet;

/**
 * A POJO to work with year ranges
 *
 * @author John Murray
 *
 * @since May 5, 2024
 *
 */
public class YearRanges
{
	private int startYear;
	
	private int endYear;
	
	private Set<Integer> includedYears;
	
	private Set<Integer> excludedYears;
	
	/**
	 * Default constructor
	 */
	public YearRanges()
	{	
	}
	
	public YearRanges(int startYear, int endYear)
	{	
		this.startYear = startYear;
		this.endYear = endYear;
	}
	
	/**
	 * Add a year to the Set of included years
	 * 
	 * @param yearToInclude The year to include
	 * @return <code>true</code> if this year has been added to the Set of included years
	 */
	public boolean addIncludedYear(int yearToInclude)
	{
		if(this.includedYears == null)
		{
			this.includedYears = new TreeSet<>();
		}
		
		return this.includedYears.add(yearToInclude);
	}
	
	/**
	 * Add a year to the Set of included years
	 * 
	 * @param yearToExclude The year to include
	 * @return <code>true</code> if this year has been added to the Set of included years
	 */
	public boolean addExcludedYear(int yearToExclude)
	{
		if(this.excludedYears == null)
		{
			this.excludedYears = new TreeSet<>();
		}
		
		return this.excludedYears.add(yearToExclude);
	}

	/**
	 * Getter for attribute startYear
	 *
	 * @return the startYear
	 */
	public int getStartYear()
	{
		return this.startYear;
	}

	/**
	 * Setter for attribute startYear
	 *
	 * @param startYear the startYear to set
	 */
	public void setStartYear(int startYear)
	{
		this.startYear = startYear;
	}

	/**
	 * Getter for attribute endYear
	 *
	 * @return the endYear
	 */
	public int getEndYear()
	{
		return this.endYear;
	}

	/**
	 * Setter for attribute endYear
	 *
	 * @param endYear the endYear to set
	 */
	public void setEndYear(int endYear)
	{
		this.endYear = endYear;
	}

	/**
	 * Getter for attribute includedYears
	 *
	 * @return the includedYears
	 */
	public Set<Integer> getIncludedYears()
	{
		return this.includedYears;
	}

	/**
	 * Setter for attribute includedYears
	 *
	 * @param includedYears the includedYears to set
	 */
	public void setIncludedYears(Set<Integer> includedYears)
	{
		this.includedYears = includedYears;
	}

	/**
	 * Getter for attribute excludedYears
	 *
	 * @return the excludedYears
	 */
	public Set<Integer> getExcludedYears()
	{
		return this.excludedYears;
	}

	/**
	 * Setter for attribute excludedYears
	 *
	 * @param excludedYears the excludedYears to set
	 */
	public void setExcludedYears(Set<Integer> excludedYears)
	{
		this.excludedYears = excludedYears;
	}
}
