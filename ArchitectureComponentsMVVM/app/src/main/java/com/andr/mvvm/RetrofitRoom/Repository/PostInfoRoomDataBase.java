package com.andr.mvvm.RetrofitRoom.Repository;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;


import com.andr.mvvm.RetrofitRoom.Models.ResultModel;
import com.andr.mvvm.repository.UserDao;

@Database(entities = {ResultModel.class}, version = 1)
public abstract class PostInfoRoomDataBase extends RoomDatabase {
    public abstract PostInfoDao postInfoDao();

    private static PostInfoRoomDataBase INSTANCE;


    static PostInfoRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PostInfoRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PostInfoRoomDataBase.class, "postinfo_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static Callback sRoomDatabaseCallback =
            new Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
}
