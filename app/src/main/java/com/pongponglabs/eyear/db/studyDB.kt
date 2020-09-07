package com.pongponglabs.eyear.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Study::class], version = 1)
abstract class StudyDB: RoomDatabase() {
    abstract fun studyDao(): studyDao

    companion object {
        private var INSTANCE: StudyDB? = null

        fun getInstance(context: Context): StudyDB? {
            if (INSTANCE == null) {
                synchronized(StudyDB::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        StudyDB::class.java, "eyear_study.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}