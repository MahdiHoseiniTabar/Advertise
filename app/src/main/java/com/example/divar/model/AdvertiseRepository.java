package com.example.divar.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.divar.database.AdvertiseCursorWrapper;
import com.example.divar.database.AdvertiseDbSchema;
import com.example.divar.database.AdvertiseHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AdvertiseRepository {
    private static AdvertiseRepository instance;
    private static SQLiteDatabase database;
    private static List<Advertise> advertiseList;
    private static List<Advertise> advertiseSpecialList;


    public static AdvertiseRepository getInstance(Context context) {
        if (instance == null)
            instance = new AdvertiseRepository(context);
        return instance;
    }

    private AdvertiseRepository(Context context) {
        database = new AdvertiseHelper(context).getWritableDatabase();
    }

    public void insertAdvertise(Advertise advertise) {
        advertiseList.add(advertise);
        if (advertise.isSpecial())
            advertiseSpecialList.add(advertise);
        database.insert(AdvertiseDbSchema.Advertise.NAME, null, getContentValues(advertise));
    }

    private ContentValues getContentValues(Advertise advertise) {
        ContentValues values = new ContentValues();
        values.put(AdvertiseDbSchema.Advertise.AdvertiseColumn.UUID, advertise.getUuid().toString());
        values.put(AdvertiseDbSchema.Advertise.AdvertiseColumn.TITLE, advertise.getTitle());
        values.put(AdvertiseDbSchema.Advertise.AdvertiseColumn.DESCRIPTION, advertise.getDescription());
        values.put(AdvertiseDbSchema.Advertise.AdvertiseColumn.ADDRESS, advertise.getAddress());
        values.put(AdvertiseDbSchema.Advertise.AdvertiseColumn.PHONE_NUMBER, advertise.getPhoneNumber());
        values.put(AdvertiseDbSchema.Advertise.AdvertiseColumn.IS_SPECIAL, advertise.isSpecial() ? 1 : 0);
        return values;
    }

    public List<Advertise> getAdvertiseList() {
        advertiseList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * from " + AdvertiseDbSchema.Advertise.NAME, new String[]{});
        AdvertiseCursorWrapper cursorWrapper = new AdvertiseCursorWrapper(cursor);
        if (cursorWrapper.getCount() == 0)
            return advertiseList;

        cursorWrapper.moveToFirst();
        try {
            while (!cursorWrapper.isAfterLast()) {
                advertiseList.add(cursorWrapper.getAdvertise());
                cursorWrapper.moveToNext();
            }
        } finally {
            cursorWrapper.close();
        }
        Log.i("hiiiiii", "getAdvertiseList: " +advertiseList.size());
        return advertiseList;
    }

    public Advertise getAdvertise(UUID uuid) {
        Advertise advertise = null;
        Cursor cursor = database.query(AdvertiseDbSchema.Advertise.NAME,
                null,
                AdvertiseDbSchema.Advertise.AdvertiseColumn.UUID + " = ? ",
                new String[]{uuid.toString()},
                null,
                null,
                null);
        AdvertiseCursorWrapper cursorWrapper = new AdvertiseCursorWrapper(cursor);
        if (cursorWrapper.getCount() == 0)
            return null;
        cursorWrapper.moveToFirst();
        try {
            while (!cursorWrapper.isAfterLast()) {
                advertise = cursorWrapper.getAdvertise();
                cursorWrapper.moveToNext();
            }
        } finally {
            cursorWrapper.close();
        }
        return advertise;
    }

    public List<Advertise> getAdvertiseSpecialList(){
        advertiseSpecialList = new ArrayList<>();
        for (int i = 0; i <advertiseList.size() ; i++) {
            if (advertiseList.get(i).isSpecial())
                advertiseSpecialList.add(advertiseList.get(i));
        }
        return advertiseSpecialList;
    }
}
