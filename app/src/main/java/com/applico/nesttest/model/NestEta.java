package com.applico.nesttest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by matthewpowers on 7/27/14.
 * Eta class is for the system to know when you are going to be home.
 */
public class NestEta {

    private static String LOG_TAG = NestEta.class.getSimpleName();

    @SerializedName("trip_id")
    public String tripId;

    @SerializedName("estimated_arrival_window_begin")
    public String estArrivalBegin;

    @SerializedName("estimated_arrival_window_end")
    public String estArrivalEnd;

}
