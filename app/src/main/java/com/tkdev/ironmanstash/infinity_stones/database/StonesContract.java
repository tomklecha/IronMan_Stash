package com.tkdev.ironmanstash.infinity_stones.database;

import android.provider.BaseColumns;

import com.tkdev.ironmanstash.R;

public class StonesContract {

    static final String POWER_STONE = "Power stone";
    static final String TIME_STONE = "Time stone";
    static final String SOUL_STONE = "Soul stone";
    static final String REALITY_STONE = "Reality stone";
    static final String MIND_STONE = "Mind stone";
    static final String SPACE_STONE = "Space stone";

    static final int POWER_STONE_COLOR = R.color.powerStoneColor;
    static final int TIME_STONE_COLOR = R.color.timeStoneColor;
    static final int SOUL_STONE_COLOR = R.color.soulStoneColor;
    static final int REALITY_STONE_COLOR = R.color.realityStoneColor;
    static final int MIND_STONE_COLOR = R.color.mindStoneColor;
    static final int SPACE_STONE_COLOR = R.color.spaceStoneColor;

    static final int POWER_STONE_PASSWORD = R.string.power_stone_password;
    static final int TIME_STONE_PASSWORD = R.string.time_stone_password;
    static final int SOUL_STONE_PASSWORD = R.string.soul_stone_password;
    static final int REALITY_STONE_PASSWORD = R.string.reality_stone_password;
    static final int MIND_STONE_PASSWORD = R.string.mind_stone_password;
    static final int SPACE_STONE_PASSWORD = R.string.space_stone_password;

    static final int POWER_STONE_QUEST = R.string.power_stone_quest;
    static final int TIME_STONE_QUEST = R.string.time_stone_quest;
    static final int SOUL_STONE_QUEST = R.string.soul_stone_quest;
    static final int REALITY_STONE_QUEST = R.string.reality_stone_quest;
    static final int MIND_STONE_QUEST = R.string.mind_stone_quest;
    static final int SPACE_STONE_QUEST = R.string.space_stone_quest;

    static final int POWER_STONE_IMAGE = R.drawable.power_stone;
    static final int TIME_STONE_IMAGE = R.drawable.time_stone;
    static final int SOUL_STONE_IMAGE = R.drawable.soul_stone;
    static final int REALITY_STONE_IMAGE = R.drawable.reality_stone;
    static final int MIND_STONE_IMAGE = R.drawable.mind_stone;
    static final int SPACE_STONE_IMAGE = R.drawable.space_stone;

    public static final String DETAIL_TABLE = "details";

    public static final class DetailStoneEntry implements BaseColumns {

        public static final String COLUMN_DETAIL_ID = "_id";
        public static final String COLUMN_DETAIL_NAME = "name";
        public static final String COLUMN_DETAIL_COLOR = "color";
        public static final String COLUMN_DETAIL_QUEST = "quest";
        public static final String COLUMN_DETAIL_PASSWORD = "password";
    }


    public static final String IF_TABLE = "infinity_stones";

    public static final class InfinityStonesEntry implements BaseColumns {

        public static final String COLUMN_STONE_ID = "_id";
        public static final String COLUMN_STONE_NAME = "name";
        public static final String COLUMN_STONE_IMAGE = "image_resource";
        public static final String COLUMN_STONE_VISIBILITY = "visibility";

    }


}
