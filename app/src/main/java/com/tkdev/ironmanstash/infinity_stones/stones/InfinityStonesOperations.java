package com.tkdev.ironmanstash.infinity_stones.stones;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.tkdev.ironmanstash.infinity_stones.database.StonesDbHelper;

import java.util.ArrayList;
import java.util.List;

import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.DETAIL_TABLE;
import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.DetailStoneEntry.COLUMN_DETAIL_NAME;
import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.IF_TABLE;
import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.InfinityStonesEntry.COLUMN_STONE_NAME;
import static com.tkdev.ironmanstash.infinity_stones.database.StonesContract.InfinityStonesEntry.COLUMN_STONE_VISIBILITY;

public class InfinityStonesOperations {

    private static InfinityStonesOperations operations;
    private List<InfinityStone> infinityStonesList;
    private SQLiteDatabase database;
    private Context context;

    public static InfinityStonesOperations get(Context context) {
        if (operations == null) {
            operations = new InfinityStonesOperations(context);
        }
        return operations;
    }

    private InfinityStonesOperations(Context context) {
        this.context = context;
        this.database = new StonesDbHelper(context).getWritableDatabase();
        this.infinityStonesList = new ArrayList<>();
    }



    private InfinityCursorWrapper queryStones(String tableName) {

      Cursor cursor = database.query(tableName, null, null, null, null, null, null, null);

        return new InfinityCursorWrapper(cursor);
    }

    public void updateStones(String name){

        InfinityCursorWrapper cursorWrapper = queryStones(IF_TABLE);

        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                if(cursorWrapper.getInfinityStoneName().equals(name)) {
                    updateDbVisibility(name);
//                    Toast.makeText(get(context).context, "done", Toast.LENGTH_SHORT).show();
                    break;
                }

                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }

        cursorWrapper = queryStones(DETAIL_TABLE);

        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                if(cursorWrapper.getDetailStoneName().equals(name)) {
                    deleteDbStone(name);
//                    Toast.makeText(get(context).context, "done detail", Toast.LENGTH_SHORT).show();
                    break;
                }

                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }

    }


    public List<InfinityStone> getInfinityStoneList() {
        List<InfinityStone> list =  new ArrayList<>();

        InfinityCursorWrapper cursorWrapper = queryStones(IF_TABLE);


        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                list.add(cursorWrapper.getInfinityStoneList());
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }
        return list;

    }


    public List<SingleStone> getDetailStoneList() {
        List<SingleStone> list =  new ArrayList<>();

        InfinityCursorWrapper cursorWrapper = queryStones(DETAIL_TABLE);


//        TODO all getters for each element to list
        try{
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()){
                list.add(cursorWrapper.getDetailStoneList());
                cursorWrapper.moveToNext();
            }
        }finally {
            cursorWrapper.close();
        }
        return list;

    }

    private void updateDbVisibility(String name){
        database.execSQL("UPDATE " + IF_TABLE + " SET " +
                COLUMN_STONE_VISIBILITY + " = 0 WHERE "
                + COLUMN_STONE_NAME + " = \"" + name + "\"");
    }

    private void deleteDbStone(String name){
        database.execSQL("DELETE FROM " + DETAIL_TABLE + " WHERE "
                + COLUMN_DETAIL_NAME + " = \"" + name + "\"");
    }


}
