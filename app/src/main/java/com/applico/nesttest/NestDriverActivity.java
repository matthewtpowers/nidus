package com.applico.nesttest;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.content.Intent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;

import com.applico.nesttest.model.NestStructure;
import com.applico.nesttest.ui.NestAuthFragment;
import com.applico.nesttest.ui.NestDeviceFragment;
import com.applico.nesttest.ui.ThermostatFragment;
import com.applico.nesttest.utils.GenericConstants;
import com.applico.nesttest.model.INestService;
import com.applico.nesttest.model.NestToken;

import com.firebase.client.*;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Response;
import retrofit.RetrofitError;

import com.newrelic.agent.android.NewRelic;




public class NestDriverActivity extends Activity implements Firebase.AuthListener, NestAuthFragment.OnFragmentInteractionListener, NestDeviceFragment.OnFragmentInteractionListener, Callback<NestToken> {

    private static String LOG_TAG = NestDriverActivity.class.getSimpleName();

    private boolean mIsAuthorized = false;

    private SharedPreferences mSharedPref;

    private Firebase mFirebase;
    private String mAccessToken;

    //https://home.nest.com/login/oauth2?client_id=2ed12941-0134-4e77-85f9-793896e44e24&state=0138
    //TVPLXJJM
    /*
    Auth Process:
    1) Pass the client_id and state to the authuri
    2) State is a value that I choose
    3) This will return an authorization code
    4) Pass the code, client id and client secret to the Access Token URI
    5) This will return the Access Token URI
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nest_driver);

        //Start NewRelic
        NewRelic.withApplicationToken(GenericConstants.NEW_RELIC_AUTH_TOKEN).start(this);

        mSharedPref = getSharedPreferences(GenericConstants.NEST_SHARED_PREF_KEY, 0);
        mIsAuthorized = mSharedPref.getBoolean(GenericConstants.NEST_IS_AUTH, false);
        mAccessToken = mSharedPref.getString(GenericConstants.NEST_ACCESS_TOKEN,"invalid_token");

        if(mIsAuthorized == false)
        {
            Log.e(LOG_TAG,"Not Authorized");
            if (savedInstanceState == null) {
                getFragmentManager().beginTransaction()
                        .add(R.id.container, NestAuthFragment.newInstance(null,null))
                        .commit();
            }
        }
        else {
            Log.e(LOG_TAG,"Authorized");
            nestTestDriver();
            /*if (savedInstanceState == null) {
                getFragmentManager().beginTransaction()
                        .add(R.id.container, NestDeviceFragment.newInstance(null,null))
                        .commit();
            }*/





        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nest_driver, menu);
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

    /**
     * Auth error with firebase
     * @param firebaseError
     */
    @Override
    public void onAuthError(FirebaseError firebaseError) {
        Log.e(LOG_TAG,"On Auth Error: " + firebaseError.getMessage());

    }

    /**
     * Authentication is successful with firebase
     * @param o
     */
    @Override
    public void onAuthSuccess(Object o) {

        Log.e(LOG_TAG,"Auth Success");
    }

    /**
     * Authentication has been revoked by firebase
     * @param firebaseError
     */
    @Override
    public void onAuthRevoked(FirebaseError firebaseError) {
        Log.e(LOG_TAG,"Auth Revoked");
        invalidatePreferences();
    }


    /**
     * Communication with the fragment
     * @param str
     */
    @Override
    public void onFragmentInteraction(String str) {
        Log.e(LOG_TAG,"On Fragment Interaction");
        mSharedPref = getSharedPreferences(GenericConstants.NEST_SHARED_PREF_KEY, 0);
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(GenericConstants.NEST_AUTH_CODE_KEY, str);
        editor.commit();
        authorizeWithNest();
    }

    //My Own Callback code
    @Override
    public void success(NestToken t, Response response) {
        mSharedPref = getSharedPreferences(GenericConstants.NEST_SHARED_PREF_KEY, 0);
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(GenericConstants.NEST_ACCESS_TOKEN, t.accessToken);
        editor.putLong(GenericConstants.NEST_ACCESS_TOKEN_EXPIRATION, t.expirationDate);
        editor.putBoolean(GenericConstants.NEST_IS_AUTH, true);
        editor.commit();
        mAccessToken = t.accessToken;
        Log.e(LOG_TAG, "Access Token: " + t.accessToken);
        Log.e(LOG_TAG,"Expiration Date: " + t.expirationDate);
        nestTestDriver();
    }

    @Override
    public void failure(RetrofitError error) {
        Log.e(LOG_TAG, "Error: " + error.toString());
        invalidatePreferences();
    }

    /**
     * Take care of authentication with Nest
     * TODO move to a NEST utils class
     */
    private void authorizeWithNest() {
        //"https://api.home.nest.com/oauth2/access_token?code=AUTHORIZATION_CODE&client_id=2ed12941-0134-4e77-85f9-793896e44e24&client_secret=V08y0eCN7KX5HwNEPfKrQysy7&grant_type=authorization_code";
        //https://api.home.nest.com/oauth2/access_token?code=FP2UDPME&client_id=2ed12941-0134-4e77-85f9-793896e44e24&client_secret=V08y0eCN7KX5HwNEPfKrQysy7&grant_type=0138

        //TODO put this in a handler class
        Map<String, String> authMap = new LinkedHashMap<String, String>();
        authMap.put("code",mSharedPref.getString(GenericConstants.NEST_AUTH_CODE_KEY,"Default"));
        authMap.put("client_id",GenericConstants.NEST_CLIENT_ID);
        authMap.put("client_secret",GenericConstants.NEST_CLIENT_SECRET);
        authMap.put("grant_type",GenericConstants.NEST_GRANT_TYPE);
        //Do the rest adapter here, Retrofit asynchronous calls are done with a ThreadPool
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(GenericConstants.NEST_API_URI).build();
        restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        INestService svc = restAdapter.create(INestService.class);
        Log.e(LOG_TAG,"About to call the service");
        svc.getToken(authMap,this);

        /**
         * {
         *  "access_token":"c.5z8rMYNQBcgQ2ln0RGeusBBPzoxEedJ8XMB4LUsG8J5AcM0LBDLUgIbklrisuBy5WxCf1O0rPXMtTQh57WJATQIi6lGMrlpLplbGsaB8cy74TmWZDHDEoB5VpV14WHBBQ1TUfa2AVBrylqOH",
         * "expires_in":315360000
         * }
         *
         */
    }

    /**
     * Reset everything like its a clean build
     */
    private void invalidatePreferences()
    {
        mIsAuthorized = false;
        mSharedPref = getSharedPreferences(GenericConstants.NEST_SHARED_PREF_KEY, 0);
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putString(GenericConstants.NEST_ACCESS_TOKEN,"");
        editor.putLong(GenericConstants.NEST_ACCESS_TOKEN_EXPIRATION, 0);
        editor.putBoolean(GenericConstants.NEST_IS_AUTH, false);
        editor.commit();
    }


    @Override
    public void onFragmentInteraction(Intent intent, View view) {
        view.setViewName("doesntmatter");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this,new Pair<View, String>(
                view,
                DeviceDetailsActivity.VIEW_NAME_HEADER_TITLE));


        Bundle bundle = options.toBundle();
        startActivity(intent, bundle);
    }

    public void Method(View view){
        Log.e(LOG_TAG,"Clicked");
    }

    private void nestTestDriver()
    {
        Log.e(LOG_TAG,"Firebase URI: " + GenericConstants.NEST_FIREBASE_URI);
        Log.e(LOG_TAG,"Firebase Auth Token: " + mAccessToken.toString());
        //Place holder for setting up the firebase code
        mFirebase = new Firebase(GenericConstants.NEST_FIREBASE_URI);
        mFirebase.auth(mAccessToken, new Firebase.AuthListener() {

            @Override
            public void onAuthError(FirebaseError firebaseError) {
                Log.e(LOG_TAG,"Auth Error: " + firebaseError.getMessage());
            }

            @Override
            public void onAuthSuccess(Object o) {
                Log.e(LOG_TAG,"Auth Success: " + o.toString());
            }

            @Override
            public void onAuthRevoked(FirebaseError firebaseError) {
                Log.e(LOG_TAG,"Auth Revoked: " + firebaseError.getMessage());
            }
        });
        mFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(LOG_TAG,"Data Snapshot hit: " + dataSnapshot.getValue());

                long child_count  = dataSnapshot.getChildrenCount();
                Log.e(LOG_TAG,"Child Count: " + child_count);
                for(DataSnapshot child: dataSnapshot.getChildren())
                {
                    Log.e(LOG_TAG,"Child Name: " + child.getName());
                }
                if(dataSnapshot.hasChild("structures"))
                {
                    Log.e(LOG_TAG,"Structures exist");
                    Log.e(LOG_TAG,"Structures has children: " + dataSnapshot.child("structures").hasChildren());
                    for (DataSnapshot child: dataSnapshot.child("structures").getChildren())
                    {
                        Log.e(LOG_TAG,"Child Value: " + child.getValue());
                        NestStructure struct = child.getValue(NestStructure.class);
                        struct.testObject();
                    }

                }else
                {
                    Log.e(LOG_TAG,"Structures do not exist");
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e(LOG_TAG,"The read failed: " + firebaseError.getMessage());
            }
        });
    }

}
