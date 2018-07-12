package com.mvvm.kot.Kotlin_Retrofit_Room.Repository

import android.os.AsyncTask
import com.mvvm.kot.ViewModels.User

    class PopulateDbAsync internal constructor(db: PostInfoRoomDataBase) : AsyncTask<Void, Void, Void>() {

        private val mDao: PostInfoDao

        init {
            mDao = db.postInfoDao()
        }

        override fun doInBackground(vararg params: Void): Void? {
            mDao.deleteAll()
            return null
        }
    }
