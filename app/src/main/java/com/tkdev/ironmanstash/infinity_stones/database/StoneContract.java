package com.tkdev.ironmanstash.infinity_stones.database;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class StoneContract {


    public static final String DETAIL_TABLE = "details";
    public static final String IF_TABLE = "infinity_stones";

    public static final class DetailStoneEntry implements BaseColumns {
        public static final String COLUMN_DETAIL_NAME = "name";
        public static final String COLUMN_DETAIL_COLOR = "color";
        public static final String COLUMN_DETAIL_QUEST = "quest";
        public static final String COLUMN_DETAIL_PASSWORD = "password";
    }

    public static final class InfinityStonesEntry implements BaseColumns {
        public static final String COLUMN_STONE_NAME = "name";
        public static final String COLUMN_STONE_IMAGE = "image_resource";
        public static final String COLUMN_STONE_VISIBILITY = "visibility";

    }


}
