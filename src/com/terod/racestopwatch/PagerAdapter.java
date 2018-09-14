package com.terod.racestopwatch;

import java.io.Serializable;

import com.terod.racestopwatch.fragments.LapResultFragment;
import com.terod.racestopwatch.fragments.StopwatchFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
	
	private StopwatchFragment watchFragment = new StopwatchFragment();
	private LapResultFragment resultFragment = new LapResultFragment();
	
	private final Fragment[] fragments = {watchFragment,resultFragment};
	
    public PagerAdapter(FragmentManager fm) {
        super(fm);
        //sending watchfrag Ref to resultfrag
        resultFragment.sendClockRef(watchFragment);
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }
    
    public Clock getClock()
    {
    	return watchFragment.getClock(); 
    }
}
