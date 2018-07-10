package com.andr.mvvm.RetrofitRoom.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andr.mvvm.R;
import com.andr.mvvm.RetofitMVVM.RetrofitViews.RetroFitPostFragment;

public class RetroFitRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro_fit_room);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_retro_room,new com.andr.mvvm.RetrofitRoom.Views.RetroFitPostFragment()).commit();
    }
}
