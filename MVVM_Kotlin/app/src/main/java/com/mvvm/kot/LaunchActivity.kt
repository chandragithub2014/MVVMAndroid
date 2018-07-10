package com.mvvm.kot

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.mvvm.kot.Kotlin_Retrofit.Views.RetroKotlinActivity

class LaunchActivity: AppCompatActivity(),View.OnClickListener {
    lateinit var mvvmRoom: Button
    lateinit var mvvmRetro:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        initViews()
    }


    private fun initViews() {
        mvvmRoom = findViewById(R.id.mvvm_room) as Button
        mvvmRetro = findViewById(R.id.mvvm_pagination) as Button
        mvvmRoom.setOnClickListener(this)
        mvvmRetro.setOnClickListener(this)
    }





    override fun onClick(view: View?) {
        if (view!!.getId() == R.id.mvvm_room) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)


        } else if (view!!.getId() == R.id.mvvm_pagination) {
           val  intent = Intent(applicationContext, RetroKotlinActivity::class.java)
            startActivity(intent)
        }

    }
}