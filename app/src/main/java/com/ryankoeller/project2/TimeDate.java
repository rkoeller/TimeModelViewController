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
	
	public void setTimeDate(long time)
	{
		myDate.setTime(time);
	}
	
	public void setTimeDate(int year, int month, int date, int hours, int minutes, int seconds)
	{
		myDate.setYear(year);
		myDate.setMonth(month);
		myDate.setDate(date);
		myDate.setHours(hours);
		myDate.setMinutes(minutes);
		myDate.setSeconds(seconds);
	}

	public void updateSeconds()
	{
		myDate.setSeconds(myDate.getSeconds() + 1);
	}

	public Date getTimeDate()
	{
		return myDate;
	}

}