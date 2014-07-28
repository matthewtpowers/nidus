package com.applico.nesttest.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

/**
 * Created by matthewpowers on 7/25/14.
 * This is a smoke and carbon monoxide detector
 */
public class NestSmokeCo {
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

    @SerializedName("battery_health")
    public String batteryHealth;

    @SerializedName("co_alarm_state")
    public String coAlarmState;

    @SerializedName("smoke_alarm_state")
    public String smokeAlarmState;

    @SerializedName("ui_color_state")
    public String uiColorState;

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
