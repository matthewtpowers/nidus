package com.applico.nesttest.provider;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

import com.applico.nesttest.R;
import com.applico.nesttest.model.NestStructure;
import com.applico.nesttest.provider.NestDataContract.StructuresColumns;
import com.applico.nesttest.provider.NestDataContract.ETAColumns;
import com.applico.nesttest.provider.NestDataContract.ThermoColumns;
import com.applico.nesttest.provider.NestDataContract.ProtectColumns;



/**
 * Created by matthewpowers on 7/31/14.
 */
public class NestDatabase extends SQLiteOpenHelper {
    private static final String LOG_TAG = NestDatabase.class.getSimpleName();

    private final Context mContext;

    private static String DATABASE_NAME;
    private static String DATABASE_VERSION;


    public NestDatabase(Context context) {
        super(context, "", null, 1);
        mContext = context;
        DATABASE_NAME = context.getString(R.string.database_name);
        DATABASE_VERSION = context.getString(R.string.database_version_a);
    }


    //TODO still need to work through the best way to do the base columns
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(LOG_TAG,"Creating the databse");
        /** Create the Structures Table */
        db.execSQL("CREATE_TABLE " + NestDataContract.Structures.NEST_STRUCTURES + "("
                        + StructuresColumns.COLUMN_STRUCTURE_ID + " TEXT NOT NULL,"
                        + StructuresColumns.COLUMN_THERMOSTATS + " TEXT,"
                        + StructuresColumns.COLUMN_PROTECTS + " TEXT,"
                        + StructuresColumns.COLUMN_AWAY + " TEXT,"
                        + StructuresColumns.COLUMN_USER_DEFINED_NAME + " TEXT,"
                        + StructuresColumns.COLUMN_COUNTRY_CODE + ""
                        + StructuresColumns.COLUMN_NAME_PEAK_PERIOD_START_TIME + " Integer,"
                        + StructuresColumns.COLUMN_NAME_PEAK_PERIOD_END_TIME + " Integer,"
                        + StructuresColumns.COLUMN_TIME_ZONE + " TEXT,"
                        + StructuresColumns.COLUMN_UPDATED + " INTEGER NOT NULL)"
        );

        /** Create the Estimated Time Arrival Table */
        db.execSQL("CREATE_TABLE " + NestDataContract.ETA.NEST_ETA + "("
                        + ETAColumns.COLUMN_STRUCTURE_ID + " TEXT NOT NULL,"
                        + ETAColumns.COLUMN_TRIP_ID + " TEXT NOT NULL,"
                        + ETAColumns.COLUMN_ARRIVAL_START + " INTEGER NOT NULL,"
                        + ETAColumns.COLUMN_ARRIVAL_END + " INTEGER NOT NULL,"
                        + ETAColumns.COLUMN_UPDATED + " INTEGER NOT NULL)"
        );

        /** Create the Thermostats table */
        db.execSQL("CREATE_TABLE " + NestDataContract.Thermostats.NEST_THERMO + "("
                        + ThermoColumns.COLUMN_DEVICE_ID + " TEXT NOT NULL, "
                        + ThermoColumns.COLUMN_LOCALE + " TEXT NOT NULL, "
                        + ThermoColumns.COLUMN_SOFTWARE_VERSION + " TEXT, "
                        + ThermoColumns.COLUMN_STRUCTURE_ID + " INTEGER NOT NULL, "
                        + ThermoColumns.COLUMN_NAME + " TEXT, "
                        + ThermoColumns.COLUMN_LONG_NAME + " TEXT, "
                        + ThermoColumns.COLUMN_SOFTWARE_VERSION + " TEXT, "
                        + ThermoColumns.COLUMN_LAST_CONNECTION + " INTEGER, "
                        + ThermoColumns.COLUMN_IS_ONLINE + " BOOLEAN, "
                        + ThermoColumns.COLUMN_CAN_COOL + " BOOLEAN, "
                        + ThermoColumns.COLUMN_CAN_HEAT + " BOOLEAN, "
                        + ThermoColumns.COLUMN_EMERGENCY_HEAT + " BOOLEAN, "
                        + ThermoColumns.COLUMN_HAS_FAN + " BOOLEAN, "
                        + ThermoColumns.COLUMN_FAN_TIMER_ACTIVE + " BOOLEAN, "
                        + ThermoColumns.COLUMN_FAN_TIMER_TIMEOUT + " INTEGER, "
                        + ThermoColumns.COLUMN_HAS_LEAF + " BOOLEAN, "
                        + ThermoColumns.COLUMN_TEMP_SCALE + " TEXT, "
                        + ThermoColumns.COLUMN_TARGET_TEMP_F + " INTEGER, "
                        + ThermoColumns.COLUMN_TARGET_TEMP_C + " REAL, "
                        + ThermoColumns.COLUMN_TARGET_TEMP_MAX_F + " INTEGER, "
                        + ThermoColumns.COLUMN_TARGET_TEMP_MAX_C + " REAL, "
                        + ThermoColumns.COLUMN_TARGET_TEMP_MIN_F + " INTEGER, "
                        + ThermoColumns.COLUMN_TARGET_TEMP_MIN_C + " REAL, "
                        + ThermoColumns.COLUMN_TARGET_AWAY_TEMP_MAX_F + " INTEGER, "
                        + ThermoColumns.COLUMN_TARGET_AWAY_TEMP_MAX_C + " REAL, "
                        + ThermoColumns.COLUMN_TARGET_AWAY_TEMP_MIN_F + " INTEGER, "
                        + ThermoColumns.COLUMN_TARGET_AWAY_TEMP_MIN_C + " REAL, "
                        + ThermoColumns.COLUMN_HVAC_MODE + " TEXT, "
                        + ThermoColumns.COLUMN_AMBIENT_TEMP_F + " INTEGER, "
                        + ThermoColumns.COLUMN_AMBIENT_TEMP_C + " REAL, "
                        + ThermoColumns.COLUMN_UPDATED + " INTEGER NOT NULL)"
        );

        /** Create the Protect table */
        db.execSQL("CREATE_TABLE " + NestDataContract.Protect.NEST_PROTECT + "("
                        + ProtectColumns.COLUMN_DEVICE_ID + " TEXT NOT NULL, "
                        + ProtectColumns.COLUMN_LOCALE + " TEXT NOT NULL, "
                        + ProtectColumns.COLUMN_SOFTWARE_VERSION + " TEXT, "
                        + ProtectColumns.COLUMN_STRUCTURE_ID + " INTEGER NOT NULL, "
                        + ProtectColumns.COLUMN_NAME + " TEXT, "
                        + ProtectColumns.COLUMN_LONG_NAME + " TEXT, "
                        + ProtectColumns.COLUMN_SOFTWARE_VERSION + " TEXT, "
                        + ProtectColumns.COLUMN_LAST_CONNECTION + " INTEGER, "
                        + ProtectColumns.COLUMN_IS_ONLINE + " BOOLEAN, "
                        + ProtectColumns.COLUMN_BATTERY_HEALTH + " TEXT, "
                        + ProtectColumns.COLUMN_CO_ALARM_STATE + " TEXT, "
                        + ProtectColumns.COLUMN_CO_SMOKE_STATE + " TEXT, "
                        + ProtectColumns.COLUMN_UI_COLOR_STATE + " TEXT, "
                        + ProtectColumns.COLUMN_UPDATED + " INTEGER NOT NULL)"
        );


    }

    //TODO implement the database upgrade code
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }





}
