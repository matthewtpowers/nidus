package com.applico.nesttest.provider;

/**
 * Created by matthewpowers on 7/28/14.
 *
 * This is the data contract for the NEST data including the following
 * 1) Structures - this is the idea of a home or residence
 * 2) Thermostats - this is a nest thermostat
 * 3) Protect - this is the Carbon Monoxide and Smoke Detector
 * 4) Elevated Event History - this is a history associated with "elevated events
 */
public class NestDataContract {

    /**
     * These are the base device columns for all
     * nest devices(Protect and Thermostats
     */
    public interface BaseDeviceColumns
    {
        /** The device ID associated with the device */
        public String COLUMN_DEVICE_ID = "device_id";
        /** The locale of the device */
        public String COLUMN_LOCALE = "locale";
        /** The software version of the device itself */
        public String COLUMN_SOFTWARE_VERSION = "sft_version";
        /** The structure id of where this device belongs */
        public String COLUMN_STRUCTURE_ID = "structure_id";
        /** The name of the device*/
        public String COLUMN_NAME = "name";
        /** The long name of the device */
        public String COLUMN_LONG_NAME = "name_long";
        /** The date/time of the last connection*/
        public String COLUMN_LAST_CONNECTION = "last_connection";
        /** Online Status of the device */
        public String COLUMN_IS_ONLINE = "is_online";

    }

    /**
     * Thermostat specific columns
     */
    public static abstract class ThermoColumns implements BaseDeviceColumns
    {
        /** Cooling ability of the device */
        public String COLUMN_CAN_COOL = "can_cool";
        /** Heating ability of the device */
        public String COLUMN_CAN_HEAT = "can_heat";
        /** Is emergency heat on */
        public String COLUMN_EMERGENCY_HEAT = "is_using_emergency_heat";
    }

}
