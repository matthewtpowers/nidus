package com.applico.nesttest.model;

import android.util.Log;

import com.shaded.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by matthewpowers on 7/25/14.
 * This is a smoke and carbon monoxide detector
 */
public class NestProtect {
    private static String LOG_TAG = NestThermostat.class.getSimpleName();

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
    public Boolean isOnline;

    @JsonProperty("battery_health")
    public String batteryHealth;

    @JsonProperty("co_alarm_state")
    public String coAlarmState;

    @JsonProperty("smoke_alarm_state")
    public String smokeAlarmState;

    @JsonProperty("ui_color_state")
    public String uiColorState;

    public NestProtect()
    {
        deviceId = "";
        locale = "";
        version = "";
        structureId = "";
        name = "";
        nameLong = "";
        lastConnection = "";
        isOnline = false;
        batteryHealth = "";
        coAlarmState = "";
        smokeAlarmState = "";
        uiColorState = "";
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

    public String getBatteryHealth()
    {
        return batteryHealth;
    }

    public String getCoAlarmState()
    {
        return coAlarmState;
    }

    public String getSmokeAlarmState()
    {
        return smokeAlarmState;
    }

    public String getUiColorState()
    {
        return uiColorState;
    }


    /**
     * There are more elegant solutions to this, I know, but it does what I need
     */
    public void testObject()
    {
        Log.e(LOG_TAG, "device_id: " + deviceId);
        Log.e(LOG_TAG,"locale: " + locale);
        Log.e(LOG_TAG,"software_version: " + version);
        Log.e(LOG_TAG,"structure_id: " + structureId);
        Log.e(LOG_TAG,"name: " + name);
        Log.e(LOG_TAG,"name_long" + nameLong);
        Log.e(LOG_TAG,"last_connection: " + lastConnection);
        Log.e(LOG_TAG,"is_online: " + isOnline);
        Log.e(LOG_TAG,"battery_health: " + batteryHealth);
        Log.e(LOG_TAG,"co_alarm_state: " + coAlarmState);
        Log.e(LOG_TAG,"smoke_alarm_state: " + smokeAlarmState);
        Log.e(LOG_TAG,"ui_color_state: " + uiColorState);

    }

}
