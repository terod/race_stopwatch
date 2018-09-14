package com.terod.racestopwatch.fragments;

import com.terod.racestopwatch.R;
import com.terod.racestopwatch.widgets.StopWListLapAdapter;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class LapResultFragment extends Fragment  {
		

	ListView lapListView;
	StopWListLapAdapter lapAdapter;
	ClockFragment clockFragment;
	TextView footerText ;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.lap_results, container,false);
		
		footerText = new TextView(getActivity().getApplicationContext());
		footerText.setHeight(80);
		
		//View view2 = inflater.inflate(R.layout.footer_view, container, false);
		//footerText = (TextView) view2.findViewById(R.id.footerView);
		footerText.setText("Lap Results here. Click Menu > Send... to send as mail");
		
		lapListView = (ListView) view.findViewById(R.id.lap_list_view);
		lapListView.setFooterDividersEnabled(true);
		lapListView.addFooterView(footerText);
		
		lapAdapter = new StopWListLapAdapter(getActivity(), clockFragment.clock.getLaps());
		lapListView.setAdapter(lapAdapter);
		// scroll to bottom if lap added
		lapListView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
		lapListView.setStackFromBottom(true);
		
		
		
		return view;
	}
	
	public void sendClockRef(ClockFragment clockFramgent)
	{
		this.clockFragment = clockFramgent;
		
	}
	
	

}
