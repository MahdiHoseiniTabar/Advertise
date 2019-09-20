package com.example.divar.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.divar.model.Advertise;

import java.util.UUID;

public class AdvertiseCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public AdvertiseCursorWrapper(Cursor cursor) {
        super(cursor);
    }



    public Advertise getAdvertise(){
        UUID uuid = UUID.fromString(getString(getColumnIndex(AdvertiseDbSchema.Advertise.AdvertiseColumn.UUID)));
        String title = getString(getColumnIndex(AdvertiseDbSchema.Advertise.AdvertiseColumn.TITLE));
        String description = getString(getColumnIndex(AdvertiseDbSchema.Advertise.AdvertiseColumn.DESCRIPTION));
        String address = getString(getColumnIndex(AdvertiseDbSchema.Advertise.AdvertiseColumn.ADDRESS));
        String phoneNumber = getString(getColumnIndex(AdvertiseDbSchema.Advertise.AdvertiseColumn.PHONE_NUMBER));
        boolean isSpecial = getInt(getColumnIndex(AdvertiseDbSchema.Advertise.AdvertiseColumn.IS_SPECIAL)) != 0;
        Advertise advertise = new Advertise(uuid,title,description,phoneNumber,address,isSpecial);
        return advertise;
    }
}
