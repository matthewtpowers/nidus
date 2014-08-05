package com.applico.nesttest.model;

import com.google.gson.annotations.SerializedName;
import com.shaded.fasterxml.jackson.annotation.JsonProperty;

import android.util.Log;

/**
 * Created by matthewpowers on 7/25/14.
 * The thermostat is one of the supported NEST devices
 */
public class NestThermostat {

    private static String LOG_TAG = NestThermostat.class.getSimpleName();
    //TODO an enumaration for some of the values starting with hvac_mode

    @JsonProperty("device_id")
    public String deviceId;

    @JsonProperty("locale")
    public String locale;

    @JsonProperty("software_version")
    public String version;

    @JsonProperty("structure_id")
    public String structureId;

    @JsonProperty("name")
    public String name;

    @JsonProperty("name_long")
    public String nameLong;

    @JsonProperty("last_connection")
    public String lastConnection;

    @JsonProperty("is_online")
    public boolean isOnline;

    @JsonProperty("can_cool")
    public boolean canCool;

    @JsonProperty("can_heat")
    public boolean canHeat;

    @JsonProperty("is_using_emergency_heat")
    public boolean usingEmergencyHeat;

    @JsonProperty("has_fan")
    public boolean hasFan;

    @JsonProperty("fan_timer_active")
    public boolean fanTimerActive;

    @JsonProperty("fan_timer_timeout")
    public String fanTimerTimeout;

    @JsonProperty("has_leaf")
    public boolean hasLeaf;

    @JsonProperty("temperature_scale")
    public String tempScale;

    @JsonProperty("target_temperature_f")
    public int targetTempF;

    @JsonProperty("target_temperature_c")
    public float targetTempC;

    @JsonProperty("target_temperature_high_f")
    public int targetTempHighF;

    @JsonProperty("target_temperature_high_c")
    public float targetTempHighC;

    @JsonProperty("target_temperature_low_f")
    public int targetTempLowF;

    @JsonProperty("target_temperature_low_c")
    public float targetTempLowC;

    @JsonProperty("away_temperature_high_f")
    public int awayTempHighF;

    @JsonProperty("away_temperature_high_c")
    public float awayTempHighC;

    @JsonProperty("away_temperature_low_f")
    public int awayTempLowF;

    @JsonProperty("away_temperature_low_c")
    public float awayTempLowC;

    @JsonProperty("hvac_mode")
    public String hvac_mode;

    @JsonProperty("ambient_temperature_f")
    public String ambientTempF;

    @JsonProperty("ambient_temperature_c")
    public String ambientTempC;

    public NestThermostat()
    {
        deviceId = "";
        locale = "";
        version = "";
        structureId = "";
        name = "";
        nameLong = "";
        lastConnection = "";
        isOnline = false;
        canCool = false;
        canHeat = false;
        usingEmergencyHeat = false;
        hasFan = false;
        fanTimerActive = false;
        fanTimerTimeout = "";
        hasLeaf = false;
        tempScale = "";
        targetTempF = 0;
        targetTempC = 0;
        targetTempHighF = 0;
        targetTempHighC = 0;
        targetTempLowF = 0;
        targetTempLowC = 0;
        awayTempHighF = 0;
        awayTempHighC = 0;
        awayTempLowF = 0;
        awayTempLowC = 0;
        hvac_mode = "";
        ambientTempF = "";
        ambientTempC = "";
    }


    public String getDeviceId()
    {
        return deviceId;
    }

    public String getLocale()
    {
        return locale;
    }

    public String getVersion()
    {
        return version;
    }

    public String getStructureId()
    {

        return structureId;
    }

    public String getName()
    {
        return name;
    }

    public String getNameLong()
    {
        return nameLong;
    }

    public String getLastConnection()
    {
        return lastConnection;
    }

    public Boolean isOnline()
    {
        return isOnline;
    }

    public Boolean canCool()
    {
        return canCool;
    }

    public Boolean canHeat()
    {
        return canHeat;
    }

    public Boolean isUsingEmergencyHeat()
    {
        return usingEmergencyHeat;
    }

    public Boolean hasFan()
    {
        return hasFan;
    }

    public Boolean isFanTimerActive()
    {
        return fanTimerActive;
    }

    public String getFanTimerTimeout()
    {
        return fanTimerTimeout;
    }

    public Boolean hasLeaf()
    {
        return hasLeaf;
    }

    public String getTempScale()
    {
        return tempScale;
    }

    public int getTargetTempF()
    {
        return targetTempF;
    }

    public float getTargetTempC()
    {
        return targetTempC;
    }

    public int getTargetTempHighF()
    {
        return targetTempHighF;
    }

    public float getTargetTempHighC()
    {
        return targetTempHighC;
    }

    public int getTargetTempLowF()
    {
        return targetTempLowF;
    }

    public float getTargetTempLowC()
    {
        return targetTempLowC;
    }

    public int getAwayTempHighF()
    {
        return awayTempHighF;
    }

    public float getAwayTempHighC()
    {
        return awayTempHighC;
    }

    public int getAwayTempLowF()
    {
        return awayTempLowF;
    }

    public float getAwayTempLowC()
    {
        return awayTempLowC;
    }

    public String getHvac_mode()
    {
        return hvac_mode;
    }

    public String getAmbientTempF()
    {
        return ambientTempF;
    }

    public String getAmbientTempC()
    {
        return ambientTempC;
    }

    /**
     * There are more elegant solutions to this, I know, but it does what I need
     */
    public void testObject()
    {
        Log.e(LOG_TAG,"device_id: " + deviceId);
        Log.e(LOG_TAG,"locale: " + locale);
        Log.e(LOG_TAG,"software_version: " + version);
        Log.e(LOG_TAG,"structure_id: " + structureId);
        Log.e(LOG_TAG,"name: " + name);
        Log.e(LOG_TAG,"name_long" + nameLong);
        Log.e(LOG_TAG,"last_connection: " + lastConnection);
        Log.e(LOG_TAG,"is_online: " + isOnline);
        Log.e(LOG_TAG,"can_cool" + canCool);
        Log.e(LOG_TAG,"can_heat: " + canHeat);
        Log.e(LOG_TAG,"is_using_emergency_heat: " + usingEmergencyHeat);
        Log.e(LOG_TAG,"has_fan: " + hasFan);
        Log.e(LOG_TAG,"fan_timer_active: " + fanTimerActive);
        Log.e(LOG_TAG,"fan_timer_timeout: " + fanTimerTimeout);
        Log.e(LOG_TAG,"has_leaf: " + hasLeaf);
        Log.e(LOG_TAG,"temperature_scale: " + tempScale);
        Log.e(LOG_TAG,"target_temperature_f: " + targetTempF);
        Log.e(LOG_TAG,"target_temperature_c: " + targetTempC);
        Log.e(LOG_TAG,"target_temperature_high_f: " + targetTempHighF);
        Log.e(LOG_TAG,"target_temperature_high_c: " + targetTempHighC);
        Log.e(LOG_TAG,"target_temperature_low_f: " + targetTempLowF);
        Log.e(LOG_TAG,"target_temperature_low_c: " + targetTempLowC);
        Log.e(LOG_TAG,"away_temperature_high_f: " + awayTempHighF);
        Log.e(LOG_TAG,"away_temperature_high_c: "+ awayTempHighC);
        Log.e(LOG_TAG,"away_temperature_low_f: " + awayTempLowF);
        Log.e(LOG_TAG,"away_temperature_low_c: " + awayTempLowC);
        Log.e(LOG_TAG,"hvac_mode: " + hvac_mode);
        Log.e(LOG_TAG,"ambient_temperature_f: " + ambientTempF);
        Log.e(LOG_TAG,"ambient_temperature_c: " + ambientTempC);
    }



}
