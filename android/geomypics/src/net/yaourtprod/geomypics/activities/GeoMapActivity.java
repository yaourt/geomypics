package net.yaourtprod.geomypics.activities;

import net.yaourtprod.geomypics.R;
import android.os.Bundle;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class GeoMapActivity extends MapActivity {
	/** The Map view.*/
	private MapView mapView;
	/** The Map controller.*/
	private MapController mapController;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);
        mapView = (MapView) findViewById(R.id.geomap_map_id);
        mapController = mapView.getController();
        
        mapView.setSatellite(true);
        mapView.setBuiltInZoomControls(true);
    }

	@Override
	protected boolean isRouteDisplayed() {
		return true;
	}
}
