package com.mvvm.kot.Kotlin_tabs.Repository_RetroFitList

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.mvvm.kot.ViewModels.User
import com.mvvm.kot.Kotlin_tabs.Repository_RetroFitList.ResultModel
class PostInfoDBRepository {
    private   var postInfoDao: PostInfoDao
    private  var mAllPosts: LiveData<List<ResultModel>>

    constructor(application: Application){
        val db = PostInfoRoomDataBase.getInstance(application)
        postInfoDao = db!!.postInfoDao()
        mAllPosts = postInfoDao.getAllPosts()

    }

    fun getAllPosts(): LiveData<List<ResultModel>> {
        return mAllPosts
    }

    fun insertPost(postLists: List<ResultModel>?) {
        InsertAsyncTask(postInfoDao).execute(postLists)
    }
    class InsertAsyncTask internal  constructor(postInfoDao: PostInfoDao): AsyncTask<List<ResultModel>, Void, Void>(){
        private  var mAsyncUserDao: PostInfoDao
        init {
            mAsyncUserDao = postInfoDao
        }
        override fun doInBackground(vararg p0: List<ResultModel>): Void? {
            if(p0[0]!=null) {
                mAsyncUserDao.insertPosts(p0[0])
            }
            return null

        }
    }

    /*fun UserRepository(application: Application): ??? {
        val db = UserRoomDataBase.getDatabase(application)
        userDao = db.userDao()
        mAllUsers = userDao.getAllUsers()
    }*/
}