package com.andr.mvvm.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    LiveData<List<User>> mAllUsers;

    public UserRepository(Application application){
         UserRoomDataBase db = UserRoomDataBase.getDatabase(application);
         userDao = db.userDao();
         mAllUsers = userDao.getAllUsers();
     }

    public LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }
    public void insert (User user) {
        new insertAsyncTask(userDao).execute(user);
    }

    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
