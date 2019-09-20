package com.example.divar.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.divar.database.AdvertiseDbSchema.*;

public class AdvertiseHelper extends SQLiteOpenHelper {
    public AdvertiseHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " + AdvertiseDbSchema.Advertise.NAME + "(" +
                "_id integer primary key autoincrement, "
                + AdvertiseDbSchema.Advertise.AdvertiseColumn.UUID + ", "
                + AdvertiseDbSchema.Advertise.AdvertiseColumn.TITLE + ", "
                + AdvertiseDbSchema.Advertise.AdvertiseColumn.DESCRIPTION + ", "
                + AdvertiseDbSchema.Advertise.AdvertiseColumn.PHONE_NUMBER + ", "
                + AdvertiseDbSchema.Advertise.AdvertiseColumn.ADDRESS + ", "
                + AdvertiseDbSchema.Advertise.AdvertiseColumn.IS_SPECIAL + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
