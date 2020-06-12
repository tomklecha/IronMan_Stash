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
        val isVisible: Boolean,
        @ColumnInfo(name = "color")
        val color: Int,
        @ColumnInfo(name = "quest")
        val quest: Int,
        @ColumnInfo(name = "password")
        val password: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid: Long = 0
}