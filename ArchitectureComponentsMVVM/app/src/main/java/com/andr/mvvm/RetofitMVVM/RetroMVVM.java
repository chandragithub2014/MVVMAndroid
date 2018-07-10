package com.andr.mvvm.RetofitMVVM;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.andr.mvvm.R;
import com.andr.mvvm.RetofitMVVM.RetrofitViews.RetroFitPostFragment;

public class RetroMVVM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro_mvvm);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_pagination,new RetroFitPostFragment()).commit();
    }
}
