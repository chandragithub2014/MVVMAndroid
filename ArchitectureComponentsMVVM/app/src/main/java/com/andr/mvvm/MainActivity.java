package com.andr.mvvm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andr.mvvm.views.UserInfoFragment;
import com.andr.mvvm.views.UserListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_first,new UserListFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.container_second,new UserInfoFragment()).commit();
    }
}
