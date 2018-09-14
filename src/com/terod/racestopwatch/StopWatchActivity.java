package com.terod.racestopwatch;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.terod.racestopwatch.Clock.Lap;
import com.terod.racestopwatch.fragments.LapResultFragment;
import com.terod.racestopwatch.fragments.StopwatchFragment;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;




import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.EditText;
import android.widget.Toast;

/**
 * RaceStopwatch's main activity, showing the current getClock(), lap times, etc.
 *<P>
 * Shows two Fragments ({@link StopwatchFragment} and @link {@link CountdownFragment})
 * in a ViewPager ({@link StopWatchActivity#viewPager})
 * <p>
 * Creates also the menu and deals with selected items and loads the users settings
 * (@link {@link StopWatchActivity#readSettings()}).
 */
public class StopWatchActivity extends FragmentActivity {
	
	private static final int ABOUT_DIALOG = 0;
	private static final int SAVE_DIALOG = 1;
	
	private static final int SETTINGS_REQUEST_CODE = 0; 
	
	ViewPager viewPager;
	PagerAdapter pageAdapter;

	/**
	 * Called when the activity is first created.
	 * Assumes {@link #STOP_LAP} mode and sets that layout.
	 * Preferences are read, which calls setCurrentMode.
	 * Also called later, to set the mode/layout back to {@link #STOP_LAP}.
	 */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        pageAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
        	
    }

    /**
     * Read our settings, at startup or after calling the SettingsActivity.
     *<P>
     * Does not check <tt>"anstop_in_use"</tt> or read the instance state
     * when the application is finishing; for that, see {@link getClock()#restoreFromSaveState(SharedPreferences)}.
     *
     * @param isStartup Are we just starting now, not already running?
     */
    private void readSettings() {

    	
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	Intent i = new Intent();

    	switch (item.getItemId()) {
//    	case R.id.menu_settings:
//    		i.setClass(this, SettingsActivity.class);
//    		startActivityForResult(i, SETTINGS_REQUEST_CODE);
//    		// on result, will call readSettings(false).
//    		return true;
    	
    	case R.id.menu_item_stop:
    		viewPager.setCurrentItem(0);
    		return true;

    	case R.id.menu_item_results:
    		viewPager.setCurrentItem(1);
    		return true;
    	
    	case R.id.menu_about:
    		showDialog(ABOUT_DIALOG);
    		return true;

    	case R.id.menu_send:
    		//TODO
    		//building current date
        	Calendar c = Calendar.getInstance();

        	SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        	String formattedDate = df.format(c.getTime());
    			
    		Util.startSendMailIntent
    		(this,"Lap Results " + formattedDate , resultBuilder()); //currentModeAsString(), createBodyFromCurrent());
    		return true;

    	/*case R.id.menu_load:
    		i.setClass(this, LoadActivity.class);
    		startActivity(i);
    		return true;
    		
    	  case R.id.menu_save:
    		showDialog(SAVE_DIALOG);
    		return true;
    		*/


    	}
    	return false;
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        Dialog dialog;
        switch(id) {
        case ABOUT_DIALOG:
        	AlertDialog.Builder aboutBuilder = new AlertDialog.Builder(this);
        	aboutBuilder.setMessage(R.string.about_dialog)
        	       .setCancelable(true)
        	.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
				public void onClick(DialogInterface dialog, int id) {
                     dialog.dismiss();
                }
            });

        	       
        	dialog = aboutBuilder.create();
        	break;
        	
               
        case SAVE_DIALOG:
        	AlertDialog.Builder saveBuilder = new AlertDialog.Builder(this);
        	saveBuilder.setTitle(R.string.save);
        	saveBuilder.setMessage(R.string.save_dialog);
        	final EditText input = new EditText(this);
        	saveBuilder.setView(input);
        	
        	saveBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        		@Override
				public void onClick(DialogInterface dialog, int whichButton) {
		    			
        				// TODO save!
		    			Toast toast = Toast.makeText(getApplicationContext(), R.string.saved_succes, Toast.LENGTH_SHORT);
		    			toast.show();
        			}

        		});
        	
        	saveBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
        		@Override
				public void onClick(DialogInterface dialog, int whichButton) {
	        			dialog.dismiss();
        			}
        		});
        	saveBuilder.setCancelable(false);
        	dialog = saveBuilder.create();
        	break;        	

        default: dialog = null;
		}
		
		
        return dialog;
    }

    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	readSettings(); // because only settingsactivity is started for
    	// result, we can launch that without checking the parameters.
    }
    
    
    private String resultBuilder()
    {
    	//building mail
    	StringBuilder sb = new StringBuilder();
		List<Lap> list = pageAdapter.getClock().getLaps();
		for(int j = 0; j < list.size(); j++)
		{
			 sb.append((j+1) + " " + list.get(j).playerName + " " +
						+ list.get(j).hours + "h " + list.get(j).minutes + ":" +
						list.get(j).seconds + ":" + list.get(j).deciSeconds +"\r\n ");
		}
		return sb.toString();
    }
}

