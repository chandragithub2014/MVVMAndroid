package com.mvvm.kot.ViewModels

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "user_info")
data class User(
        @PrimaryKey
        @NotNull
        @ColumnInfo(name = "user_name")
        var userName:String ,
        @NotNull
        @ColumnInfo(name = "user_occ")
        var userOccupation:String
)    {

}