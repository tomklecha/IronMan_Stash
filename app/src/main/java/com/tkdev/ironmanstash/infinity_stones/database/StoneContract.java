package com.tkdev.ironmanstash.infinity_stones.database;

import android.provider.BaseColumns;

import com.tkdev.ironmanstash.R;

public class StoneContract {

    public static final String POWER_STONE = "Power stone";
    public static final String TIME_STONE = "Time stone";
    public static final String SOUL_STONE = "Soul stone";
    public static final String REALITY_STONE = "Reality stone";
    public static final String MIND_STONE = "Mind stone";
    public static final String SPACE_STONE = "Space stone";

    public static final int POWER_STONE_COLOR = R.color.PowerStone;
    public static final int TIME_STONE_COLOR = R.color.TimeStone;
    public static final int SOUL_STONE_COLOR = R.color.SoulStone;
    public static final int REALITY_STONE_COLOR = R.color.RealityStone;
    public static final int MIND_STONE_COLOR = R.color.MindStone;
    public static final int SPACE_STONE_COLOR = R.color.SpaceStone;

    public static final String POWER_STONE_PASSWORD = "powerpass";
    public static final String TIME_STONE_PASSWORD = "timepass";
    public static final String SOUL_STONE_PASSWORD = "soulpass";
    public static final String REALITY_STONE_PASSWORD = "realitypass";
    public static final String MIND_STONE_PASSWORD = "mindpass";
    public static final String SPACE_STONE_PASSWORD = "spacepass";

    public static final String POWER_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR POWER STONE";
    public static final String TIME_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR TIME STONE";
    public static final String SOUL_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR SOUL STONE";
    public static final String REALITY_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR REALITY STONE";
    public static final String MIND_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR MIND STONE";
    public static final String SPACE_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR SPACE STONE";

    public static final int POWER_STONE_IMAGE = android.R.drawable.ic_lock_lock;
    public static final int TIME_STONE_IMAGE = android.R.drawable.ic_menu_report_image;
    public static final int SOUL_STONE_IMAGE = android.R.drawable.sym_call_missed;
    public static final int REALITY_STONE_IMAGE = android.R.drawable.arrow_down_float;
    public static final int MIND_STONE_IMAGE = android.R.drawable.arrow_up_float;
    public static final int SPACE_STONE_IMAGE = android.R.drawable.dialog_frame;

    public static final String DETAIL_TABLE = "details";

    public static final class DetailStoneEntry implements BaseColumns {

        public static final String COLUMN_DETAIL_NAME = "name";
        public static final String COLUMN_DETAIL_COLOR = "color";
        public static final String COLUMN_DETAIL_QUEST = "quest";
        public static final String COLUMN_DETAIL_PASSWORD = "password";
    }


    public static final String IF_TABLE = "infinity_stones";

    public static final class InfinityStonesEntry implements BaseColumns {

        public static final String COLUMN_STONE_NAME = "name";
        public static final String COLUMN_STONE_IMAGE = "image_resource";
        public static final String COLUMN_STONE_VISIBILITY = "visibility";

    }


}
