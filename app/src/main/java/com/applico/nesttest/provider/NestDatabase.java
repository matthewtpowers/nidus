package com.applico.nesttest.provider;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import com.applico.nesttest.R;
import com.applico.nesttest.model.NestStructure;
import com.applico.nesttest.provider.NestDataContract.StructuresColumns;

/**
 * Created by matthewpowers on 7/31/14.
 */
public class NestDatabase extends SQLiteOpenHelper {
    private static final String LOG_TAG = NestDatabase.class.getSimpleName();

    private final Context mContext;

    private static String DATABASE_NAME;
    private static String DATABASE_VERSION;

    /**
     * These are the database tables for the NEST devices
     */
    private interface NestDatabaseTables
    {


        public static final String NEST_ETA = "nest_eta";
        public static final String NEST_STRUCTURES = "nest_structures";
        public static final String NEST_THERMO = "nest_thermo";
        public static final String NEST_PROTECT = "nest_protect";
    }

    public NestDatabase(Context context)
    {
        super(context, "",null,1);
        mContext = context;
        DATABASE_NAME = context.getString(R.string.database_name);
        DATABASE_VERSION = context.getString(R.string.database_version_a);
    }


    //TODO still need to work through the best way to do the base columns
    @Override
    public void onCreate(SQLiteDatabase db) {

        /** Create the Structures Table */
        db.execSQL("CREATE_TABLE " + NestDatabaseTables.NEST_STRUCTURES + "("
                + StructuresColumns.COLUMN_STRUCTURE_ID + " TEXT NOT NULL,"
                + StructuresColumns.COLUMN_THERMOSTATS + " TEXT,"
                + StructuresColumns.COLUMN_PROTECTS + " TEXT,"
                + StructuresColumns.COLUMN_AWAY + " TEXT,"
                + StructuresColumns.COLUMN_USER_DEFINED_NAME + " TEXT,"
                + StructuresColumns.COLUMN_COUNTRY_CODE + ""
                + StructuresColumns.COLUMN_NAME_PEAK_PERIOD_START_TIME + " Integer,"
                + StructuresColumns.COLUMN_NAME_PEAK_PERIOD_END_TIME + " Integer,"
                + StructuresColumns.COLUMN_TIME_ZONE + " TEXT,"
                + StructuresColumns.COLUMN_UPDATED+ " INTEGER NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
