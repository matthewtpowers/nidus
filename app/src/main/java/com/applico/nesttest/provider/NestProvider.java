package com.applico.nesttest.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.applico.nesttest.provider.NestDataContract.ETA;
import com.applico.nesttest.provider.NestDataContract.Structures;
import com.applico.nesttest.provider.NestDataContract.Thermostats;
import com.applico.nesttest.provider.NestDataContract.Protect;


/**
 * Created by matthewpowers on 8/4/14.
 */
public class NestProvider extends ContentProvider{

    private static final String LOG_TAG = NestProvider.class.getSimpleName();

    private static final UriMatcher mUriMatcher = buildUriMatcher();

    private NestDatabase mDatabaseHelper;

    //URI Values for the content provider
    private static final int ESTIMATED_TIME_ARRIVAL = 100;
    private static final int STRUCTURES = 101;
    private static final int THERMO = 102;
    private static final int PROTECT = 103;


    @Override
    public boolean onCreate() {
        Log.e(LOG_TAG,"On Create Nest Provider");
        mDatabaseHelper = new NestDatabase(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                        String sortOrder) {
        SQLiteDatabase db = mDatabaseHelper.getReadableDatabase();
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(matchUri(uri));
        Cursor cursor = builder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        SQLiteDatabase db = mDatabaseHelper.getWritableDatabase();
        //long id = db.insertOrThrow(matchUri(uri),null, contentValues);
        int match = mUriMatcher.match(uri);
        long id = 0;
        switch(match)
        {
            case ESTIMATED_TIME_ARRIVAL:
                id = db.insertOrThrow(ETA.NEST_ETA,null,contentValues);
                return Uri.parse(uri + "/" + id);
            case STRUCTURES:
                id = db.insertOrThrow(Structures.NEST_STRUCTURES,null,contentValues);
                return Uri.parse(uri + "/" + id);
            case THERMO:
                id = db.insertOrThrow(Thermostats.NEST_THERMO,null,contentValues);
                return Uri.parse(uri + "/" + id);
            case PROTECT:
                id = db.insertOrThrow(Protect.NEST_PROTECT,null,contentValues);
                return Uri.parse(uri + "/" + id);
            default: {
                throw new UnsupportedOperationException("Unknown URI: " + uri.getPath());
            }

        }
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String selection,
                      String[] selectionArgs) {
        return 0;
    }

    private static UriMatcher buildUriMatcher()
    {
        UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        matcher.addURI(NestDataContract.CONTENT_AUTHORITY, ETA.NEST_ETA, ESTIMATED_TIME_ARRIVAL);
        matcher.addURI(NestDataContract.CONTENT_AUTHORITY, Structures.NEST_STRUCTURES,STRUCTURES);
        matcher.addURI(NestDataContract.CONTENT_AUTHORITY, Thermostats.NEST_THERMO,THERMO);
        matcher.addURI(NestDataContract.CONTENT_AUTHORITY, Protect.NEST_PROTECT, PROTECT);
        return matcher;
    }

    private static String matchUri(Uri uri)
    {
        return "something";
    }
}
