package com.ryankoeller.project2;

import java.util.Date;

@SuppressWarnings("deprecation")
public class TimeDate
{
	private static Date myDate;

	public TimeDate()
	{
		myDate = new Date();
	}

	/**
	 * Changes the date
	 * @param time
	 */
	public void setTimeDate(long time)
	{
		myDate.setTime(time);
	}

	/**
	 * Changes the date
	 * @param year
	 * @param month
	 * @param date
	 * @param hours
	 * @param minutes
	 * @param seconds
	 */
	public void setTimeDate(int year, int month, int date, int hours, int minutes, int seconds)
	{
		myDate.setYear(year);
		myDate.setMonth(month);
		myDate.setDate(date);
		myDate.setHours(hours);
		myDate.setMinutes(minutes);
		myDate.setSeconds(seconds);
	}

	/**
	 * Ticks the seconds by one
	 */
	public void updateSeconds()
	{
		myDate.setSeconds(myDate.getSeconds() + 1);
	}

	/**
	 * @return The date
	 */
	public Date getTimeDate()
	{
		return myDate;
	}

}
