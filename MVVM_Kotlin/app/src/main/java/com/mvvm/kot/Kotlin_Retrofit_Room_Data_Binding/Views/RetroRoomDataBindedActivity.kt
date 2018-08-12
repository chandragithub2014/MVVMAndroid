package com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mvvm.kot.R

class RetroRoomDataBindedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retro_room)
        supportFragmentManager.beginTransaction().replace(R.id.container_retro_room, RetrofitRoomKotlinFragment()).commit()
    }
}


//http://www.zoftino.com/android-recyclerview-data-binding-example