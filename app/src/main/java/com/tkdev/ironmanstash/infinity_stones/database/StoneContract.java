package com.tkdev.ironmanstash.infinity_stones.database;

import android.provider.BaseColumns;

public class StoneContract {

    public static final String STONE_TABLE = "stones";

    public static final class StoneEntry implements BaseColumns {
        public static final String COLUMN_STONE_NAME = "name";
        public static final String COLUMN_STONE_COLOR = "color";
        public static final String COLUMN_STONE_QUEST = "quest";
        public static final String COLUMN_STONE_PASSWORD = "color";
    }
}
