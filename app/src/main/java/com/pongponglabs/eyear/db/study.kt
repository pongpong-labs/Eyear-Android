package com.pongponglabs.eyear.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "study")
class Study(@PrimaryKey var id: Long?,
             @ColumnInfo(name = "classname") var className: String,
             @ColumnInfo(name = "summary") var summary: String,
            @ColumnInfo(name = "script") var script: String
){
    constructor(): this(null,"", "", "")
}
