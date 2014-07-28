package com.applico.nesttest.model;

import com.google.gson.annotations.SerializedName;
import android.util.Log;

/**
 * Created by matthewpowers on 7/25/14.
 * The thermostat is one of the supported NEST devices
 */
public class NestThermostat {

    private static String LOG_TAG = NestThermostat.class.getSimpleName();

    @SerializedName("device_id")
    public String deviceId;

    @SerializedName("locale")
    public String locale;

    @SerializedName("software_version")
    public String version;

    @SerializedName("structure_id")
    public String structureId;

    @SerializedName("name")
    public String name;

    @SerializedName("name")
    public String nameLong;

    @SerializedName("last_connection")
    public String lastConnection;

    @SerializedName("is_online")
    public Boolean isOnline;

    @SerializedName("can_cool")
    public Boolean canCool;

    @SerializedName("can_heat")
    public Boolean canHeat;

    @SerializedName("is_using_emergency_heat")
    public Boolean usingEmergencyHeat;

    @SerializedName("has_fan")
    public Boolean hasFan;

    @SerializedName("fan_timer_active")
    public Boolean fanTimerActive;

    @SerializedName("fan_timer_timeout")
    public String fanTimerTimeout;

    @SerializedName("has_leaf")
    public Boolean hasLeaf;

    @SerializedName("temperature_scale")
    public String tempScale;

    @SerializedName("target_temperature_f")
    public String targetTempF;

    @SerializedName("target_temperature_c")
    public String targetTempC;

    @SerializedName("target_temperature_high_f")
    public String targetTempHighF;

    @SerializedName("target_temperature_high_c")
    public String targetTempHighC;

    @SerializedName("target_temperature_low_f")
    public String targetTempLowF;

    @SerializedName("target_temperature_low_c")
    public String targetTempLowC;

    @SerializedName("away_temperature_high_f")
    public String awayTempHighF;

    @SerializedName("away_temperature_high_c")
    public String awayTempHighC;

    @SerializedName("away_temperature_low_f")
    public String awayTempLowF;

    @SerializedName("away_temperature_low_c")
    public String awayTempLowC;

    @SerializedName("hvac_mode")
    public String hvac_mode;

    @SerializedName("ambient_temperature_f")
    public String ambientTempF;

    @SerializedName("ambient_temperature_c")
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
        targetTempF = "";
        targetTempC = "";
        targetTempHighF = "";
        targetTempHighC = "";
        targetTempLowF = "";
        targetTempLowC = "";
        awayTempHighF = "";
        awayTempHighC = "";
        awayTempLowF = "";
        awayTempLowC = "";
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

    public String getTargetTempF()
    {
        return targetTempF;
    }

    public String getTargetTempC()
    {
        return targetTempC;
    }

    public String getTargetTempHighF()
    {
        return targetTempHighF;
    }

    public String getTargetTempHighC()
    {
        return targetTempHighC;
    }

    public String getTargetTempLowF()
    {
        return targetTempLowF;
    }

    public String getTargetTempLowC()
    {
        return targetTempLowC;
    }

    public String getAwayTempHighF()
    {
        return awayTempHighF;
    }

    public String getAwayTempHighC()
    {
        return awayTempHighC;
    }

    public String getAwayTempLowF()
    {
        return awayTempLowF;
    }

    public String getAwayTempLowC()
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
