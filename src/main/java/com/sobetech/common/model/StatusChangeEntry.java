/**
 * Created by Sobetech Holdings LLC
 *
 * Copyright © 2022 Sobetech Holdings LLC, All Rights Reserved
 *
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with Sobetech Holdings LLC, or one of its affiliates,
 * and may not be used, disseminated, or distributed except in accordance with
 * the terms of that agreement.
 *
 */
package com.sobetech.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;

import java.util.Date;

/**
 * POJO for auditing the changes in status of an object
 *
 *
 * @author John.Murray
 *
 * @since Mar 8, 2023
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "POJO for auditing the changes in status of an object")
public class StatusChangeEntry 
{
	@Schema(accessMode = AccessMode.READ_ONLY, description = "The new status this object was changed to")
	private String status;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "UTC")
    @Schema(accessMode = AccessMode.READ_ONLY, description = "The date the change occurred")
	private Date date;
    
    @Schema(accessMode = AccessMode.READ_ONLY, description = "Id of user who made change")
    private Long changedByUserId;
    
    public StatusChangeEntry()
    {
    }
    
    public StatusChangeEntry(String status)
    {
    	super();
    	this.status = status;
    	this.date = new Date();
    	this.changedByUserId = null;
    }
    
    public StatusChangeEntry(String status, Long userId)
    {
    	super();
    	this.status = status;
    	this.date = new Date();
    	this.changedByUserId = userId;
    }

	/**
	 * Getter for attribute status
	 *
	 * @return the status
	 */
	public String getStatus()
	{
		return this.status;
	}

	/**
	 * Setter for attribute status
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * Getter for attribute date
	 *
	 * @return the date
	 */
	public Date getDate()
	{
		return this.date;
	}

	/**
	 * Setter for attribute date
	 *
	 * @param date the date to set
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}

	/**
	 * Getter for attribute changedByUserId
	 *
	 * @return the changedByUserId
	 */
	public Long getChangedByUserId()
	{
		return this.changedByUserId;
	}

	/**
	 * Setter for attribute changedByUserId
	 *
	 * @param changedByUserId the changedByUserId to set
	 */
	public void setChangedByUserId(Long changedByUserId)
	{
		this.changedByUserId = changedByUserId;
	}
}