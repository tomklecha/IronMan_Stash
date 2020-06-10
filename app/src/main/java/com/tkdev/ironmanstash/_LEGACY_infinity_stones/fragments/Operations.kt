package com.tkdev.ironmanstash._LEGACY_infinity_stones.fragments

import com.tkdev.ironmanstash._LEGACY_infinity_stones.fragments.allstones.InfinityStone
import com.tkdev.ironmanstash._LEGACY_infinity_stones.fragments.details.SingleStone
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.tkdev.ironmanstash._LEGACY_infinity_stones.database.StonesContract
import com.tkdev.ironmanstash._LEGACY_infinity_stones.database.StonesContract.DetailStoneEntry
import com.tkdev.ironmanstash._LEGACY_infinity_stones.database.StonesContract.InfinityStonesEntry
import com.tkdev.ironmanstash._LEGACY_infinity_stones.database.StonesDbHelper
import java.util.*

class Operations internal constructor(private val context: Context) {
    private lateinit var operations: Operations

    private var database: SQLiteDatabase = StonesDbHelper(context).writableDatabase

    private fun queryStones(tableName: String): OperationsWrapper {
        val cursor = database.query(tableName, null, null, null, null, null, null, null)
        return OperationsWrapper(cursor)
    }

    fun updateStones(name: String) {
        var cursorWrapper = queryStones(StonesContract.IF_TABLE)
        try {
            cursorWrapper.moveToFirst()
            while (!cursorWrapper.isAfterLast) {
                if (cursorWrapper.infinityStoneName == name) {
                    updateDbVisibility(name)
                    break
                }
                cursorWrapper.moveToNext()
            }
        } finally {
            cursorWrapper.close()
        }
        cursorWrapper = queryStones(StonesContract.DETAIL_TABLE)
        try {
            cursorWrapper.moveToFirst()
            while (!cursorWrapper.isAfterLast) {
                if (cursorWrapper.detailStoneName == name) {
                    deleteDbStone(name)
                    break
                }
                cursorWrapper.moveToNext()
            }
        } finally {
            cursorWrapper.close()
        }
    }

     val infinityStoneList: List<Any>
        get() {
            val list: MutableList<InfinityStone> = ArrayList<InfinityStone>()
            val cursorWrapper = queryStones(StonesContract.IF_TABLE)
            cursorWrapper.use { cursorWrapper ->
                cursorWrapper.moveToFirst()
                while (!cursorWrapper.isAfterLast) {
                    list.add(cursorWrapper.infinityStoneList)
                    cursorWrapper.moveToNext()
                }
            }
            return list
        }

     val detailStoneList: List<Any>
        get() {
            val list: MutableList<SingleStone> = ArrayList<SingleStone>()
            val cursorWrapper = queryStones(StonesContract.DETAIL_TABLE)
            cursorWrapper.use { cursorWrapper ->
                cursorWrapper.moveToFirst()
                while (!cursorWrapper.isAfterLast) {
                    list.add(cursorWrapper.detailStoneList)
                    cursorWrapper.moveToNext()
                }
            }
            return list
        }

    private fun updateDbVisibility(name: String) {
        database.execSQL("UPDATE " + StonesContract.IF_TABLE + " SET " +
                InfinityStonesEntry.COLUMN_STONE_VISIBILITY + " = 0 WHERE "
                + InfinityStonesEntry.COLUMN_STONE_NAME + " = \"" + name + "\"")
    }

    private fun deleteDbStone(name: String) {
        database.execSQL("DELETE FROM " + StonesContract.DETAIL_TABLE + " WHERE "
                + DetailStoneEntry.COLUMN_DETAIL_NAME + " = \"" + name + "\"")
    }

    fun gauntletVisibility(): Boolean {
        return detailStoneList.isEmpty()
    }

}