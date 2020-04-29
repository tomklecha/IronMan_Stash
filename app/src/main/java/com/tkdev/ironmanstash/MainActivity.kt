package com.tkdev.ironmanstash

import InfinityFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.tkdev.ironmanstash.infinity_stones.fragments.Operations
import com.tkdev.ironmanstash.infinity_stones.fragments.StarkFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val operations = Operations(this)
        if (operations.detailStoneList.isEmpty()) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, StarkFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit()
        } else {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, InfinityFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit()
        }
    }
}