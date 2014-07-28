package com.applico.nesttest;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.net.Uri;

import com.applico.nesttest.R;
import com.applico.nesttest.ui.ThermostatFragment;

public class DeviceDetailsActivity extends Activity implements ThermostatFragment.OnFragmentInteractionListener {

    private static String LOG_TAG = DeviceDetailsActivity.class.getSimpleName();
    // View name of the header title. Used for activity scene transitions
    public static final String VIEW_NAME_HEADER_TITLE = "detail:header:title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(LOG_TAG,"Creating the details activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_details);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ThermostatFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.device_details, menu);
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
