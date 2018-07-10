package com.mvvm.kot.Kotlin_Retrofit.Views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mvvm.kot.R

class RetroKotlinActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro_mvvm)
        supportFragmentManager.beginTransaction().replace(R.id.container_pagination, RetrofitKotlinFragment()).commit()
    }
}