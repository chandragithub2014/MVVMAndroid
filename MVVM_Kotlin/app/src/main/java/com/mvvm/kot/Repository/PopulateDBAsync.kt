package com.mvvm.kot.Repository

import android.os.AsyncTask
import com.mvvm.kot.ViewModels.User

    class PopulateDbAsync internal constructor(db: UserRoomDataBase) : AsyncTask<Void, Void, Void>() {

        private val mDao: UserDao

        init {
            mDao = db.userDao()
        }

        override fun doInBackground(vararg params: Void): Void? {
            mDao.deleteAll()
            var user = User("Chandra", "SW")
            mDao.insert(user)
            user = User("Mohan", "student")
            mDao.insert(user)
            return null
        }
    }
