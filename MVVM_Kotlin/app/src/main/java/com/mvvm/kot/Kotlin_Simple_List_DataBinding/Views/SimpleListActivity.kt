package com.mvvm.kot.Kotlin_Simple_List_DataBinding.Views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Views.RetrofitRoomKotlinFragment
import com.mvvm.kot.R

class SimpleListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_list)
        supportFragmentManager.beginTransaction().replace(R.id.container_simple_list, SimpleListFragment()).commit()
    }
}
