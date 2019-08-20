package com.tkdev.ironmanstash;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tkdev.ironmanstash.infinity_stones.stones.InfinityFragment;
import com.tkdev.ironmanstash.infinity_stones.details.SingleStoneCV;
import com.tkdev.ironmanstash.infinity_stones.database.StonesDbHelper;


public class MainActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    StonesDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        dbHelper = new StonesDbHelper(this);
//        sqLiteDatabase = dbHelper.getWritableDatabase();
//
//        dbHelper.updateVisibility(sqLiteDatabase,POWER_STONE);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_container, new InfinityFragment(), "frag" )
                .addToBackStack("frag")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

    }

}
