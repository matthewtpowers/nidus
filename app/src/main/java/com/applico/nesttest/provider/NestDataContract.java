package com.applico.nesttest.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by matthewpowers on 7/28/14.
 *
 * This is the data contract for the NEST data including the following.  The data contract is
 * responsible for identifying the columns, tables and unique uris.  This class is basically
 * responsible for the definitions for the content provider.  Some of this is based on code from
 * previous @Applicomobile products as well as the ioSchedule code from Google IO.
 * 1) Structures - this is the idea of a home or residence
 * 2) Thermostats - this is a nest thermostat
 * 3) Protect - this is the Carbon Monoxide and Smoke Detector
 * 4) Elevated Event History - this is a history associated with "elevated events
 */
public class NestDataContract {

    public static final String CONTENT_AUTHORITY = "com.applico.nesttest";
    public static final Uri BASE_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    //These are the URIs substrings for each datasource (table)
    private static final String PATH_PROTECT = "protect";
    private static final String PATH_THERMO = "thermo";
    private static final String PATH_STRUCTURE = "structure";
    private static final String PATH_ETA = "eta";

    /**
     * These are the base device columns for all
     * nest devices(Protect and Thermostats
     */
    public interface BaseNestDeviceColumns extends BaseColumns
    {
        /** The device ID associated with the device */
        public static final String COLUMN_DEVICE_ID = "device_id";
        /** The locale of the device */
        public static final String COLUMN_LOCALE = "locale";
        /** The software version of the device itself */
        public static final String COLUMN_SOFTWARE_VERSION = "sft_version";
        /** The structure id of where this device belongs */
        public static final String COLUMN_STRUCTURE_ID = "structure_id";
        /** The name of the device*/
        public static final String COLUMN_NAME = "name";
        /** The long name of the device */
        public static final String COLUMN_LONG_NAME = "name_long";
        /** The date/time of the last connection*/
        public static final String COLUMN_LAST_CONNECTION = "last_connection";
        /** Online Status of the device */
        public static final String COLUMN_IS_ONLINE = "is_online";
        /** Column Updated */
        public static final String COLUMN_UPDATED = "updated";

    }

    /**
     * These are the columns associated with ETA (Estimated Trip Arrival)
     */
    public interface ETAColumns
    {
        /** This is the structure id for the trip */
        public static final String COLUMN_STRUCTURE_ID = "structure_id";
        /** This is the trip id */
        public static final String COLUMN_TRIP_ID = "trip_id";
        /** This is the start of the arrival window */
        public static final String COLUMN_ARRIVAL_START = "estimated_arrival_window_begin";
        /** This is the end of the arrival window */
        public static final String COLUMN_ARRIVAL_END = "estimated_arrival_window_end";
        /** Column Updated */
        public static final String COLUMN_UPDATED = "updated";

    }

    /**
     * These are the columns for the structure (think of a structure as a place
     */
    public interface StructuresColumns
    {
        /** The unique id of this structure */
        public static final String COLUMN_STRUCTURE_ID = "structure_id";
        /** This is a list of Thermo IDs that I don't believe we are going to end up needing */
        public static final String COLUMN_THERMOSTATS = "thermostats";
        /** This is a list of protect products */
        public static final String COLUMN_PROTECTS = "protects";
        /** This is hte state of the structure, home, away, auto-away.  All devices must be in
         * agreement for this state
         */
        public static final String COLUMN_AWAY = "away";
        /** User defined name of this structure **/
        public static final String COLUMN_USER_DEFINED_NAME = "name";
        /** This is the country code for the device */
        public static final String COLUMN_COUNTRY_CODE = "country_code";
        /** Rush hour rewards start time http://support.nest
         * .com/article/What-is-Rush-Hour-Rewards */
        public static final String COLUMN_NAME_PEAK_PERIOD_START_TIME = "period_start_time";
        /** Rush hours rewards end time */
        public static final String COLUMN_NAME_PEAK_PERIOD_END_TIME = "period_end_time";
        /** Time Zone of the structure */
        public static final String COLUMN_TIME_ZONE = "time_zone";
        /** Column Updated */
        public static final String COLUMN_UPDATED = "updated";


    }


    /**
     * Thermostats are self explanatory
     */
    public interface ThermoColumns extends BaseColumns, BaseNestDeviceColumns
    {
        /** Cooling ability of the device */
        public static final String COLUMN_CAN_COOL = "can_cool";
        /** Heating ability of the device */
        public static final String COLUMN_CAN_HEAT = "can_heat";
        /** Is emergency heat on */
        public static final String COLUMN_EMERGENCY_HEAT = "is_using_emergency_heat";
        /** System ability to control the fan independently of the device */
        public static final String COLUMN_HAS_FAN = "has_fan";
        /** If there is a fan is the fan timer active? */
        public static final String COLUMN_FAN_TIMER_ACTIVE = "fan_timer_active";
        /** Fan timer timeout */
        public static final String COLUMN_FAN_TIMER_TIMEOUT= "fan_timer_timeout";
        /** The leaf is displayed when they are in energy savings mode */
        public static final String COLUMN_HAS_LEAF = "has_leaf";
        /**Simple temperature scale */
        public static final String COLUMN_TEMP_SCALE = "temperature_scale";
        /** Target temperature F */
        public static final String COLUMN_TARGET_TEMP_F = "target_temperature_f";
        /** Target temperature C */
        public static final String COLUMN_TARGET_TEMP_C = "target_temperature_c";
        /** Max value for the temp */
        public static final String COLUMN_TARGET_TEMP_MAX_F = "target_temp_high_f";
        /** Max value for the temp */
        public static final String COLUMN_TARGET_TEMP_MAX_C = "target_temp_high_c";
        /** Min value for the temp */
        public static final String COLUMN_TARGET_TEMP_MIN_F = "target_temp_min_f";
        /** Min value for the temp */
        public static final String COLUMN_TARGET_TEMP_MIN_C = "target_temp_min_c";
        /** Max value for the away temp */
        public static final String COLUMN_TARGET_AWAY_TEMP_MAX_F = "target_temp_away_high_f";
        /** Max value for the away temp */
        public static final String COLUMN_TARGET_AWAY_TEMP_MAX_C = "target_temp_away_high_c";
        /** Min value for the away temp */
        public static final String COLUMN_TARGET_AWAY_TEMP_MIN_F = "target_temp_away_min_f";
        /** Min value for the away temp */
        public static final String COLUMN_TARGET_AWAY_TEMP_MIN_C = "target_temp_away_min_c";
        /** HVAC Mode - heat, cool, heat-cool, off */
        public static final String COLUMN_HVAC_MODE = "hvac_mode";
        /** Current temperature F */
        public static final String COLUMN_AMBIENT_TEMP_F = "ambient_temperature_f";
        /** Current temperature C*/
        public static final String COLUMN_AMBIENT_TEMP_C = "ambient_temperature_c";


    }

    /**
     * These are the columns for the CO & Smoke Detector (i.e. the Protect)
     */
    public interface ProtectColumns extends BaseColumns, BaseNestDeviceColumns
    {
        /** esimtate of the remaining battery power */
        public static final String COLUMN_BATTERY_HEALTH = "battery_health";
        /** state of the CO - this is ok,warning and emergency */
        public static final String COLUMN_CO_ALARM_STATE = "co_alarm_state";
        /** state of the smoke detector - this is ok,warning and emergency */
        public static final String COLUMN_CO_SMOKE_STATE = "smoke_alarm_state";
        /** aggregate state of the two sensors: gray, green, yellow, red */
        public static final String COLUMN_UI_COLOR_STATE = "ui_color_state";
    }

    //TODO fill out the abstract classes
    /**
     * Structures are Nest "locations"
     */
    public static abstract class Structures implements StructuresColumns
    {
        //Database table name
        public static final String NEST_STRUCTURES = "nest_structures";
        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH_STRUCTURE)
                .build();

    }

    /**
     * These are the columns for the ETA component (Estimated Time Arrival).
     * Estimated time arrival is a component of every home
     */
    public static abstract class ETA {
        //Database table name
        public static final String NEST_ETA = "nest_eta";
        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH_ETA).build();

    }

    /**
     *
     */
    public static abstract class Thermostats implements ThermoColumns
    {
        //Database table name
        public static final String NEST_THERMO = "nest_thermo";
        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH_THERMO).build();
    }

    /**
     *
     */
    public static abstract class Protect implements ProtectColumns
    {
        //Database table name
        public static final String NEST_PROTECT = "nest_protect";
        public static final Uri CONTENT_URI = BASE_URI.buildUpon().appendPath(PATH_PROTECT).build();
    }





}
