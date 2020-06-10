package com.tkdev.ironmanstash._LEGACY_infinity_stones

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.tkdev.ironmanstash.R


class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, com.tkdev.ironmanstash.ui.InfinityFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit()
        }
    }
