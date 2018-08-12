package com.mvvm.kot

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.mvvm.kot.Kotlin_Login.Views.LoginActivity
import com.mvvm.kot.Kotlin_Retrofit.Views.RetroKotlinActivity
import com.mvvm.kot.Kotlin_Retrofit_Room.Views.RetroRoomActivity
import com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Views.RetroRoomDataBindedActivity
import com.mvvm.kot.Kotlin_Simple_List_DataBinding.Views.SimpleListActivity
import com.mvvm.kot.Kotlin_login_dataBinding.Views.LoginDataBindingActivity
import com.mvvm.kot.Kotlin_tabs.TabActivity

class LaunchActivity: AppCompatActivity(),View.OnClickListener {
    lateinit var mvvmRoom: Button
    lateinit var mvvmRetro:Button
    lateinit var mvvmRetroRoom:Button
    lateinit var mvvmBasicLogin:Button
    lateinit var mvvmDBinding_login_btn:Button
    lateinit var mvvmDBind_rv:Button
    lateinit var mvvmDBBind_simple_rv:Button
    lateinit var mvvm_tabs:Button

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
        mvvmDBinding_login_btn = findViewById(R.id.login_data_binding) as Button
        mvvmDBind_rv = findViewById(R.id.mvvm_rv) as Button
        mvvmDBBind_simple_rv = findViewById(R.id.mvvm_rv_simple) as Button
        mvvm_tabs  = findViewById(R.id.mvvm_tabs) as Button
        mvvmRoom.setOnClickListener(this)
        mvvmRetro.setOnClickListener(this)
        mvvmRetroRoom.setOnClickListener(this)
        mvvmBasicLogin.setOnClickListener(this)
        mvvmDBinding_login_btn.setOnClickListener(this)
        mvvmDBind_rv.setOnClickListener(this)
        mvvmDBBind_simple_rv.setOnClickListener(this)
        mvvm_tabs.setOnClickListener(this)
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
        }else if(view!!.getId() == R.id.login_data_binding){
            val  intent = Intent(applicationContext, LoginDataBindingActivity::class.java)
            startActivity(intent)
        }else if(view!!.getId() == R.id.mvvm_rv){
            val  intent = Intent(applicationContext, RetroRoomDataBindedActivity::class.java)
            startActivity(intent)
        }else if(view!!.getId() == R.id.mvvm_rv_simple){
            val  intent = Intent(applicationContext, SimpleListActivity::class.java)
            startActivity(intent)
        }else if(view!!.getId() == R.id.mvvm_tabs){
            val  intent = Intent(applicationContext, TabActivity::class.java)
            startActivity(intent)
        }

    }
}