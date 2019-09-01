package com.tkdev.ironmanstash;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tkdev.ironmanstash.infinity_stones.fragments.Operations;
import com.tkdev.ironmanstash.infinity_stones.fragments.allstones.InfinityFragment;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Operations operations = Operations.get(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_container, new InfinityFragment() )
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();

    }

}
