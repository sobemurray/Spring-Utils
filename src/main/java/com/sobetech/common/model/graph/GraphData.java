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

import java.util.ArrayList;
import java.util.List;

import com.sobetech.common.enums.StringEnum;

/**
 *
 *
 * @author John Murray
 *
 * @since Jul 13, 2024
 *
 */
public class GraphData
{
	private String graphName;
	
	private List<GraphItem> items = new ArrayList<>();
	
	public GraphItem getItem(StringEnum stringEnum)
	{
		for(GraphItem item : items)
		{
			if(item.matchingItem(stringEnum))
			{
				return item;
			}
		}
		
		return null;
	}
	
	public boolean containsItem(StringEnum stringEnum)
	{
		return getItem(stringEnum) != null;
	}
	
	public int incrementValue(StringEnum stringEnum)
	{
		GraphItem item = getItem(stringEnum);
		
		if(item == null)
		{
			item = new GraphItem(stringEnum);
			this.items.add(item);
			return item.getValue();
		}
		
		return item.incrementValue();
	}

	/**
	 * Getter for attribute graphName
	 *
	 * @return the graphName
	 */
	public String getGraphName()
	{
		return this.graphName;
	}

	/**
	 * Setter for attribute graphName
	 *
	 * @param graphName the graphName to set
	 */
	public void setGraphName(String graphName)
	{
		this.graphName = graphName;
	}

	/**
	 * Getter for attribute items
	 *
	 * @return the items
	 */
	public List<GraphItem> getItems()
	{
		return this.items;
	}

	/**
	 * Setter for attribute items
	 *
	 * @param items the items to set
	 */
	public void setItems(List<GraphItem> items)
	{
		this.items = items;
	}
}
