package com.mvvm.kot.Kotlin_login_dataBinding.Repository

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import java.util.regex.Pattern

class ValidationRepository(application: Application) {

    var application:Application

    init {
        this.application = application
    }

    fun validateCredentials(emailID:String,password:String): LiveData<String> {
     val loginErrorMessage = MutableLiveData<String>()
      if(isEmailValid(emailID)){
             if(password.length<8 && !isPasswordValid(password)){
                 loginErrorMessage.value = "Invalid Password"
             }else{
                 loginErrorMessage.value = "Successful Login"
             }
      }else{
          loginErrorMessage.value = "Invalid Email"
      }

        return  loginErrorMessage
    }





    fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun isPasswordValid(password: String): Boolean{
        val expression  ="^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#\$%^&+=!])(?=\\\\S+\$).{4,}\$";
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(password)
        return matcher.matches()
    }



}
