package com.mvvm.kot.Repository

import android.os.AsyncTask
import com.mvvm.kot.ViewModels.User

public class InitDBAsync(db:UserRoomDataBase): AsyncTask<Void,Void,Void>() {
  private val  mDao: UserDao

    init{
        mDao =  db.userDao()
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



/*

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


 */