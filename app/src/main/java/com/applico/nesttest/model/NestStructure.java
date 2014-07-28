package com.applico.nesttest.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * Created by matthewpowers on 7/27/14.
 * A nest structure is a representation of a location.  Right now there is no concept of a room inside of a structure.
 *
 */
public class NestStructure {

    private static String LOG_TAG = NestStructure.class.getSimpleName();

    @SerializedName("structure_id")
    public String structureId;

    @SerializedName("thermostats")
    public String[] thermostats;

    @SerializedName("smoke_co_alarms")
    public String[] protects;

    @SerializedName("away")
    public String away;

    @SerializedName("home")
    public String home;

    @SerializedName("country_code")
    public String countryCode;

    @SerializedName("peak_period_start_time")
    public String peakStartTime;

    @SerializedName("peak_period_end_time")
    public String peakEndTime;

    @SerializedName("time_zone")
    public String timeZone;

    @SerializedName("eta")
    public NestEta eta;






}
