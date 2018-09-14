
package com.terod.racestopwatch.fragments;

import java.text.NumberFormat;

import com.terod.racestopwatch.Clock;
import com.terod.racestopwatch.R;
import com.terod.racestopwatch.Util;
import com.terod.racestopwatch.R.id;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Abstract class which represents a Fragment played in the ViewPager from
 * {@link AnstopActivity}.
 * Handles basic things like starting and stopping the clock ({@link #clock},
 * and updating the labels ({@link #hoursView}, ...).
 */
public abstract class ClockFragment extends Fragment {
	
	private Handler updateHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch(msg.arg1) {
			case Clock.UPDATE_DECI_SECONDS:
				deciSecondsView.setText("" + msg.arg2);
				break;
			case Clock.UPDATE_SECONDS:
				secondsView.setText(nf.format(msg.arg2));
				break;
			case Clock.UPDATE_MINUTES:
				minutesView.setText(nf.format(msg.arg2));
				break;
			case Clock.UPDATE_HOURS:
				hoursView.setText("" + msg.arg2);
				break;
			}
		}
	};
	
	protected Clock clock;
	private int layoutId;
	
	private Button startButton;
	private Button resetButton;
	private TextView hoursView;
	private TextView minutesView;
	private TextView secondsView;
	private TextView deciSecondsView;
	
	private NumberFormat nf;
	
	/**
	 * Initializes a new ClockFragment.
	 * @param layoutId the layout which should be inflated
	 * @param mode The mode the clock should have
	 */
	ClockFragment(int layoutId, int mode) {
		clock = new Clock(mode, updateHandler);
		this.layoutId = layoutId;
		nf = Util.getTwoDigitFormat();
	}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		View view = inflater.inflate(layoutId, container, false);
		startButton = (Button) view.findViewById(R.id.start_all);
		resetButton = (Button) view.findViewById(R.id.reset_all);
		hoursView = (TextView) view.findViewById(R.id.hour_view);
		minutesView = (TextView) view.findViewById(R.id.min_view);
		secondsView = (TextView) view.findViewById(R.id.seconds_view);
		deciSecondsView = (TextView) view.findViewById(R.id.dseconds_view);
		
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				count();
			}
			
		});
		
		resetButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!clock.isActive())
					reset();
			}
		});
		
        return view;
    }

	@Override
	public void onResume() {
		super.onResume();
		restoreState();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		saveState();
	}
	
	/**
	 * Saves the current state to the Preferences.
	 * <br>
	 * If you override this method be sure to call this method!
	 * @see #restoreState()
	 */
	protected void saveState() {
		clock.saveState(getActivity());
	}
	
	/**
	 * Restores the previous state from the Preferences.
	 * <br>
	 * If you override this method be sure to call this method!
	 * @see #saveState()
	 */
	protected void restoreState() {
		clock.restoreState(getActivity());
		
		// make values visible to user
		int[] times = clock.getValues();
		
		setHours(times[0]);
		setMinutes(times[1]);
		setSeconds(times[2]);
		setDeciSeconds(times[3]);
	}

	/**
	 * Starts counting if clock is not active
	 * @see #clock
	 * @see Clock#isActive()
	 */
	protected void count() {
		if(!clock.isActive())
			clock.count();
		else
			clock.stop();
	}
	
	/**
	 * Sets the text of deci seconds TextView to the specified value.
	 * @param value
	 */
	protected void setDeciSeconds(int value) {
		deciSecondsView.setText("" + value);
	}
	
	/**
	 * Sets the text of seconds TextView to the specified value.
	 * @param value
	 */
	protected void setSeconds(int value) {
		secondsView.setText(nf.format(value));
	}
	
	/**
	 * Sets the text of minutes TextView to the specified value.
	 * @param value
	 */
	protected void setMinutes(int value) {
		minutesView.setText(nf.format(value));
	}
	
	/**
	 * Sets the text of hours TextView to the specified value.
	 * @param value
	 */
	protected void setHours(int value) {
		hoursView.setText("" + value);
	}
	
	/**
	 * Resets the current time. This can be to zero or maybe to the time
	 * which should be counted down!
	 */
	protected abstract void reset();
}
