package com.mvvm.kot.Kotlin_Login.Views

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mvvm.kot.Kotlin_Retrofit.Views.RetrofitKotlinFragment
import com.mvvm.kot.R

public class LoginActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_basic_login_layout)
        supportFragmentManager.beginTransaction().replace(R.id.container_basic_login, LoginFragment()).commit()

    }
}