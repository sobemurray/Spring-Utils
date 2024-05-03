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

/**
 * An object that can be used to represent a the time of day
 * 
 * @author John Murray
 * 
 * @since 0.2.0
 */
public class TimeOfDay
{
    private int hour;

    private int minute;

    private boolean pm;

    public TimeOfDay()
    {
    }

    /**
     * @return Returns the hour.
     */
    public int getHour()
    {
        return this.hour;
    }

    /**
     * @param hour The hour to set.
     */
    public void setHour(int hour)
    {
        this.hour = hour;
    }

    /**
     * @return Returns the minute.
     */
    public int getMinute()
    {
        return this.minute;
    }

    /**
     * @param minute The minute to set.
     */
    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    /**
     * @return Returns the pm.
     */
    public boolean isPm()
    {
        return this.pm;
    }

    /**
     * @param pm The pm to set.
     */
    public void setPm(boolean pm)
    {
        this.pm = pm;
    }
}