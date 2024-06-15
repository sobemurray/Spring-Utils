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
package com.sobetech.common.util;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A LinkedHashMap that has a size limit
 *
 * @author John Murray
 *
 * @since Jun 9, 2024
 *
 * @param <K> The object that will be used as the key for the map
 * @param <V> The type of object that this map will contain
 *
 */
public class BoundedMap<K, V> extends LinkedHashMap<K, V>
{
	private final int maximumEntries;
	
	/**
	 * Create a new BoundedMap with a maximum size
	 * 
	 * @param maximumEntries The maximum number of entries this map will contain
	 */
	public BoundedMap(int maximumEntries)
	{
		super(maximumEntries + 1, 1.0f, true);
		this.maximumEntries = maximumEntries;
	}
	
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest)
	{
		return size() > this.maximumEntries;
	}
}