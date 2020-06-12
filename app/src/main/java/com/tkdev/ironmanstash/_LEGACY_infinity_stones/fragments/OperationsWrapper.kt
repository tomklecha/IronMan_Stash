package com.tkdev.ironmanstash._LEGACY_infinity_stones.fragments

import com.tkdev.ironmanstash._LEGACY_infinity_stones.fragments.allstones.InfinityStone
import com.tkdev.ironmanstash._LEGACY_infinity_stones.fragments.details.SingleStone
import android.database.Cursor
import android.database.CursorWrapper
import com.tkdev.ironmanstash._LEGACY_infinity_stones.database.StonesContract

class OperationsWrapper(cursor: Cursor?) : CursorWrapper(cursor) {
   internal val infinityStoneList: InfinityStone
         get() {
            val uuidString = getString(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_ID))
            val name = getString(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_NAME))
            val imageId = getInt(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_IMAGE))
            val isVisible = getInt(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_VISIBILITY))
            return InfinityStone(imageId,name, isVisible)
        }

    //        TODO stone getter setter from database query 282 page
    internal val detailStoneList: SingleStone
         get() {
            val uuidString = getString(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_ID))
            val name = getString(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_NAME))
            val color = getInt(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_COLOR))
            val quest = getInt(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_QUEST))
            val password = getInt(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_PASSWORD))

             return SingleStone(name, color, quest, password)
        }

    val infinityStoneName: String
         get() = getString(getColumnIndex(StonesContract.InfinityStonesEntry.COLUMN_STONE_NAME))

    val detailStoneName: String
         get() = getString(getColumnIndex(StonesContract.DetailStoneEntry.COLUMN_DETAIL_NAME))
}