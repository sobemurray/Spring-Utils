/**
 * Created by Sobetech Holdings LLC
 *
 * Copyright © 2023 Sobetech Holdings LLC, All Rights Reserved
 *
 * This software is supplied under the terms of a license agreement or
 * nondisclosure agreement with Sobetech Holdings LLC, or one of its affiliates,
 * and may not be used, disseminated, or distributed except in accordance with
 * the terms of that agreement.
 *
 */
package com.sobetech.common.model.validation;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.sobetech.common.exception.CodedError;

/**
 * A POJO containing the results of a validation
 *
 *
 * @author John.Murray
 *
 * @since Apr 9, 2024
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ValidationResult
{
	private long objectIdBeingValidated;
	private String objectTypeBeingValidated;
	private boolean valid = true;
	private ArrayList<String> messages;
	private ArrayList<CodedError> errors;
	
	/**
	 * Construct a new ValidationResult for an object
	 * 
	 * @param objectIdBeingValidated The ID of the object being validated
	 * @param objectTypeBeingValidated The type of object being validated. It can be a any String deemed
	 * applicable to giving good results to a user
	 */
	public ValidationResult(long objectIdBeingValidated, String objectTypeBeingValidated)
	{
		this.objectIdBeingValidated = objectIdBeingValidated;
		this.objectTypeBeingValidated = objectTypeBeingValidated;
	}
	
	/**
	 * Merge the results from one validation into these results
	 * 
	 * @param resultsToMerge The new ValidationResult attributes to merge with this one
	 */
	public void mergeResults(ValidationResult resultsToMerge)
	{
		if(resultsToMerge == null)
		{
			return;
		}
		
		if(resultsToMerge.isInvalid())
		{
			setValid(false);
		}
		
		if(resultsToMerge.hasMessages())
		{
			if(this.hasMessages())
			{
				this.messages.addAll(resultsToMerge.getMessages());
			}
			else
			{
				// Only do this in the messages because errors should always have messages, where
				// messages might not have errors
				this.objectTypeBeingValidated = resultsToMerge.getObjectTypeBeingValidated();
				this.messages = resultsToMerge.getMessages();
			}
		}
		
		if(resultsToMerge.hasErrors())
		{
			if(this.hasErrors())
			{
				this.errors.addAll(resultsToMerge.getErrors());
			}
			else
			{
				this.errors = resultsToMerge.getErrors();
			}
		}
	}

	/**
	 * Add a new issue to this result. This will also set the valid boolean to false
	 * 
	 * @param newIssue The new issue String to add
	 * @return <code>true</code> if the addition has been successful. Otherwise <code>false</code>
	 */
	public boolean addMessage(String newMessage)
	{
		if(newMessage == null || newMessage.isBlank())
		{
			return false;
		}

		if(this.messages == null)
		{
			this.messages = new ArrayList<>();
		}

		return this.messages.add(newMessage);
	}
	
	/**
	 * Add a new CodedError to this response
	 * 
	 * @param newError The new CodedError to add
	 * @return <code>true</code> if the addition has been successful. Otherwise <code>false</code>
	 */
	public boolean addError(CodedError newError)
	{
		if(newError == null)
		{
			return false;
		}

		if(this.errors == null)
		{
			this.errors = new ArrayList<>();
		}

		this.valid = false;
		return this.errors.add(newError);
	}
	
	/**
	 * Alternative getter for valid attribute
	 * 
	 * @return <code>true</code> if this result is invalid
	 */
	public boolean isInvalid()
	{
		return !isValid();
	}
	
	/**
	 * Does this result have any messages in it
	 * 
	 * @return <code>true</code> if this result has any messages
	 */
	public boolean hasMessages()
	{
		return getMessages() != null && !getMessages().isEmpty();
	}
	
	/**
	 * Does this result have any errors in it
	 * 
	 * @return <code>true</code> if this result has any errors
	 */
	public boolean hasErrors()
	{
		return getErrors() != null && !getErrors().isEmpty();
	}

	/**
	 * Getter for attribute objectIdBeingValidated
	 *
	 * @return the objectIdBeingValidated
	 */
	public long getObjectIdBeingValidated()
	{
		return this.objectIdBeingValidated;
	}

	/**
	 * Setter for attribute objectIdBeingValidated
	 *
	 * @param objectIdBeingValidated the objectIdBeingValidated to set
	 */
	public void setObjectIdBeingValidated(long objectIdBeingValidated)
	{
		this.objectIdBeingValidated = objectIdBeingValidated;
	}

	/**
	 * Getter for attribute objectTypeBeingValidated
	 *
	 * @return the objectTypeBeingValidated
	 */
	public String getObjectTypeBeingValidated()
	{
		return this.objectTypeBeingValidated;
	}

	/**
	 * Setter for attribute objectTypeBeingValidated
	 *
	 * @param objectTypeBeingValidated the objectTypeBeingValidated to set
	 */
	public void setObjectTypeBeingValidated(String objectTypeBeingValidated)
	{
		this.objectTypeBeingValidated = objectTypeBeingValidated;
	}

	/**
	 * Getter for attribute valid
	 *
	 * @return the valid
	 */
	public boolean isValid()
	{
		return this.valid;
	}

	/**
	 * Setter for attribute valid
	 *
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(boolean valid)
	{
		this.valid = valid;
	}

	/**
	 * Getter for attribute messages
	 *
	 * @return the messages
	 */
	public ArrayList<String> getMessages()
	{
		return this.messages;
	}

	/**
	 * Setter for attribute messages
	 *
	 * @param issues
	 *            the messages to set
	 */
	public void setMessages(ArrayList<String> messages)
	{
		this.messages = messages;
	}

	/**
	 * Getter for attribute errors
	 *
	 * @return the errors
	 */
	public ArrayList<CodedError> getErrors()
	{
		return this.errors;
	}

	/**
	 * Setter for attribute errors
	 *
	 * @param errors the errors to set
	 */
	public void setErrors(ArrayList<CodedError> errors)
	{
		this.errors = errors;
	}
}
