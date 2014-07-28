package com.applico.nesttest.model;

import com.shaded.fasterxml.jackson.annotation.JsonProperty;
import android.util.Log;

/**
 * Created by matthewpowers on 7/27/14.
 * Eta class is for the system to know when you are going to be home.
 * This class should be used for scheduling trips
 */
public class NestEta {

    private static String LOG_TAG = NestEta.class.getSimpleName();

    @JsonProperty("trip_id")
    public String tripId;

    @JsonProperty("estimated_arrival_window_begin")
    public String estArrivalBegin;

    @JsonProperty("estimated_arrival_window_end")
    public String estArrivalEnd;

    public NestEta()
    {
        tripId = "";
        estArrivalBegin = "";
        estArrivalEnd = "";
    }

    public String getTripId()
    {
        return tripId;
    }

    public String getEstArrivalBegin()
    {
        return estArrivalBegin;
    }

    public String getEstArrivalEnd()
    {
        return estArrivalEnd;
    }

    /**
     * Test printing out the object
     */
    public void testObject()
    {
        Log.e(LOG_TAG,"trip_id: " + tripId);
        Log.e(LOG_TAG,"estimated_arrival_window_begin: " + estArrivalBegin);
        Log.e(LOG_TAG,"estimated_arrival_window_end" + estArrivalEnd);
    }

}
