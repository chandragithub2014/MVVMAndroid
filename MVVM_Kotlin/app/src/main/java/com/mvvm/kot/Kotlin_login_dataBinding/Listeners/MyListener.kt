package com.mvvm.kot.Kotlin_login_dataBinding.Listeners

import android.util.Log
import android.widget.Toast
import com.mvvm.kot.Kotlin_login_dataBinding.Model.LoginInfo

class MyListener {
    fun onClickButton(loginInfo: LoginInfo){
       Log.d("MyListener","LoginInfo:::\t\t"+loginInfo.userName+":::::"+loginInfo.userPassWord)
    }
}