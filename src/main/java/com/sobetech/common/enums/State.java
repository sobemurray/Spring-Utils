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
package com.sobetech.common.enums;

/**
 * An enum for US States as well as other territories and possessions
 *
 * @author John.Murray
 *
 * @since Jul 25, 2022
 *
 */
//@JsonDeserialize(using = CustomStateDeserializer.class)
public enum State
{
	ALABAMA("Alabama", "AL"),
	ALASKA("Alaska", "AK"),
	ARIZONA("Arizona", "AZ"),
	ARKANSAS("Arkansas", "AR"),
	CALIFORNIA("California", "CA"),
	COLORADO("Colorado", "CO"),
	CONNECTICUT("Connecticut", "CT"),
	DELAWARE("Delaware", "DE"),
	DISTRICT_OF_COLUMBIA("District Of Columbia", "DC"),
	FLORIDA("Florida", "FL"),
	GEORGIA("Georgia", "GA"),
	HAWAII("Hawaii", "HI"),
	IDAHO("Idaho", "ID"),
	ILLINOIS("Illinois", "IL"),
	INDIANA("Indiana", "IN"),
	IOWA("Iowa", "IA"),
	KANSAS("Kansas", "KS"),
	KENTUCKY("Kentucky", "KY"),
	LOUISIANA("Louisiana", "LA"),
	MAINE("Maine", "ME"),
	MARYLAND("Maryland", "MD"),
	MASSACHUSETTS("Massachusetts", "MA"),
	MICHIGAN("Michigan", "MI"),
	MINNESOTA("Minnesota", "MN"),
	MISSISSIPPI("Mississippi", "MS"),
	MISSOURI("Missouri", "MO"),
	MONTANA("Montana", "MT"),
	NEBRASKA("Nebraska", "NE"),
	NEVADA("Nevada", "NV"),
	NEW_HAMPSHIRE("New Hampshire", "NH"),
	NEW_JERSEY("New Jersey", "NJ"),
	NEW_MEXICO("New Mexico", "NM"),
	NEW_YORK("New York", "NY"),
	NORTH_CAROLINA("North Carolina", "NC"),
	NORTH_DAKOTA("North Dakota", "ND"),
	OHIO("Ohio", "OH"),
	OKLAHOMA("Oklahoma", "OK"),
	OREGON("Oregon", "OR"),
	PENNSYLVANIA("Pennsylvania", "PA"),
	RHODE_ISLAND("Rhode Island", "RI"),
	SOUTH_CAROLINA("South Carolina", "SC"),
	SOUTH_DAKOTA("South Dakota", "SD"),
	TENNESSEE("Tennessee", "TN"),
	TEXAS("Texas", "TX"),
	UTAH("Utah", "UT"),
	VERMONT("Vermont", "VT"),
	VIRGINIA("Virginia", "VA"),
	WASHINGTON("Washington", "WA"),
	WEST_VIRGINIA("West Virginia", "WV"),
	WISCONSIN("Wisconsin", "WI"),
	WYOMING("Wyoming", "WY"),
	AMERICAN_SAMOA("American Samoa", "AS"),
	GUAM("Guam", "GU"),
	MARSHALL_ISLANDS("Marshall Islands", "MH"),
	MICRONESIA("Micronesia", "FM"),
	NORTHERN_MARIANAS("Northern Marianas", "MP"),
	PALAU("Palau", "PW"),
	PUERTO_RICO("Puerto Rico", "PR"),
	VIRGIN_ISLANDS("Virgin Islands", "VI"),
	ARMED_FORCES_AFRICA("Armed Forces Africa", ""),
	ARMED_FORCES_AMERICAS("Armed Forces Americas", "AA"),
	ARMED_FORCES_CANADA("Armed Forces Canada", "AFC"),
	ARMED_FORCES_EUROPE("Armed Forces Europe", "AE"),
	ARMED_FORCES_MIDDLE_EAST("Armed Forces Canada", "AFME"),
	ARMED_FORCES_PACIFIC("Armed Forces Pacific", "AP");

	private String abbreviation;
	private String stateName;

	State(String name, String abbreviation)
	{
		this.abbreviation = abbreviation;
		this.stateName = name;
	}

	public String getAbbreviation()
	{
		return this.abbreviation;
	}

	public String getStateName()
	{
		return this.stateName;
	}

	public static State fromString(String stateString)
	{
		if(stateString == null || stateString.isBlank())
		{
			return null;
		}

		try
		{
			return State.valueOf(stateString.toUpperCase().replace('_', ' '));
		}
		catch(IllegalArgumentException ignore)
		{
			for(State state : State.values())
			{
				if(state.getAbbreviation().equalsIgnoreCase(stateString)
						|| state.getStateName().equalsIgnoreCase(stateString)
						|| state.name().equalsIgnoreCase(stateString))
				{
					return state;
				}
			}
			return null;
		}
	}

	// TODO Create a method and attributes for each state to handle abbreviations
}
