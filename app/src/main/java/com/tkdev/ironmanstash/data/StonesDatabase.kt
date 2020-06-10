package com.tkdev.ironmanstash.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.tkdev.ironmanstash.utils.*
import java.util.concurrent.Executors

@Database(entities = [InfinityStoneEntity::class], version = 1)
abstract class StonesDatabase : RoomDatabase() {
    abstract fun dao(): InfinityStoneDao

    companion object {

        @Volatile
        private var INSTANCE: StonesDatabase? = null

        fun getDatabase(
                context: Context
        ): StonesDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        StonesDatabase::class.java,
                        "word_database"
                )
                        .addCallback(object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                Executors.newSingleThreadExecutor().execute {
                                    INSTANCE?.let {
                                        populateDatabase(it.dao())
                                    }
                                }
                            }
                        })
                        .build()
                INSTANCE = instance
                return instance
            }

        }

        fun populateDatabase(dao: InfinityStoneDao) {
            // Delete all content here.
            dao.deleteAll()

            // Add sample words.
            var stone = InfinityStoneEntity(POWER_STONE, POWER_STONE_IMAGE, false)
            dao.insert(stone)
            stone = InfinityStoneEntity(TIME_STONE, TIME_STONE_IMAGE, false)
            dao.insert(stone)
            stone = InfinityStoneEntity(REALITY_STONE, REALITY_STONE_IMAGE, false)
            dao.insert(stone)
            stone = InfinityStoneEntity(MIND_STONE, MIND_STONE_IMAGE, false)
            dao.insert(stone)
            stone = InfinityStoneEntity(SOUL_STONE, SOUL_STONE_IMAGE, false)
            dao.insert(stone)
            stone = InfinityStoneEntity(SPACE_STONE, SPACE_STONE_IMAGE, false)
            dao.insert(stone)



        }
    }
}