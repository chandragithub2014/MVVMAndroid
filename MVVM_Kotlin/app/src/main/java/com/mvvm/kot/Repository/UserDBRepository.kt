package com.mvvm.kot.Repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.mvvm.kot.ViewModels.User

class UserDBRepository {
    private   var userDao: UserDao
    private  var mAllUsers: LiveData<List<User>>

    constructor(application: Application){
        val db = UserRoomDataBase.getInstance(application)
        userDao = db!!.userDao()
        mAllUsers = userDao.getAllUsers()

    }

    fun getAllUsers(): LiveData<List<User>> {
        return mAllUsers
    }

    fun insert(user: User) {
        InsertAsyncTask(userDao).execute(user)
    }
    class InsertAsyncTask internal  constructor(userDao: UserDao): AsyncTask<User, Void, Void>(){
        private  var mAsyncUserDao: UserDao
        init {
            mAsyncUserDao = userDao
        }
        override fun doInBackground(vararg p0: User): Void? {
            mAsyncUserDao.insert(p0[0])
            return null

        }
    }

    /*fun UserRepository(application: Application): ??? {
        val db = UserRoomDataBase.getDatabase(application)
        userDao = db.userDao()
        mAllUsers = userDao.getAllUsers()
    }*/
}