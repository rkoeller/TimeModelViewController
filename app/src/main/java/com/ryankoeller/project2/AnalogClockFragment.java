package com.ryankoeller.project2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;

public class AnalogClockFragment extends Fragment {

	AnalogClock analogClock;

	public AnalogClockFragment() {
	}

	/**
	 * Returns a new instance of this fragment
	 */
	public static AnalogClockFragment newInstance() {
		AnalogClockFragment fragment = new AnalogClockFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.text_clock_layout, container, false);

		analogClock = (AnalogClock) rootView.findViewById(R.id.analogClock);

		// Get the TimeDateController singleton
		TimeDateController theController = TimeDateController.getInstance();

		return rootView;
	}
}
