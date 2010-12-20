package net.yaourtprod.geomypics.activities;

import java.text.DateFormat;
import java.util.Date;

import net.yaourtprod.geomypics.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CameraConfigActivity extends Activity implements OnClickListener {
	/**
	 * Constants to check & ask fot camera date / time resync.
	 */
	private static final long THREE_DAYS = 3 * 24 * 3600 * 1000; 
	/**
	 * Preference name hat holds the last time the camera date / time
	 * has been synced with the phone.
	 */
	private static final String LAST_SYNC_PREF_PROP = "lastCameraSync";
	
	/** The date text view .*/
	private TextView dateView;
	
	/** The Done button. */
	private Button doneBtn;
	
	/** The Later button. */
	private Button laterBtn;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        final long lastSync = getLastSync();
        if(System.currentTimeMillis() > lastSync + THREE_DAYS) {
	        setContentView(R.layout.camera_config);
	        
	        dateView = (TextView) findViewById(R.id.camera_config_date);
	        doneBtn = (Button) findViewById(R.id.camera_config_done);
	        doneBtn.setOnClickListener(this);
	        laterBtn = (Button) findViewById(R.id.camera_config_later);
	        laterBtn.setOnClickListener(this);
	        updateDisplay();
        } else {
        	showMap();
        }
    }
    
    /**
     * Updates the text displayed in the dedicated date TextView.
     */
    private void updateDisplay() {
    	final DateFormat df = DateFormat.getDateInstance();
    	final String strDate = df.format(new Date());
    	dateView.setText(strDate);
    }
    
    /**
     * Save the current time as the last sync time.
     */
    private void saveLastSync() {
        final SharedPreferences settings = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editor = settings.edit();
        editor.putLong(LAST_SYNC_PREF_PROP, System.currentTimeMillis());
        editor.commit();
    }
    
    /** Gets the last saved sync time.*/
    private long getLastSync() {
    	final SharedPreferences settings = getPreferences(MODE_PRIVATE);
    	return settings.getLong(LAST_SYNC_PREF_PROP, 0);
    }

	@Override
	public void onClick(final View clickedView) {
		if(null != clickedView) {
			if(doneBtn.equals(clickedView)){
				saveLastSync();
			}
			//Now we can go ahead ... 
			showMap();
		}
	}
	
	private void showMap() {
		final Intent intent = new Intent(this, GeoMapActivity.class);
		final Bundle bundle = new Bundle();
		intent.putExtras(bundle);
		startActivity(intent);
	}
}