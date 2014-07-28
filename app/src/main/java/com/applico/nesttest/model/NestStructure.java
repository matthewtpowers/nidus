package com.applico.nesttest.model;

import com.shaded.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.ArrayList;
import android.util.Log;

/**
 * Created by matthewpowers on 7/27/14.
 * A nest structure is a representation of a location.  Right now there is no concept of a room inside of a structure.
 *
 */
public class NestStructure {

    private static String LOG_TAG = NestStructure.class.getSimpleName();

    /**
     *  To marshall data from the Firebase api I must have a blank constructor and
     *  getters and setters
     */

    @JsonProperty("structure_id")
    public String structureId;

    @JsonProperty("thermostats")
    public List<String> thermostats;

    @JsonProperty("smoke_co_alarms")
    public List<String> protects;

    @JsonProperty("away")
    public String away;

    @JsonProperty("name")
    public String name;

    @JsonProperty("country_code")
    public String countryCode;

    @JsonProperty("peak_period_start_time")
    public String peakStartTime;

    @JsonProperty("peak_period_end_time")
    public String peakEndTime;

    @JsonProperty("time_zone")
    public String timeZone;

    @JsonProperty("eta")
    public NestEta eta;

    private NestStructure()
    {
        structureId = "";
        thermostats = new ArrayList<String>();
        protects = new ArrayList<String>();
        away = "";
        name = "";
        countryCode = "";
        peakStartTime = "";
        peakEndTime = "";
        timeZone = "";
        eta = new NestEta();
    }


    public String getStructureId()
    {
        return structureId;
    }

    public List<String> getThermostats()
    {
        return thermostats;
    }

    public List<String> getProtects()
    {
        return protects;
    }

    public String getAway()
    {
        return away;
    }

    public String getName()
    {
        return name;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getPeakStartTime()
    {
        return peakStartTime;
    }

    public String getPeakEndTime()
    {
        return peakEndTime;
    }

    public String getTimeZone()
    {
        return timeZone;
    }

    /**
     * There are more elegant solutions to this, I know, but it does what I need
     */
    public void testObject()
    {

        Log.e(LOG_TAG,"structure_id:" + structureId);

        for(String s : thermostats)
        {
            Log.e(LOG_TAG,"Thermo: " + s);
        }
        for(String s : protects)
        {
            Log.e(LOG_TAG,"Protect: " + s);
        }
        Log.e(LOG_TAG,"away: " + away);
        Log.e(LOG_TAG,"name: " + name);
        Log.e(LOG_TAG,"country_code: " + countryCode);
        Log.e(LOG_TAG,"peak_period_start_time: " + peakStartTime);
        Log.e(LOG_TAG,"peak_period_end_time" + peakEndTime);
        Log.e(LOG_TAG,"time_zone: " + timeZone);
        eta.testObject();

    }




}
