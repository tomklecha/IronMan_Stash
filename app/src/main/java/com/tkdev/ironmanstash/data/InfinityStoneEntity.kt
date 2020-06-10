package com.tkdev.ironmanstash.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ise")
data class InfinityStoneEntity(
        @ColumnInfo(name = "name")
        val name: String,
        @ColumnInfo(name = "image")
        val image: Int,
        @ColumnInfo(name = "isVisible")
        val isVisible: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid: Long = 0
}