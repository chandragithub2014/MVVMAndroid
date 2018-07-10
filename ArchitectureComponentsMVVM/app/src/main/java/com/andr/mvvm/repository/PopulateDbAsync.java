package com.andr.mvvm.repository;

import android.os.AsyncTask;

public class PopulateDbAsync   extends AsyncTask<Void, Void, Void> {

    private final UserDao mDao;

    PopulateDbAsync(UserRoomDataBase db) {
        mDao = db.userDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAll();
        User user = new User("Chandra","SW");
        mDao.insert(user);
        user = new User("Mohan","student");
        mDao.insert(user);
        return null;
    }
}
