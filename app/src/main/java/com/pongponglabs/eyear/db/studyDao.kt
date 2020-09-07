package com.pongponglabs.eyear.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface studyDao {

    @Query("SELECT * FROM study")
    fun getAll(): List<Study>

    @Query("DELETE from study")
    fun deleteAll()


}