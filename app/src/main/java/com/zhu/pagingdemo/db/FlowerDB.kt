package com.zhu.pagingdemo.db

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.zhu.pagingdemo.utils.runLongTask

/**
 * @author Zhu
 * @date 2021/5/18 11:51 AM
 * @desc
 */
abstract class FlowerDB : RoomDatabase() {

    abstract fun flowerDao(): FlowerDao

    companion object {
        private var instance: FlowerDB? = null

        @Synchronized
        fun get(context: Context): FlowerDB {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        FlowerDB::class.java, "CheeseDatabase")
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                runLongTask {
                                    get(context).flowerDao().insert(FLOWER_DATA.map { Flower(id = 0, name = it) })
                                }
                            }
                        }).build()
            }
            return instance!!
        }
    }
}

private val FLOWER_DATA = arrayListOf("Jasmine", "African Daisy.", "Rose ")
