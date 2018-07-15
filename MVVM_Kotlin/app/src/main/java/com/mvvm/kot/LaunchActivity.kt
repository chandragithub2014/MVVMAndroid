package com.mvvm.kot

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.mvvm.kot.Kotlin_Login.Views.LoginActivity
import com.mvvm.kot.Kotlin_Retrofit.Views.RetroKotlinActivity
import com.mvvm.kot.Kotlin_Retrofit_Room.Views.RetroRoomActivity

class LaunchActivity: AppCompatActivity(),View.OnClickListener {
    lateinit var mvvmRoom: Button
    lateinit var mvvmRetro:Button
    lateinit var mvvmRetroRoom:Button
    lateinit var mvvmBasicLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        initViews()
    }


    private fun initViews() {
        mvvmRoom = findViewById(R.id.mvvm_room) as Button
        mvvmRetro = findViewById(R.id.mvvm_pagination) as Button
        mvvmRetroRoom = findViewById(R.id. mvvm_retro_room) as Button
        mvvmBasicLogin = findViewById(R.id.mvvm_basic_login) as Button
        mvvmRoom.setOnClickListener(this)
        mvvmRetro.setOnClickListener(this)
        mvvmRetroRoom.setOnClickListener(this)
        mvvmBasicLogin.setOnClickListener(this)
    }





    override fun onClick(view: View?) {
        if (view!!.getId() == R.id.mvvm_room) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)


        } else if (view!!.getId() == R.id.mvvm_pagination) {
           val  intent = Intent(applicationContext, RetroKotlinActivity::class.java)
            startActivity(intent)
        } else if (view!!.getId() == R.id.mvvm_retro_room) {
            val  intent = Intent(applicationContext, RetroRoomActivity::class.java)
            startActivity(intent)
        }else if (view!!.getId() == R.id.mvvm_basic_login) {
            val  intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}