package com.tkdev.ironmanstash.infinity_stones.stones;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.tkdev.ironmanstash.infinity_stones.database.StonesDbHelper;

import java.util.ArrayList;
import java.util.List;

public class InfinityStonesOperations {

    private static InfinityStonesOperations operations;
    private List<InfinityStones> infinityStonesList;
    private SQLiteDatabase database;
    private Context context;

    public static InfinityStonesOperations get(Context context){
        if(operations==null){
           operations = new InfinityStonesOperations(context);
        }
        return operations;
    }

    private InfinityStonesOperations(Context context){
        this.context = context;
        this.database = new StonesDbHelper(context).getWritableDatabase();
        this.infinityStonesList = new ArrayList<>();
    }

    private Cursor queryStones(){

        Cursor cursor = null;

//        TODO cursor
        return cursor;
    }

    public List<InfinityStones> getInfinityStoneList(){
        return new ArrayList<>();
    }
}
