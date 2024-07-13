/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Team Focus / Peak6, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.model.graph;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.sobetech.common.enums.IndexedEnum;
import com.sobetech.common.enums.StringEnum;

/**
 * A POJO containing a data point to be graphed. The attribute names are mandated by
 * ngx-charts
 *
 * @author John Murray
 *
 * @since Jul 13, 2024
 *
 */
public class GraphItem
{
	// Make these generic
	
	/*
	 * This has to be named 'name' for ngx-charts
	 */
	private String name;
	
	/*
	 * This has to be named 'value' for ngx-charts
	 */
	private int value;
	
	@JsonIgnore
	private int orderIndex;
	
	/**
	 * Initialize and populate with a value of 1
	 * 
	 * @param stringEnum The StringEnum whose description will be used as the name
	 */
	public GraphItem(StringEnum stringEnum)
	{
		this(stringEnum.getDescription(), 1);
		
		if(stringEnum instanceof IndexedEnum)
		{
			IndexedEnum indexedEnum = (IndexedEnum)stringEnum;
			this.orderIndex = indexedEnum.getIndex();
		}
	}
	
	/**
	 * Initialize and populate with a value of 1
	 * 
	 * @param name The name of the item
	 */
	public GraphItem(String name)
	{
		this(name, 1);
	}
	
	/**
	 * Initialize and populate 
	 * 
	 * @param name The name of the item
	 * @param value The value of the item
	 */
	public GraphItem(String name, int value)
	{
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Does the name of this item match the description of this StringEnum
	 * 
	 * @param stringEnum The StringEnum to check
	 * @return <code>true</code> if this GraphItem has the name matching the description of this
	 * StringEnum
	 */
	public boolean matchingItem(StringEnum stringEnum)
	{
		if(stringEnum == null)
		{
			return false;
		}
		
		return stringEnum.getDescription().equals(getName());
	}
	
	/**
	 * Increment the value of this item
	 * 
	 * @return The new value
	 */
	public int incrementValue()
	{
		return this.value++;
	}

	/**
	 * Getter for attribute name
	 *
	 * @return the name
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Setter for attribute name
	 *
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Getter for attribute value
	 *
	 * @return the value
	 */
	public int getValue()
	{
		return this.value;
	}

	/**
	 * Setter for attribute value
	 *
	 * @param value the value to set
	 */
	public void setValue(int value)
	{
		this.value = value;
	}

	/**
	 * Getter for attribute orderIndex
	 *
	 * @return the orderIndex
	 */
	public int getOrderIndex()
	{
		return this.orderIndex;
	}

	/**
	 * Setter for attribute orderIndex
	 *
	 * @param orderIndex the orderIndex to set
	 */
	public void setOrderIndex(int orderIndex)
	{
		this.orderIndex = orderIndex;
	}
}
