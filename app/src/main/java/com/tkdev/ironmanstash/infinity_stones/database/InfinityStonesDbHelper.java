package com.tkdev.ironmanstash.infinity_stones.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import com.tkdev.ironmanstash.infinity_stones.InfinityStones;

import static com.tkdev.ironmanstash.infinity_stones.database.StoneContract.DETAIL_TABLE;
import static com.tkdev.ironmanstash.infinity_stones.database.StoneContract.DetailStoneEntry.COLUMN_DETAIL_COLOR;
import static com.tkdev.ironmanstash.infinity_stones.database.StoneContract.DetailStoneEntry.COLUMN_DETAIL_NAME;
import static com.tkdev.ironmanstash.infinity_stones.database.StoneContract.DetailStoneEntry.COLUMN_DETAIL_PASSWORD;
import static com.tkdev.ironmanstash.infinity_stones.database.StoneContract.DetailStoneEntry.COLUMN_DETAIL_QUEST;
import static com.tkdev.ironmanstash.infinity_stones.database.StoneContract.IF_TABLE;
import static com.tkdev.ironmanstash.infinity_stones.database.StoneContract.InfinityStonesEntry.COLUMN_STONE_IMAGE;
import static com.tkdev.ironmanstash.infinity_stones.database.StoneContract.InfinityStonesEntry.COLUMN_STONE_NAME;
import static com.tkdev.ironmanstash.infinity_stones.database.StoneContract.InfinityStonesEntry.COLUMN_STONE_VISIBILITY;

public class InfinityStonesDbHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;
    private static final String INFINITY_STONES_DB = "infinity_stones.db";
    private static final String CREATE_TABLE = "CREATE TABLE ";
    private static final String IF_NOT_EXISTS = " IF NOT EXISTS ";
    private static final int STONE_INVISIBLE = View.INVISIBLE;
    private static final int STONE_VISIBLE = View.VISIBLE;

    public InfinityStonesDbHelper(Context context) {
        super(context, INFINITY_STONES_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE + IF_NOT_EXISTS + DETAIL_TABLE +
                "(" +
                COLUMN_DETAIL_NAME + " TEXT NOT NULL, " +
                COLUMN_DETAIL_COLOR + " INTEGER NOT NULL, " +
                COLUMN_DETAIL_QUEST + " TEXT NOT NULL, " +
                COLUMN_DETAIL_PASSWORD + " TEXT NOT NULL" +
                ")");


        db.execSQL(CREATE_TABLE + IF_NOT_EXISTS + IF_TABLE +
                "(" +
                COLUMN_STONE_NAME + " TEXT NOT NUll, " +
                COLUMN_STONE_IMAGE + " INTEGER NOT NULL, " +
                COLUMN_STONE_VISIBILITY + " NUMERIC DEFAULT 0" +
                ")");

        insertStones(db,"Power Stone", android.R.drawable.ic_lock_lock, STONE_INVISIBLE);
        insertStones(db,"Time Stone",android.R.drawable.ic_menu_report_image, STONE_VISIBLE);
        insertStones(db,"Soul Stone",android.R.drawable.sym_call_missed, STONE_INVISIBLE);
        insertStones(db,"Reality Stone",android.R.drawable.arrow_down_float,  STONE_INVISIBLE);
        insertStones(db,"Mind Stone",android.R.drawable.arrow_up_float,  STONE_INVISIBLE);
        insertStones(db,"Space Stone",android.R.drawable.dialog_frame,  STONE_INVISIBLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void insertDetail(SQLiteDatabase db, String name, int color, String quest, String password ){
        ContentValues values = new ContentValues();
        values.put(COLUMN_DETAIL_NAME, name);
        values.put(COLUMN_DETAIL_COLOR, color);
        values.put(COLUMN_DETAIL_QUEST, quest);
        values.put(COLUMN_DETAIL_PASSWORD, password);

        db.insert(DETAIL_TABLE, null, values);
    }

    private void insertStones(SQLiteDatabase db, String name, int image, int isVisible ){
        ContentValues values = new ContentValues();
        values.put(COLUMN_STONE_NAME, name);
        values.put(COLUMN_STONE_IMAGE, image);
        values.put(COLUMN_STONE_VISIBILITY, isVisible);

        db.insert(IF_TABLE, null, values);
    }

    public void updateVisibility(SQLiteDatabase db, String stoneName){

        db.execSQL("UPDATE " + IF_TABLE + " SET " +
                COLUMN_STONE_VISIBILITY + " = 0 WHERE "
                + COLUMN_STONE_NAME + " = \""+ stoneName  + "\"");

        

    }
}
