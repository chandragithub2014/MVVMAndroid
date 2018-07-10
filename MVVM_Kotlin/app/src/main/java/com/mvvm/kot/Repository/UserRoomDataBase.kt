package com.mvvm.kot.Repository

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.mvvm.kot.ViewModels.User

@Database(entities = arrayOf(User::class), version = 1)
abstract  class UserRoomDataBase: RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: UserRoomDataBase? = null

        fun getInstance(context: Context): UserRoomDataBase? {
            if (INSTANCE == null) {
                synchronized(UserRoomDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context,
                            UserRoomDataBase::class.java, "userData.db")
                            .addCallback(sRoomDataBaseCallback)
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }

        val sRoomDataBaseCallback = object:RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                InitDBAsync(INSTANCE!!).execute()
            }
        };
     /* val sRoomDatabaseCallback = object : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                InitDBAsync(INSTANCE).execute()
            }
        }*/
    }

    }
