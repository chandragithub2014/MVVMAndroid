package com.mvvm.kot

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mvvm.kot.Views.UserInfoFragment
import com.mvvm.kot.Views.UserListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.container_first, UserListFragment()).commit()
        supportFragmentManager.beginTransaction().replace(R.id.container_second, UserInfoFragment()).commit()
    }
}
