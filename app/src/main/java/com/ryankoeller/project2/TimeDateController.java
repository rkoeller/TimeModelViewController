package com.ryankoeller.project2;

import java.util.Date;
import java.util.Stack;

@SuppressWarnings("deprecation")
public class TimeDateController implements Runnable {
	private static TimeDateController controller = new TimeDateController();
	private TimeDate timeDate;
	private Stack<Action> doneActions;
	private Stack<Action> undoneActions;

	private TimeDateController() {
		timeDate = new TimeDate();
		doneActions = new Stack<>();
		undoneActions = new Stack<>();
	}

	/**
	 * Thread that increases the model's time
	 */
	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (timeDate) {
				updateTime();
			}
		}
	}

	/**
	 *
	 * @param year
	 * @param month
	 * @param date
	 * @param hours
	 * @param minutes
	 * @param seconds
	 */
	public void setTimeDate(int year, int month, int date, int hours, int minutes, int seconds) {
		ChangeDateAction newAction = new ChangeDateAction(timeDate.getTimeDate(),
				new Date(year, month, date, hours, minutes, seconds));
		newAction.doIt();
		doneActions.push(newAction);
		undoneActions.clear();
	}

	/**
	 *
	 * @param date
	 */
	public void actionSetTimeDate(Date date) {
		synchronized (timeDate) {
			timeDate.setTimeDate(date.getTime());
		}
	}

	/**
	 * Increases the model's time by 1 second
	 */
	private void updateTime() {
		synchronized (timeDate) {
			timeDate.updateSeconds();
		}

	}

	/**
	 * @return The model's time
	 */
	public String getTimeDateToString() {
		synchronized (timeDate) {
			return timeDate.getTimeDate().toString();
		}
	}

	/**
	 * Undo's the last action
	 */
	public void undo() {
		if (!doneActions.isEmpty()) {
			undoneActions.push(doneActions.pop());
			undoneActions.lastElement().undoIt();
		}
	}

	/**
	 * Redo's the last undo
	 */
	public void redo() {
		if (!undoneActions.isEmpty()) {
			doneActions.push(undoneActions.pop());
			doneActions.lastElement().doIt();
		}
	}

	/**
	 * @return gets the TimeDateController singleton
	 */
	public static TimeDateController getInstance() {
		return controller;
	}
}
