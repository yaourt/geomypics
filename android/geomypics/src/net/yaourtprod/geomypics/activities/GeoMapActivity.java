package net.yaourtprod.geomypics.activities;

import net.yaourtprod.geomypics.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class GeoMapActivity extends MapActivity {
	/** The Map view.*/
	private MapView mapView;
	/** The Map controller.*/
	private MapController mapController;
	/** MyLocationOverlay.*/
	private MyLocationOverlay myLocationOverlay;
	/** SelectedLocationOverlay.*/
	private SelectedLocationOverlay selectedLocationOverlay;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mapView = (MapView) findViewById(R.id.geomap_map_id);
        mapController = mapView.getController();
        
        mapView.setSatellite(true);
        mapView.setBuiltInZoomControls(true);
        
        myLocationOverlay = new MyLocationOverlay(this, mapView);
//        selectedLocationOverlay = new SelectedLocationOverlay(this, mapView);
    }

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}


	@Override
	protected boolean isRouteDisplayed() {
		return true;
	}
	
	private static class SelectedLocationOverlay extends Overlay {
		// http://developer.android.com/resources/tutorials/views/hello-mapview.html
		// http://mobiforge.com/developing/story/using-google-maps-android
	}
}
