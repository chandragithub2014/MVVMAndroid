package com.andr.mvvm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.andr.mvvm.RetofitMVVM.RetroMVVM;
import com.andr.mvvm.RetrofitRoom.Views.RetroFitRoomActivity;


public class LaunchActivity extends AppCompatActivity implements View.OnClickListener{

    Button mvvmRoom,mvvmPaging,mvvm_retro_room;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        initViews();
    }


    private  void initViews(){
        mvvmRoom = (Button)findViewById(R.id.mvvm_room);
        mvvmPaging = (Button)findViewById(R.id.mvvm_pagination);
        mvvm_retro_room = (Button)findViewById(R.id.mvvm_retro_room);
        mvvmRoom.setOnClickListener(this);
        mvvmPaging.setOnClickListener(this);
        mvvm_retro_room.setOnClickListener(this);
    }

    Intent intent ;
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.mvvm_room){
            intent  = new Intent(getApplicationContext(),MainActivity.class);


        }else if(view.getId() == R.id.mvvm_pagination){
            intent  = new Intent(getApplicationContext(),RetroMVVM.class);
        }else if(view.getId() == R.id.mvvm_retro_room){
            intent = new Intent(getApplicationContext(), RetroFitRoomActivity.class);
        }
        startActivity(intent);
    }

}
