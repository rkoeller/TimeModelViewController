package com.ryankoeller.project2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

	Button btnAddDigitalClock;
	Button btnAddAnalogClock;
	Button btnUndoTimeChange;
	Button btnRedoTimeChange;
	Button btnRemoveLastClock;
	Button btnChangeTime;

	public HomeFragment() {
	}

	/**
	 * Returns a new instance of this fragment
	 */
	public static HomeFragment newInstance() {
		HomeFragment fragment = new HomeFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.text_clock_layout, container, false);

		btnAddDigitalClock = (Button) rootView.findViewById(R.id.btnAddDigitalClock);
		btnAddAnalogClock = (Button) rootView.findViewById(R.id.btnAddAnalogClock);
		btnRemoveLastClock = (Button) rootView.findViewById(R.id.btnRemoveLastClock);
		btnChangeTime = (Button) rootView.findViewById(R.id.btnTimeChange);
		btnUndoTimeChange = (Button) rootView.findViewById(R.id.btnUndoTimeChange);
		btnRedoTimeChange = (Button) rootView.findViewById(R.id.btnRedoTimeChange);

		// Get the TimeDateController singleton
		// TimeDateController theController = TimeDateController.getInstance();

		return rootView;
	}

	public void addDigitalClock()
	{

	}

	public void removeLastClock()
	{

	}

	public void addAnalogClock()
	{

	}

	public void changeTime()
	{

	}

	public void undoTimeChange()
	{

	}

	public void redoTimeChange()
	{

	}

}
