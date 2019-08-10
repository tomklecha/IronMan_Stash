package com.tkdev.ironmanstash.infinity_stones.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.*;
import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.DetailStoneEntry.*;
import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.InfinityStonesEntry.*;


public class StonesDbHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 2;
    private static final String INFINITY_STONES_DB = "infinity_stones.db";
    private static final String CREATE_TABLE = "CREATE TABLE ";
    private static final String IF_NOT_EXISTS = " IF NOT EXISTS ";
    private static final int STONE_INVISIBLE = View.INVISIBLE;
    private static final int STONE_VISIBLE = View.VISIBLE;

    public StonesDbHelper(Context context) {
        super(context, INFINITY_STONES_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE + IF_NOT_EXISTS + DETAIL_TABLE +
                "(" +
                COLUMN_DETAIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DETAIL_NAME + " TEXT NOT NULL, " +
                COLUMN_DETAIL_COLOR + " INTEGER NOT NULL, " +
                COLUMN_DETAIL_QUEST + " TEXT NOT NULL, " +
                COLUMN_DETAIL_PASSWORD + " TEXT NOT NULL" +
                ")");

        insertDetail(db, POWER_STONE, POWER_STONE_COLOR, POWER_STONE_QUEST, POWER_STONE_PASSWORD);
        insertDetail(db, TIME_STONE, TIME_STONE_COLOR, TIME_STONE_QUEST, TIME_STONE_PASSWORD);
        insertDetail(db, SOUL_STONE, SOUL_STONE_COLOR, SOUL_STONE_QUEST, SOUL_STONE_PASSWORD);
        insertDetail(db, REALITY_STONE, REALITY_STONE_COLOR, REALITY_STONE_QUEST, REALITY_STONE_PASSWORD);
        insertDetail(db, MIND_STONE, MIND_STONE_COLOR, MIND_STONE_QUEST, MIND_STONE_PASSWORD);
        insertDetail(db, SPACE_STONE, SPACE_STONE_COLOR, SPACE_STONE_QUEST, SPACE_STONE_PASSWORD);


        db.execSQL(CREATE_TABLE + IF_NOT_EXISTS + IF_TABLE +
                "(" +
                COLUMN_STONE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_STONE_NAME + " TEXT NOT NUll, " +
                COLUMN_STONE_IMAGE + " INTEGER NOT NULL, " +
                COLUMN_STONE_VISIBILITY + " NUMERIC DEFAULT 0" +
                ")");

        insertStones(db, POWER_STONE, POWER_STONE_IMAGE, STONE_INVISIBLE);
        insertStones(db, TIME_STONE, TIME_STONE_IMAGE, STONE_INVISIBLE);
        insertStones(db, SOUL_STONE, SOUL_STONE_IMAGE, STONE_INVISIBLE);
        insertStones(db, REALITY_STONE, REALITY_STONE_IMAGE, STONE_INVISIBLE);
        insertStones(db, MIND_STONE, MIND_STONE_IMAGE, STONE_INVISIBLE);
        insertStones(db, SPACE_STONE, SPACE_STONE_IMAGE, STONE_INVISIBLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void insertDetail(SQLiteDatabase db, String name, int color, String quest, String password) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_DETAIL_NAME, name);
        values.put(COLUMN_DETAIL_COLOR, color);
        values.put(COLUMN_DETAIL_QUEST, quest);
        values.put(COLUMN_DETAIL_PASSWORD, password);

        db.insert(DETAIL_TABLE, null, values);
    }

    private void insertStones(SQLiteDatabase db, String name, int image, int isVisible) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_STONE_NAME, name);
        values.put(COLUMN_STONE_IMAGE, image);
        values.put(COLUMN_STONE_VISIBILITY, isVisible);

        db.insert(IF_TABLE, null, values);
    }

    public void updateVisibility(SQLiteDatabase db, String stoneName) {

        db.execSQL("UPDATE " + IF_TABLE + " SET " +
                COLUMN_STONE_VISIBILITY + " = 0 WHERE "
                + COLUMN_STONE_NAME + " = \"" + stoneName + "\"");


    }
}
