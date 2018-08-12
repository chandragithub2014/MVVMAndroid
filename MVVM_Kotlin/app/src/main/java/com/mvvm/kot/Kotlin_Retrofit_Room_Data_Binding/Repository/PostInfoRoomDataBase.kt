package com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Repository

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.mvvm.kot.ViewModels.User

@Database(entities = arrayOf(ResultModel::class), version = 1,exportSchema = false)
abstract  class PostInfoRoomDataBase: RoomDatabase(){
    abstract fun postInfoDao(): PostInfoDao

    companion object {
        private var INSTANCE: PostInfoRoomDataBase? = null

        fun getInstance(context: Context): PostInfoRoomDataBase? {
            if (INSTANCE == null) {
                synchronized(PostInfoRoomDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context,
                            PostInfoRoomDataBase::class.java, "post_info_database.db")
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
                PopulateDbAsync(INSTANCE!!).execute()
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
