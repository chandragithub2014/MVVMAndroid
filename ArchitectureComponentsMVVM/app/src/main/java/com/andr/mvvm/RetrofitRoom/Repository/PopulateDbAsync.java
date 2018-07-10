package com.andr.mvvm.RetrofitRoom.Repository;

import android.os.AsyncTask;

import com.andr.mvvm.repository.User;
import com.andr.mvvm.repository.UserDao;
import com.andr.mvvm.repository.UserRoomDataBase;

public class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

    private final PostInfoDao mDao;

    PopulateDbAsync(PostInfoRoomDataBase db) {
        mDao = db.postInfoDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAll();
       /* User user = new User("Chandra","SW");
        mDao.insert(user);
        user = new User("Mohan","student");
        mDao.insert(user);*/
        return null;
    }
}
