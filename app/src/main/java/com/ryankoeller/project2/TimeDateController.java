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

	public void setTimeDate(int year, int month, int date, int hours, int minutes, int seconds) {
		ChangeDateAction newAction = new ChangeDateAction(timeDate.getTimeDate(),
				new Date(year, month, date, hours, minutes, seconds));
		newAction.doIt();
		doneActions.push(newAction);
		undoneActions.clear();
	}

	public void actionSetTimeDate(Date date) {
		synchronized (timeDate) {
			timeDate.setTimeDate(date.getTime());
		}
	}

	private void updateTime() {
		synchronized (timeDate) {
			timeDate.updateSeconds();
		}

	}

	public String getTimeDateToString() {
		synchronized (timeDate) {
			return timeDate.getTimeDate().toString();
		}
	}

	public void undo() {
		if (!doneActions.isEmpty()) {
			undoneActions.push(doneActions.pop());
			undoneActions.lastElement().undoIt();
		}
	}

	public void redo() {
		if (!undoneActions.isEmpty()) {
			doneActions.push(undoneActions.pop());
			doneActions.lastElement().doIt();
		}
	}

	public static TimeDateController getInstance() {
		return controller;
	}
}
