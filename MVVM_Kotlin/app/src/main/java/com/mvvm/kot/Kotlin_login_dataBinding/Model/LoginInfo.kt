package com.mvvm.kot.Kotlin_login_dataBinding.Model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.android.databinding.library.baseAdapters.BR
import com.google.gson.annotations.SerializedName

/*
data class UserInfo(var userName:String,var userPassWord:String){
}
*/

class LoginInfo : BaseObservable() {
    var userName: String? = null
        @Bindable get() = field
        set(userName) {
            field = userName
            notifyPropertyChanged(BR.userName)
        }
    var userPassWord: String? = null
        @Bindable get() = field
        set(userPassWord) {
            field = userPassWord
            notifyPropertyChanged(BR.userPassWord)
        }
}