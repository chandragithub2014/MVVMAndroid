package com.mvvm.kot.Repository

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mvvm.kot.ViewModels.User

@Dao
interface UserDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
fun insert(user:User)

@Query("SELECT * from user_info ORDER BY user_name ASC")
fun getAllUsers():LiveData<List<User>>

@Query("DELETE FROM user_info")
fun deleteAll()
}