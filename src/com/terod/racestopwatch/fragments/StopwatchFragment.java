/***************************************************************************
 *   Copyright (C) 2009-2012 b
{y mj <fakeacc.mj@gmail.com>, 				   *
 *   							Jeremy Monin <jeremy@nand.net>             *
 *                                                          			   *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU General Public License     *
 *   along with this program; if not, write to the                         *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 ***************************************************************************/

package com.terod.racestopwatch.fragments;

import com.terod.racestopwatch.Clock;
import com.terod.racestopwatch.R;
import com.terod.racestopwatch.widgets.StopWListLapAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Fragment for the stopwatch mode. Uses the stopwatch layout.
 * 
 * @see R#layout#stopwatch
 * @see Clock#MODE_STOPWATCH
 */
public class StopwatchFragment extends ClockFragment {

	Button lapButton1, lapButton2, lapButton3, lapButton4, lapButton5,
			lapButton6, lapButton7, lapButton8, lapButton9, lapButton10,
			lapButton11, lapButton12, lapButton13, lapButton14, lapButton15;

	EditText player1, player2, player3, player4, player5, player6, player7,
			player8, player9, player10, player11, player12, player13, player14,
			player15;

	public StopwatchFragment() {
		super(R.layout.stop_watch_mainlist, Clock.MODE_STOPWATCH);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = super.onCreateView(inflater, container, savedInstanceState);

		{
			lapButton1 = (Button) view.findViewById(R.id.lap_button1);
			lapButton2 = (Button) view.findViewById(R.id.lap_button2);
			lapButton3 = (Button) view.findViewById(R.id.lap_button3);
			lapButton4 = (Button) view.findViewById(R.id.lap_button4);
			lapButton5 = (Button) view.findViewById(R.id.lap_button5);
			lapButton6 = (Button) view.findViewById(R.id.lap_button6);
			lapButton7 = (Button) view.findViewById(R.id.lap_button7);
			lapButton8 = (Button) view.findViewById(R.id.lap_button8);
			lapButton9 = (Button) view.findViewById(R.id.lap_button9);
			lapButton10 = (Button) view.findViewById(R.id.lap_button10);
			lapButton11 = (Button) view.findViewById(R.id.lap_button11);
			lapButton12 = (Button) view.findViewById(R.id.lap_button12);
			lapButton13 = (Button) view.findViewById(R.id.lap_button13);
			lapButton14 = (Button) view.findViewById(R.id.lap_button14);
			lapButton15 = (Button) view.findViewById(R.id.lap_button15);
		}
		
		{
			player1 = (EditText) view.findViewById(R.id.player_name1);
			player2 = (EditText) view.findViewById(R.id.player_name2);
			player3 = (EditText) view.findViewById(R.id.player_name3);
			player4 = (EditText) view.findViewById(R.id.player_name4);
			player5 = (EditText) view.findViewById(R.id.player_name5);
			player6 = (EditText) view.findViewById(R.id.player_name6);
			player7 = (EditText) view.findViewById(R.id.player_name7);
			player8 = (EditText) view.findViewById(R.id.player_name8);
			player9 = (EditText) view.findViewById(R.id.player_name9);
			player10 = (EditText) view.findViewById(R.id.player_name10);
			player11 = (EditText) view.findViewById(R.id.player_name11);
			player12 = (EditText) view.findViewById(R.id.player_name12);
			player13 = (EditText) view.findViewById(R.id.player_name13);
			player14 = (EditText) view.findViewById(R.id.player_name14);
			player15 = (EditText) view.findViewById(R.id.player_name15);
		}

		
		{
			lapButton1.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player1.getText().toString());
				}

			});

			lapButton2.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player2.getText().toString());
				}

			});
			

			lapButton3.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player3.getText().toString());
				}

			});

			lapButton4.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player4.getText().toString());
				}

			});
			
			lapButton5.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player5.getText().toString());
				}

			});

			lapButton6.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player6.getText().toString());
				}

			});
			
			lapButton7.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player7.getText().toString());
				}

			});

			lapButton8.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player8.getText().toString());
				}

			});
			
			lapButton9.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player9.getText().toString());
				}

			});

			lapButton10.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player10.getText().toString());
				}

			});
			
			lapButton11.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player11.getText().toString());
				}

			});

			lapButton12.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player12.getText().toString());
				}

			});
			

			lapButton13.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player13.getText().toString());
				}

			});

			lapButton14.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player14.getText().toString());
				}

			});
			
			lapButton15.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					clock.newLap(player15.getText().toString());
				}

			});
			
		}
		

		return view;
	}

	@Override
	protected void reset() {
		clock.reset();
		setDeciSeconds(0);
		setSeconds(0);
		setMinutes(0);
		setHours(0);
	}
	
	public Clock getClock()
	{
		return clock;
	}
}
