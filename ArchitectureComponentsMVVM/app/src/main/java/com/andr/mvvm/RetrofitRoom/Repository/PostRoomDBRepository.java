package com.andr.mvvm.RetrofitRoom.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.andr.mvvm.RetrofitRoom.Models.ResultModel;
import com.andr.mvvm.repository.User;
import com.andr.mvvm.repository.UserDao;
import com.andr.mvvm.repository.UserRoomDataBase;

import java.util.List;

public class PostRoomDBRepository {
    private PostInfoDao postInfoDao;
    LiveData<List<ResultModel>> mAllPosts;

    public PostRoomDBRepository(Application application){
         PostInfoRoomDataBase db = PostInfoRoomDataBase.getDatabase(application);
        postInfoDao = db.postInfoDao();
        mAllPosts = postInfoDao.getAllPosts();
     }

    public LiveData<List<ResultModel>> getAllPosts() {
        return mAllPosts;
    }
    public void insertPosts (List<ResultModel> resultModel) {
        new insertAsyncTask(postInfoDao).execute(resultModel);
    }

    private static class insertAsyncTask extends AsyncTask<List<ResultModel>, Void, Void> {

        private PostInfoDao mAsyncTaskDao;

        insertAsyncTask(PostInfoDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<ResultModel>... params) {
            mAsyncTaskDao.insertPosts(params[0]);
            return null;
        }
    }
}
