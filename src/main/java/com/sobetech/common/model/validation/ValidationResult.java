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
	private boolean valid = true;
	private ArrayList<String> issues;
	private ArrayList<ValidationMessage> messages;

	/**
	 * Add a new issue to this result. This will also set the valid boolean to false
	 * 
	 * @param newIssue The new issue String to add
	 * @return <code>true</code> if the addition has been successful. Otherwise <code>false</code>
	 */
	public boolean addIssue(String newIssue)
	{
		if(newIssue == null || newIssue.isBlank())
		{
			return false;
		}

		if(this.issues == null)
		{
			this.issues = new ArrayList<>();
		}

		this.valid = false;
		return this.issues.add(newIssue);
	}

	/**
	 * Add a new ValidationMessage to this result. This will also set the valid boolean to false
	 * 
	 * @param newMessage The new ValidationMessage to add
	 * @return <code>true</code> if the addition has been successful. Otherwise <code>false</code>
	 */
	public boolean addValidationMessage(ValidationMessage newMessage)
	{
		if(newMessage == null)
		{
			return false;
		}

		if(this.messages == null)
		{
			this.messages = new ArrayList<>();
		}

		this.valid = false;
		return this.messages.add(newMessage);
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
	 * Getter for attribute issues
	 *
	 * @return the issues
	 */
	public ArrayList<String> getIssues()
	{
		return this.issues;
	}

	/**
	 * Setter for attribute issues
	 *
	 * @param issues
	 *            the issues to set
	 */
	public void setIssues(ArrayList<String> issues)
	{
		this.issues = issues;
	}

	/**
	 * Getter for attribute messages
	 *
	 * @return the messages
	 */
	public ArrayList<ValidationMessage> getMessages()
	{
		return this.messages;
	}

	/**
	 * Setter for attribute messages
	 *
	 * @param messages
	 *            the messages to set
	 */
	public void setMessages(ArrayList<ValidationMessage> messages)
	{
		this.messages = messages;
	}
}
