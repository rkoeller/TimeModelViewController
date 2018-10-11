package com.ryankoeller.project2;

import java.util.Date;

public class ChangeDateAction extends Action
{
	TimeDateController tdc;
	private Date startDate;
	private Date changedToDate;

	public ChangeDateAction(Date startDate, Date changedToDate)
	{
		super();
		tdc = TimeDateController.getInstance();
		this.startDate = new Date();
		this.changedToDate = new Date();
		this.startDate.setTime(startDate.getTime());
		this.changedToDate.setTime(changedToDate.getTime());
	}

	/**
	 * Changes the model's date by using the controller
	 */
	@Override
	public void doIt()
	{
		tdc.actionSetTimeDate(changedToDate);
	}

	/**
	 * Changes the model's date back by using the controller
	 */
	@Override
	public void undoIt()
	{
		tdc.actionSetTimeDate(startDate);
	}
	
}
