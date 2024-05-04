/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2023 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for objects that have a status history
 *
 * @author John.Murray
 *
 * @since Mar 8, 2023
 *
 */
public interface StatusAuditable
{
	/**
	 * Get a list of all of the StatusChangeEntry objects
	 * 
	 * @return All of the StatusChangeEntry objects
	 */
	List<StatusChangeEntry> getStatusChangeHistory();

	/**
	 * Replace the current StatusChangeEntry list with a new one
	 * 
	 * @param statusChangeHistory The new StatusChangeEntry list
	 */
	void setStatusChangeHistory(List<StatusChangeEntry> statusChangeHistory);
	
	/**
	 * Add a new StatusChangeEntry for today and this status
	 * 
	 * @param statusString The new status to enter
	 */
	default void addHistoryEntry(String statusString)
	{
		addHistoryEntry(new StatusChangeEntry(statusString));
	}
	
	/**
	 * Add a new StatusChangeEntry
	 * 
	 * @param newEntry The new StatusChangeEntry
	 */
	default void addHistoryEntry(StatusChangeEntry newEntry)
	{
		List<StatusChangeEntry> currentEntries = getStatusChangeHistory();
		
		if(currentEntries == null)
		{
			currentEntries = new ArrayList<>();
		}
		
		currentEntries.add(newEntry);
		
		setStatusChangeHistory(currentEntries);
	}
}
