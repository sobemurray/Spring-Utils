/**
 * Created by Sobetech Holdings LLC
 *
 * Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with Sobetech Holdings LLC, or one of its affiliates,
 * and may not be used, disseminated, or distributed except in accordance with
 * the terms of that agreement.
 *
 */
package com.sobetech.common.model.io.result;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.sobetech.common.enums.io.ExportType;
import com.sobetech.common.enums.io.ImportType;

/**
 * POJO to hold details on the results of an import process
 * 
 * String durationString = String.format("%02d:%02d:%02d",
 * totalDuration.toHoursPart(), totalDuration.toMinutesPart(),
 * totalDuration.toSecondsPart());
 *
 * @author John Murray
 *
 * @since May 3, 2024
 *
 * @param <O> The type of object to include in the additionalInformation
 */
@JsonInclude(Include.NON_NULL)
public class ImportResult <O extends Object>
{
	private String importDescription;
	
	private long recordsParsed;
	
	private long recordsImported;

	private long recordsRejected;

	private long recordsUpdated;

	private long recordsRemoved;

	private List<String> warnings;

	private List<String> errors;

	@JsonIgnore
	private Duration duration;
	
	private String importDuration;
	
	private ImportType importType;
	
	private ExportType exportType;
	
	private String destinationName;

	private Date startDate;
	
	private O additionalInformation;

	/**
	 * Create a result with the start time set to now
	 */
	public ImportResult()
	{
		super();
		this.startDate = new Date(System.currentTimeMillis());
		this.warnings = new ArrayList<>();
		this.errors = new ArrayList<>();
	}

	/**
	 * Create a result with a description and the start time set to now
	 * 
	 * @param importDescription The importDescription to set
	 */
	public ImportResult(String importDescription)
	{
		this();
		this.importDescription = importDescription;
	}
	
	/**
	 * Convenience method to see if this is a successful result
	 * 
	 * @return <code>true</code> if the errors collection is <code>null</code> or empty
	 */
	public boolean successful()
	{
		return this.errors == null || this.errors.isEmpty();
	}

	/**
	 * Add a warning to the results
	 * 
	 * @param warning
	 *            The warning String to add
	 * @return <code>true</code> if the warning has been added
	 */
	public boolean addWarning(String warning)
	{
		if(warning == null || warning.isBlank())
		{
			return false;
		}

		if(this.warnings == null)
		{
			this.warnings = new ArrayList<>();
		}

		return this.warnings.add(warning);
	}

	/**
	 * Add an error to the results
	 * 
	 * @param error
	 *            The error String to add
	 * @return <code>true</code> if the error has been added
	 */
	public boolean addError(String error)
	{
		if(error == null || error.isBlank())
		{
			return false;
		}

		if(this.errors == null)
		{
			this.errors = new ArrayList<>();
		}

		return this.errors.add(error);
	}

	/**
	 * Set the duration of the process
	 * 
	 * @param startDate
	 *            The Date when the process started
	 * @param endDate
	 *            The Date when the process ended
	 * @return The Duration that was set
	 */
	public Duration setDuration(Date startDate, Date endDate)
	{
		if(startDate == null || endDate == null)
		{
			throw new IllegalArgumentException("Cannot set a duration without a start and end date");
		}

		this.startDate = startDate;

		return setDuration(startDate.getTime(), endDate.getTime());
	}

	/**
	 * Set the duration of the process
	 * 
	 * @param startTimeMillis
	 *            Start time in milliseconds
	 * @param endTimeMillis
	 *            End time in milliseconds
	 * @return The Duration that was set
	 */
	public Duration setDuration(long startTimeMillis, long endTimeMillis)
	{
		this.startDate = new Date(startTimeMillis);
		this.duration = Duration.ofMillis(endTimeMillis - startTimeMillis);
		return getDuration();
	}

	/**
	 * Getter for attribute importDuration
	 *
	 * @return the importDuration
	 */
	public String getImportDuration()
	{
		return this.importDuration;
	}

	/**
	 * Setter for attribute importDuration
	 *
	 * @param importDuration the importDuration to set
	 */
	public void setImportDuration(String importDuration)
	{
		this.importDuration = importDuration;
	}

	/**
	 * Set the end time as the current system time
	 * 
	 * @return The Duration that has now been properly set
	 */
	public Duration setEndTime()
	{
		return setDuration(this.startDate.getTime(), System.currentTimeMillis());
	}

	/**
	 * Getter for attribute importDescription
	 *
	 * @return the importDescription
	 */
	public String getImportDescription()
	{
		return this.importDescription;
	}

	/**
	 * Setter for attribute importDescription
	 *
	 * @param importDescription the importDescription to set
	 */
	public void setImportDescription(String importDescription)
	{
		this.importDescription = importDescription;
	}

	/**
	 * Getter for attribute recordsParsed
	 *
	 * @return the recordsParsed
	 */
	public long getRecordsParsed()
	{
		return this.recordsParsed;
	}

	/**
	 * Setter for attribute recordsParsed
	 *
	 * @param recordsParsed the recordsParsed to set
	 */
	public void setRecordsParsed(long recordsParsed)
	{
		this.recordsParsed = recordsParsed;
	}

	/**
	 * Getter for attribute recordsImported
	 *
	 * @return the recordsImported
	 */
	public long getRecordsImported()
	{
		return this.recordsImported;
	}

	/**
	 * Setter for attribute recordsImported
	 *
	 * @param recordsImported
	 *            the recordsImported to set
	 */
	public void setRecordsImported(long recordsImported)
	{
		this.recordsImported = recordsImported;
	}

	/**
	 * Getter for attribute recordsRejected
	 *
	 * @return the recordsRejected
	 */
	public long getRecordsRejected()
	{
		return this.recordsRejected;
	}

	/**
	 * Setter for attribute recordsRejected
	 *
	 * @param recordsRejected
	 *            the recordsRejected to set
	 */
	public void setRecordsRejected(long recordsRejected)
	{
		this.recordsRejected = recordsRejected;
	}

	/**
	 * Getter for attribute recordsUpdated
	 *
	 * @return the recordsUpdated
	 */
	public long getRecordsUpdated()
	{
		return this.recordsUpdated;
	}

	/**
	 * Setter for attribute recordsUpdated
	 *
	 * @param recordsUpdated
	 *            the recordsUpdated to set
	 */
	public void setRecordsUpdated(long recordsUpdated)
	{
		this.recordsUpdated = recordsUpdated;
	}

	/**
	 * Getter for attribute recordsRemoved
	 *
	 * @return the recordsRemoved
	 */
	public long getRecordsRemoved()
	{
		return this.recordsRemoved;
	}

	/**
	 * Setter for attribute recordsRemoved
	 *
	 * @param recordsRemoved
	 *            the recordsRemoved to set
	 */
	public void setRecordsRemoved(long recordsRemoved)
	{
		this.recordsRemoved = recordsRemoved;
	}

	/**
	 * Getter for attribute warnings
	 *
	 * @return the warnings
	 */
	public List<String> getWarnings()
	{
		return this.warnings;
	}

	/**
	 * Setter for attribute warnings
	 *
	 * @param warnings
	 *            the warnings to set
	 */
	public void setWarnings(List<String> warnings)
	{
		this.warnings = warnings;
	}

	/**
	 * Getter for attribute errors
	 *
	 * @return the errors
	 */
	public List<String> getErrors()
	{
		return this.errors;
	}

	/**
	 * Setter for attribute errors
	 *
	 * @param errors
	 *            the errors to set
	 */
	public void setErrors(List<String> errors)
	{
		this.errors = errors;
	}

	/**
	 * Getter for attribute duration
	 *
	 * @return the duration
	 */
	public Duration getDuration()
	{
		return this.duration;
	}

	/**
	 * Setter for attribute duration
	 *
	 * @param duration
	 *            the duration to set
	 */
	public void setDuration(Duration duration)
	{
		this.duration = duration;
		this.importDescription = this.duration.toString();
	}

	/**
	 * Getter for attribute importType
	 *
	 * @return the importType
	 */
	public ImportType getImportType()
	{
		return this.importType;
	}

	/**
	 * Setter for attribute importType
	 *
	 * @param importType the importType to set
	 */
	public void setImportType(ImportType importType)
	{
		this.importType = importType;
	}

	/**
	 * Getter for attribute exportType
	 *
	 * @return the exportType
	 */
	public ExportType getExportType()
	{
		return this.exportType;
	}

	/**
	 * Setter for attribute exportType
	 *
	 * @param exportType the exportType to set
	 */
	public void setExportType(ExportType exportType)
	{
		this.exportType = exportType;
	}

	/**
	 * Getter for attribute destinationName
	 *
	 * @return the destinationName
	 */
	public String getDestinationName()
	{
		return this.destinationName;
	}

	/**
	 * Setter for attribute destinationName
	 *
	 * @param destinationName the destinationName to set
	 */
	public void setDestinationName(String destinationName)
	{
		this.destinationName = destinationName;
	}

	/**
	 * Getter for attribute additionalInformation
	 *
	 * @return the additionalInformation
	 */
	public O getAdditionalInformation()
	{
		return this.additionalInformation;
	}

	/**
	 * Set any additionalInformation that should be included in this result. This is left 
	 *
	 * @param additionalInformation the additionalInformation to set
	 */
	public void setAdditionalInformation(O additionalInformation)
	{
		this.additionalInformation = additionalInformation;
	}
}
