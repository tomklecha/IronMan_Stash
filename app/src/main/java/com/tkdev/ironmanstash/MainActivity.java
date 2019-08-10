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
                .replace(R.id.activity_container, new InfinityFragment() )
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.menu_gather_stones){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.infinity_fragment_layout, new SingleStoneCV(),"INFINITY")
                    .addToBackStack("INFINITY")
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();

        }

        return super.onOptionsItemSelected(item);
    }

}
