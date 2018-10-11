package com.ryankoeller.project2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;

public class TextClockFragment extends Fragment {

	TextClock textClock;

	public TextClockFragment() {
	}

	/**
	 * Returns a new instance of this fragment
	 */
	public static TextClockFragment newInstance() {
		TextClockFragment fragment = new TextClockFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.text_clock_layout, container, false);

		textClock = (TextClock) rootView.findViewById(R.id.textClock);

		// Get the TimeDateController singleton
		TimeDateController theController = TimeDateController.getInstance();

		return rootView;
	}
}
