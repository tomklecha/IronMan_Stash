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

    static final int POWER_STONE_COLOR = R.color.PowerStone;
    static final int TIME_STONE_COLOR = R.color.TimeStone;
    static final int SOUL_STONE_COLOR = R.color.SoulStone;
    static final int REALITY_STONE_COLOR = R.color.RealityStone;
    static final int MIND_STONE_COLOR = R.color.MindStone;
    static final int SPACE_STONE_COLOR = R.color.SpaceStone;

    static final String POWER_STONE_PASSWORD = "powerpass";
    static final String TIME_STONE_PASSWORD = "timepass";
    static final String SOUL_STONE_PASSWORD = "soulpass";
    static final String REALITY_STONE_PASSWORD = "realitypass";
    static final String MIND_STONE_PASSWORD = "mindpass";
    static final String SPACE_STONE_PASSWORD = "spacepass";

    static final String POWER_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR POWER STONE";
    static final String TIME_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR TIME STONE";
    static final String SOUL_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR SOUL STONE";
    static final String REALITY_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR REALITY STONE";
    static final String MIND_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR MIND STONE";
    static final String SPACE_STONE_QUEST = "HERE IS THE MIGHTY QUEST FOR SPACE STONE";

    static final int POWER_STONE_IMAGE = android.R.drawable.ic_lock_lock;
    static final int TIME_STONE_IMAGE = android.R.drawable.ic_menu_report_image;
    static final int SOUL_STONE_IMAGE = android.R.drawable.sym_call_missed;
    static final int REALITY_STONE_IMAGE = android.R.drawable.arrow_down_float;
    static final int MIND_STONE_IMAGE = android.R.drawable.arrow_up_float;
    static final int SPACE_STONE_IMAGE = android.R.drawable.dialog_frame;

    public static final String DETAIL_TABLE = "details";

    static final class DetailStoneEntry implements BaseColumns {

        static final String COLUMN_DETAIL_ID = "_id";
        static final String COLUMN_DETAIL_NAME = "name";
        static final String COLUMN_DETAIL_COLOR = "color";
        static final String COLUMN_DETAIL_QUEST = "quest";
        static final String COLUMN_DETAIL_PASSWORD = "password";
    }


    public static final String IF_TABLE = "infinity_stones";

    static final class InfinityStonesEntry implements BaseColumns {

        static final String COLUMN_STONE_ID = "_id";
        static final String COLUMN_STONE_NAME = "name";
        static final String COLUMN_STONE_IMAGE = "image_resource";
        static final String COLUMN_STONE_VISIBILITY = "visibility";

    }


}
