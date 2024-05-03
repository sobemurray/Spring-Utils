/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2004 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Sobetech Holdings LLC, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 * 
 */
package com.sobetech.common.model.date;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * An extension of the java.util.GregorianCalendar object that contains some additional methods.
 *
 * @author John Murray
 *
 * @since 0.2.0
 */
public class Calendar extends GregorianCalendar
{
    private static final long serialVersionUID = -5867680842852032500L;
    public static boolean DOWN = false;
    public static boolean UP = true;
    
    /**
     * 
     */
    public Calendar()
    {
        super();
    }

    /**
     * @param year The year to set this object to.
     * @param month The month to set this object to.
     * @param date The day to set this object to. 
     */
    public Calendar(int year, int month, int date)
    {
        super(year, month, date);
    }

    /**
     * @param year The year to set this object to.
     * @param month The month to set this object to.
     * @param date The day to set this object to.
     * @param hour The hour to set this object to.
     * @param minute The minute to set this object to.
     */
    public Calendar(int year, int month, int date, int hour, int minute)
    {
        super(year, month, date, hour, minute);
    }

    /**
     * @param year The year to set this object to.
     * @param month The month to set this object to.
     * @param date The day to set this object to.
     * @param hour The hour to set this object to.
     * @param minute The minute to set this object to.
     * @param second The second to set this object to.
     */
    public Calendar(int year, int month, int date, int hour, int minute, int second)
    {
        super(year, month, date, hour, minute, second);
    }

    /**
     * @param locale The locale to set this Calendar to.
     */
    public Calendar(Locale locale)
    {
        super(locale);
    }

    /**
     * @param zone The time zone to set this Calendar to.
     */
    public Calendar(TimeZone zone)
    {
        super(zone);
    }

    /**
     * @param zone
     * @param locale
     */
    public Calendar(TimeZone zone, Locale locale)
    {
        super(zone, locale);
    }

    /**
     * This returns the number of days remaining in the current year of this Calendar object.
     * 
     * @return The number of days remaining in the current year of this object.
     */
    public int getRemainingDaysOfYear()
    {
        int totalDaysInYear = 365;
        if(isLeapYear(this.get(YEAR))) totalDaysInYear++;
        return totalDaysInYear - this.get(DAY_OF_YEAR);
    }
    
    /**
     * This returns the number of days remaining in the year specified based on a specific input day of the year.
     * 
     * @param year The year that you are looking for the remaining days.
     * @param dayOfYear The day of the year specified in the previous argument.
     * @return The number of days remaining in the year.
     */
    public int getRemainingDaysOfYear(int year, int dayOfYear)
    {
        int totalDaysInYear = 365;
        if(isLeapYear(year)) totalDaysInYear++;
        return totalDaysInYear - dayOfYear;
    }
    
    /**
     * Gets the number of days in the year remaining in this Calendar object.
     * 
     * @return The number of days in the year remaining in this Calendar object.
     */
    public int getRemainingMonthsOfYear()
    {
        return 11 - this.get(MONTH);
    }
    
    /**
     * Create a new instance of Calendar based off of the system's time.
     * 
     * @return The Calendar object based off of the system time.
     */
    public static Calendar getInstance()
    {
        return getInstance(new Date());
    }
    
    /**
     * Create a new instance of Calendar based off of an input date.
     * 
     * @param date The date object to create a Calendar object from.
     * @return The Calendar object based off of the input parameter. If the input parameter is null, the system time will be used.
     */
    public static Calendar getInstance(Date date)
    {
        if(date == null) date = new Date();
        Calendar returnCalendar = new Calendar();
        returnCalendar.setTime(date);
        return returnCalendar;
    }
    
    /**
     * Tests if this year is a leap year.
     * 
     * @return True if the year of this object is a leap year
     */
    public boolean isLeapYear()
    {
        return isLeapYear(this.get(YEAR));
    }
}
