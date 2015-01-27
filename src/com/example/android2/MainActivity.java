package com.example.android2;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements LocationListener{
	private LocationManager manager = null;
	private TextView ido;
	private TextView keido;
	private TextView koudo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		manager = (LocationManager)getSystemService(LOCATION_SERVICE);
		ido = (TextView)findViewById(R.id.textView1);
		keido = (TextView)findViewById(R.id.textView2);
		koudo = (TextView)findViewById(R.id.textView3);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		if(manager != null) {
			manager.removeUpdates(this);
		}
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		if(manager != null) {
			manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
		}
		super.onResume();
	}

	@Override
	public void onLocationChanged(Location location) {
	// TODO Auto-generated method stub
	String str = "緯度：" + location.getLatitude();
	ido.setText(str);
	str = "経度：" + location.getLongitude();
	keido.setText(str);
	str = "高度：" + location.getAltitude();
	koudo.setText(str);
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
