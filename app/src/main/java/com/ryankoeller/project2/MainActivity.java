package com.ryankoeller.project2;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AnalogClock;
import android.widget.TextClock;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link FragmentPagerAdapter} derivative, which will keep every
	 * loaded fragment in memory. If this becomes too memory intensive, it
	 * may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	private SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	private ViewPager mViewPager;
	private TimeDateController theController;
	private Thread controllerTickAndUpdateThread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.container);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		//TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

		//mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
		//tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

		theController = TimeDateController.getInstance();
		controllerTickAndUpdateThread = new Thread(theController);
		controllerTickAndUpdateThread.start();

		TextClock textClock = (TextClock) findViewById(R.id.textClock);
		AnalogClock analogClock = (AnalogClock) findViewById(R.id.analogClock);

		// mSectionsPagerAdapter.addHomeFragment();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 *
	 * Code found from:
	 * https://medium.com/@mujtahidah/add-and-remove-fragment-tab-layout-dynamically-9fe57add53fb
	 *
	 * Adds the ability to add and remove tabs
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		private final List<Fragment> mFragmentList = new ArrayList<>();
		private final List<String> mFragmentTitleList = new ArrayList<>();

		public SectionsPagerAdapter(FragmentManager manager) {
			super(manager);
		}

		@Override
		public Fragment getItem(int position) {
			return mFragmentList.get(position);
		}

		@Override
		public int getCount() {
			return mFragmentList.size();
		}

		// Adds one AnalogClockFragment to the list
		public void addAnalogClockFragment() {
			mFragmentList.add(new AnalogClockFragment());
			mFragmentTitleList.add("Analog Clock");
		}

		// Adds one TextClockFragment to the list
		public void addTextClockFragment() {
			mFragmentList.add(new TextClockFragment());
			mFragmentTitleList.add("Text Clock");
		}

		public void addHomeFragment() {
			mFragmentList.add(new HomeFragment());
			mFragmentTitleList.add("Home");

		}

		// Removes the last fragment in the list
		public void removeFragment() {
			if(!mFragmentList.isEmpty()) {
				mFragmentList.remove(mFragmentList.size() - 1);
			}
			if(!mFragmentTitleList.isEmpty()) {
				mFragmentTitleList.remove(mFragmentTitleList.size() - 1);
			}
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return mFragmentTitleList.get(position);
		}
	}
}
