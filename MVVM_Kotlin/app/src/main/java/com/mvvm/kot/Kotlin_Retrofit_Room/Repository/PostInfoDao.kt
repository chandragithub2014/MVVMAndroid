package com.mvvm.kot.Kotlin_Retrofit_Room.Repository

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mvvm.kot.ViewModels.User

@Dao
interface PostInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(resultModel: ResultModel)

    @Query("SELECT * from post_info ORDER BY id ASC")
     fun getAllPosts(): LiveData<List<ResultModel>>

    @Query("DELETE FROM post_info")
     fun deleteAll()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertPosts(resultModel: List<ResultModel>)
}