package com.andr.mvvm.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;
@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    @Query("SELECT * from user_info ORDER BY user_name ASC")
    LiveData<List<User>> getAllUsers();

    @Query("DELETE FROM user_info")
    void deleteAll();
}
