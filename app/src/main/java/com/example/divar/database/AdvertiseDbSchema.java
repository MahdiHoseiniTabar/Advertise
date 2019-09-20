package com.example.divar.database;

public class AdvertiseDbSchema {
    public static final String NAME = "AdvertiseDb";
    public static final int VERSION = 1;
    public class Advertise{
        public static final String NAME = "AdvertiseTable";
        public class AdvertiseColumn {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DESCRIPTION = "description";
            public static final String ADDRESS = "address";
            public static final String PHONE_NUMBER = "phoneNumber";
            public static final String IS_SPECIAL = "special";
        }
    }
}
