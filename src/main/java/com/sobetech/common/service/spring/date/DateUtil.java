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
package com.sobetech.common.service.spring.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.sobetech.common.model.date.Calendar;

/**
 * A collection of static convenience methods to work with java.util.Date objects
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
@Service
public class DateUtil
{
	private static final Logger logger = Logger.getLogger(DateUtil.class.getName());
	
	/**
	 * The default date format used MM/dd/yyyy
	 */
    protected static String genericDateFormatString = "MM/dd/yyyy";

    /**
     *  Default Constructor
     */
    public DateUtil()
    {
        super();
    }

    /**
     * Computes the number of days difference between two dates.
     * 
     * @param startDate The smaller of the dates to compute the difference.
     * @param endDate The larger of the dates to compute the difference.
     * @return The number of days difference between the two dates.
     * @throws IllegalArgumentException if either of the dates are null or if the end date is before the start date
     */
    public int daysDifference(Date startDate, Date endDate)
    {
        if(startDate == null || endDate == null) throw new IllegalArgumentException("The start date AND end date cannot be null");
        if(startDate.after(endDate)) throw new IllegalArgumentException("The end date is before the start date");
        
        Calendar startCalendar = Calendar.getInstance(startDate);
        Calendar endCalendar = Calendar.getInstance(endDate);
        
        int daysDifferent = 0;
        
        // Now check to see if the start time of the day is after the end time of day
        // If so, roll back a day
        if(isLaterInDay(startDate, endDate)) daysDifferent--;
        
        if(endCalendar.get(java.util.Calendar.YEAR) == startCalendar.get(java.util.Calendar.YEAR))
        {
            daysDifferent += endCalendar.get(java.util.Calendar.DAY_OF_YEAR) - startCalendar.get(java.util.Calendar.DAY_OF_YEAR);
            return daysDifferent;
        }
        
        daysDifferent += endCalendar.get(java.util.Calendar.DAY_OF_YEAR);
        
        while(endCalendar.get(java.util.Calendar.YEAR) != startCalendar.get(java.util.Calendar.YEAR))
        {
            endCalendar.roll(java.util.Calendar.YEAR, Calendar.DOWN);
            if(endCalendar.get(java.util.Calendar.YEAR) == startCalendar.get(java.util.Calendar.YEAR))
            {
                daysDifferent += startCalendar.getRemainingDaysOfYear();
            }
            else
            {
                daysDifferent += 365;
                if(endCalendar.isLeapYear()) daysDifferent++;
            }
        }

        return daysDifferent;
    }
    
    /**
     * Computes the number of days difference between two dates.
     * 
     * @param startDate The smaller of the dates to compute the difference.
     * @param endDate The larger of the dates to compute the difference.
     * @param ignoreTimeOfDay An flag to tell this method to only use the month, year and date and ignore the time of day.
     * @return The number of days difference between the two dates.
     * @throws IllegalArgumentException if either of the dates are null or if the end date is before the start date
     */
    public int daysDifference(Date startDate, Date endDate, boolean ignoreTimeOfDay)
    {
        Calendar startCalendar = Calendar.getInstance(startDate);
        Calendar endCalendar = Calendar.getInstance(endDate);
        
        if(ignoreTimeOfDay)
        {
            startCalendar.set(java.util.Calendar.HOUR, 0);
            startCalendar.set(java.util.Calendar.MINUTE, 0);
            startCalendar.set(java.util.Calendar.SECOND, 0);
            startCalendar.set(java.util.Calendar.MILLISECOND, 0);
            
            endCalendar.set(java.util.Calendar.HOUR, 0);
            endCalendar.set(java.util.Calendar.MINUTE, 0);
            endCalendar.set(java.util.Calendar.SECOND, 0);
            endCalendar.set(java.util.Calendar.MILLISECOND, 0);
        }
        return daysDifference(startCalendar.getTime(), endCalendar.getTime());
    }
    
    /**
     * Computes the number of months difference between two dates.
     * 
     * @param startDate The smaller of the dates to compute the difference.
     * @param endDate The larger of the dates to compute the difference.
     * @return The number of months difference between the two dates.
     * @throws IllegalArgumentException if either of the dates are null or if the end date is before the start date
     */
    public int monthsDifference(Date startDate, Date endDate)
    {
        if(startDate == null || endDate == null) throw new IllegalArgumentException("The start date AND end date cannot be null");
        if(startDate.after(endDate)) throw new IllegalArgumentException("The end date is before the start date");
        
        Calendar startCalendar = Calendar.getInstance(startDate);
        Calendar endCalendar = Calendar.getInstance(endDate);
        
        if(endCalendar.get(java.util.Calendar.YEAR) == startCalendar.get(java.util.Calendar.YEAR)) return endCalendar.get(java.util.Calendar.MONTH) - startCalendar.get(java.util.Calendar.MONTH);
        
        int monthsDifferent = endCalendar.get(java.util.Calendar.MONTH) + 1;
        
        while(endCalendar.get(java.util.Calendar.YEAR) != startCalendar.get(java.util.Calendar.YEAR))
        {
            endCalendar.roll(java.util.Calendar.YEAR, Calendar.DOWN);
            if(endCalendar.get(java.util.Calendar.YEAR) == startCalendar.get(java.util.Calendar.YEAR))
            {
                monthsDifferent += startCalendar.getRemainingMonthsOfYear();
            }
            else
            {
                monthsDifferent += 12;
            }
        }
        return monthsDifferent;
    }
    
    /**
     * Takes a input date, adds a minute and returns the Date object back.
     * 
     * @param inDate The date that a minute is to be added to.
     * @return The date object with a minute added to it. If the input date is null, then null will 
     * be returned
     */
    public Date addMinute(Date inDate)
    {
        long lTime = inDate.getTime();
        lTime += 60000;
        inDate.setTime(lTime);
        return inDate;
    }

    /**
     * Takes a input date, adds a specified number of minutes and returns the Date object back.
     * 
     * @param inDate The date that the minutes are to be added to.
     * @param minutes The number of minutes to add to the inDate.
     * @return The date object with the number of minutes added to it. If the input date is null, 
     * then null will be returned
     */
    public Date addMinutes(Date inDate, int minutes)
    {
        for(int i = 0; i < minutes; i++)
        {
            inDate = addMinute(inDate);
        }
        return inDate;
    }

    /**
     * Takes a input date, adds a hour and returns the Date object back.
     * 
     * @param inDate The date that a hour is to be added to.
     * @return The date object with a hour added to it.  If the input date is null, then null will 
     * be returned
     */
    public Date addHour(Date inDate)
    {
        long lTime = inDate.getTime();
        lTime += 3600000;
        inDate.setTime(lTime);
        return inDate;
    }

    /**
     * Takes a input date, adds a specified number of hours and returns the Date object back.
     * 
     * @param inDate The date that the hours are to be added to.
     * @param hours The number of hours to add to the inDate.
     * @return The date object with the number of hours added to it. If the input date is null, then 
     * null will be returned
     */
    public Date addHours(Date inDate, int hours)
    {
        for(int i = 0; i < hours; i++)
        {
            inDate = addHour(inDate);
        }
        return inDate;
    }

    /**
     * Takes a input date, adds a day and returns the Date object back.
     * 
     * @param inDate The date that a day is to be added to.
     * @return The date object with a day added to it. If the input date is null, then null will be
     * returned
     */
    public Date addDay(Date inDate)
    {
        long lTime = inDate.getTime();
        lTime += 86400000;
        inDate.setTime(lTime);
        return inDate;
    }

    /**
     * Takes a input date, adds a specified number of days and returns the Date object back.
     * 
     * @param inDate The date that the days are to be added to.
     * @param days The number of days to add to the inDate.
     * @return The date object with the number of days added to it. If the input date is null, then 
     * null will be returned
     */
    public Date addDays(Date inDate, int days)
    {
        for(int i = 0; i < days; i++)
        {
            inDate = addDay(inDate);
        }
        return inDate;
    }

    /**
     * A convenience method to create a DateFormat object
     * 
     * @return A SimpleDateFormat object using "MM/dd/yyyy"
     */
    public DateFormat getDateFormat()
    {
        return getDateFormat(genericDateFormatString);
    }

    /**
     * A convenience method to create a DateFormat object with specified format string.
     * 
     * @param formatString The string to be used for creating the SimpleDateFormat.
     * @return A SimpleDateFormat object using formatString.
     */
    public DateFormat getDateFormat(String formatString)
    {
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        return format;
    }

    /**
     * Converts a Date object to a string in MM/dd/yyyy format.
     * 
     * @param date The date that is to be formatted.
     * @return The date string put into a MM/dd/yyyy format.
     */
    public String toMMddyyyyString(Date date)
    {
        if(date == null) return "";
        return getDateFormat().format(date);
    }
    
    /**
	 * Creates a Date object that is the exact middle between two input dates. This computation is down to the millisecond level
     * 
	 * @param startDate date
	 * @param endDate date
	 * @return A Date object in the middle of start and end
     * @throws IllegalArgumentException if either of the dates are null or if the end date is before the start date
	 */
	public Date getMiddleDate(Date startDate, Date endDate)
	{
        if(startDate == null || endDate == null) throw new IllegalArgumentException("The start date AND end date cannot be null");
		if (!startDate.before(endDate)) throw new IllegalArgumentException("Start Date cannont be after the End Date");

		/**
		 * timeDifference holds the difference in miliseconds between the start date and
		 * the end date.
		 */
		long timeDifference = ((endDate.getTime() - startDate.getTime())/2) + startDate.getTime();
		return new Date(timeDifference);
	}
    
    /**
     * Checks to see if the time of day of the first date is later in the day than the time of day 
     * of the second date.
     * 
     * @param firstDate The first date to check
     * @param secondDate The second date to check
     * @return <code>true</code> if the time of the day of the first date is later in the day than the 
     * time of day of the second date. It doesn't matter what the rest of the date object looks 
     * like. It only deals with the time. If the times are equal, then it will return false. 
     */
    public boolean isLaterInDay(Date firstDate, Date secondDate)
    {
        return isLaterInDay(Calendar.getInstance(firstDate), Calendar.getInstance(secondDate));
    }
    
    /**
     * Checks to see if the time of day of the first date is later in the day than the time of day of the second date.
     * 
     * @param startCalendar The first date to check
     * @param endCalendar The second date to check
     * @return <code>true</code> if the time of the day of the first date is later in the day than the time of day of the second
     * date. It doesn't matter what the rest of the date object looks like. It only deals with the time. If the times are
     * equal, then it will return false. 
     */
    public boolean isLaterInDay(Calendar startCalendar, Calendar endCalendar)
    {
        // Since Calendar is mutable these values must be reset later in the method
        int startDayOfYear = startCalendar.get(java.util.Calendar.DAY_OF_YEAR);
        int startYear = startCalendar.get(java.util.Calendar.YEAR);
        
        int endDayOfYear = endCalendar.get(java.util.Calendar.DAY_OF_YEAR);
        int endYear = endCalendar.get(java.util.Calendar.YEAR);
        
        startCalendar.set(java.util.Calendar.DAY_OF_YEAR, 0);
        startCalendar.set(java.util.Calendar.YEAR, 0);

        endCalendar.set(java.util.Calendar.DAY_OF_YEAR, 0);
        endCalendar.set(java.util.Calendar.YEAR, 0);

        boolean returnBoolean = startCalendar.getTime().after(endCalendar.getTime());
        
        // This is where the mutable Calendar is reset
        startCalendar.set(java.util.Calendar.DAY_OF_YEAR, startDayOfYear);
        startCalendar.set(java.util.Calendar.YEAR, startYear);

        endCalendar.set(java.util.Calendar.DAY_OF_YEAR, endDayOfYear);
        endCalendar.set(java.util.Calendar.YEAR, endYear);
        
        return returnBoolean;
    }
    
    /**
     * Takes a Date and sets it to the beginning of the month and year of the desired date
     * 
     * @param date The date to convert
     * @return A Date object that is the beginning of the month and year specified
     */
    public Date toBeginningOfTheMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance(date);
        return getBeginningOfTheMonth(calendar.get(java.util.Calendar.MONTH), calendar.get(java.util.Calendar.YEAR));
    }
    
    /**
     * Takes a Date and sets it to the end of the month and year of the desired date
     * 
     * @param date The date to convert
     * @return A Date object that is the end of the month and year specified
     */
    public Date toEndOfTheMonth(Date date)
    {
        Calendar calendar = Calendar.getInstance(date);
        return getEndOfTheMonth(calendar.get(java.util.Calendar.MONTH), calendar.get(java.util.Calendar.YEAR));
    }
    
    /**
     * Takes a month and year and returns the exact beginning of the month
     * 
     * @param javaMonth The month to set the date to in a Java format. January == 0 and so on
     * @param year The year to set the date to
     * @return A Date object that is the beginning of the month and year specified
     */
    public Date getBeginningOfTheMonth(int javaMonth, int year)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(java.util.Calendar.YEAR, year);
        calendar.set(java.util.Calendar.MONTH, javaMonth);
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 1);
        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calendar.set(java.util.Calendar.MINUTE, 0);
        calendar.set(java.util.Calendar.SECOND, 0);
        calendar.set(java.util.Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
    
    /**
     * Takes a date and sets the time to be 23:59:59.999
     * 
     * @param date The date to set the time to be the end of the day
     * @return The date object entered set to a time of 23:59:59.999
     */
    public Date toEndOfDay(Date date)
    {
        Calendar calendar = Calendar.getInstance(date);
        calendar.set(java.util.Calendar.HOUR_OF_DAY, 23);
        calendar.set(java.util.Calendar.MINUTE, 59);
        calendar.set(java.util.Calendar.SECOND, 59);
        calendar.set(java.util.Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }
    
    /**
     * Takes a month and year and returns the exact end of the month
     * 
     * @param javaMonth The month to set the date to in a Java format. January == 0 and so on
     * @param year The year to set the date to
     * @return A Date object that is the end of the month and year specified
     */
    public Date getEndOfTheMonth(int javaMonth, int year)
    {
        Calendar calendar = Calendar.getInstance(getBeginningOfTheMonth(javaMonth + 1, year));
        calendar.add(java.util.Calendar.MILLISECOND, -1);
        return calendar.getTime();
    }
    
    /**
     * Tries to convert a string in the format of MM/dd/yyyy into a Date object
     * 
     * @param dateString The string to convert into a Date object
     * @return The resultant Date object or <code>null</code> if this string cannot be converted into a 
     * Date object
     */
    public Date toDate(String dateString)
    {
        return toDate(dateString, genericDateFormatString);
    }
    
    /**
     * Tries to convert a string in into a Date object based on a DateFormat specified by the input
     * format string. If the specified DateFormat string is invalid then a default of MM/dd/yyyy will
     * be used
     * 
     * @param dateString The string to convert into a Date object
     * @param dateFormatString A string representing a DateFormat
     * @return The resultant Date object or <code>null</code> if this string cannot be converted into a 
     * Date object
     */  
    public Date toDate(String dateString, String dateFormatString)
    {
        if(dateString == null) return null;
        DateFormat dateFormat = getDateFormat();
        try
        {
            dateFormat = getDateFormat(dateFormatString);
        }
        catch(Exception ignore)
        {
            //The exception is generic because we can either generate an NPE or an IllegalArgumentException
        }
        try
        {
            return dateFormat.parse(dateString);
        }
        catch (ParseException e)
        {
            logger.severe("Couldn't parse " + dateString + " into a Date object");
        }
        return null;
    }
    
    /**
     * Converts a date object into a string using a default format of MM/dd/yyyy. If the date
     * is null, then it will return an empty string. 
     *   
     * @param date The date to convert into a string
     * @return The date converted into a formatted string
     */
    public String toDateString(Date date)
    {
        return toDateString(date, genericDateFormatString);
    }
    
    /**
     * Converts a date object into a string using the specified date formatting string. If the date
     * is null, then it will return an empty string. If the date formatting string doesn't represent
     * a valid DateFormat, then a default format of MM/dd/yyyy will be used.
     * 
     * @param date The date to convert into a string
     * @param dateFormatString The string representation of a DateFormat
     * @return The date converted into a formatted string
     */
    public String toDateString(Date date, String dateFormatString)
    {
        if(date == null) return "";
        DateFormat dateFormat = getDateFormat();
        try
        {
            dateFormat = getDateFormat(dateFormatString);
        }
        catch(Exception ignore)
        {
            //The exception is generic because we can either generate an NPE or an IllegalArgumentException
        }
        return dateFormat.format(date);
    }
    
    /**
     * Format a Duration into a more readable String than what the class returns
     * 
     * @param duration The Duration to print out
     * @return The duration as hh:mm:ss.sss if there are hours presents, mm:ss.sss if not. If the duration is 
     * <code>null</code> then an empty String is returned
     */
    public String formatDuration(Duration duration)
    {
    	if(duration == null)
    	{
    		return "";
    	}
    	
    	if(duration.toHoursPart() > 0)
    	{
	    	return String.format("%d:%02d:%02d.%03d", duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart(), 
	    			duration.toMillisPart());
    	}
    	
    	return String.format("%02d:%02d.%03d", duration.toMinutesPart(), duration.toSecondsPart(), duration.toMillisPart());
    }
    
    /**
     * Get the current year using LocalDate
     * 
     * @return The current year
     */
    public int getCurrentYear()
    {
    	LocalDate currentDate = LocalDate.now();
        return currentDate.getYear();
    }
    
    /**
     * Check to see if a year is the current year
     * 
     * @param yearToCheck The year to check
     * @return <code>true</code> if the year to check is the current year
     */
    public boolean isCurrentYear(int yearToCheck)
    {
    	return yearToCheck == getCurrentYear();
    }
    
    /**
	 * Is this year in the future using LocalDate
	 * 
	 * @param yearToTest The year to test
	 * @return <code>true</code> if this year is in the future
	 */
    public boolean isFutureYear(int yearToTest)
	{
        return yearToTest > getCurrentYear();
	}
}