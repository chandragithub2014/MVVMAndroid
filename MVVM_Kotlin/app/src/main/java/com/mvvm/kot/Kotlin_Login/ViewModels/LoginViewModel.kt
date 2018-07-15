package com.mvvm.kot.Kotlin_Login.ViewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.mvvm.kot.Kotlin_Login.Repository.ValidationRepository

class LoginViewModel: AndroidViewModel {
private var validationRepository:ValidationRepository

    constructor(application: Application) : super(application){
        validationRepository = ValidationRepository(application)
    }

    fun validateCredentials(email:String,passWord:String): LiveData<String>{
        return validationRepository.validateCredentials(email,passWord)
    }
}