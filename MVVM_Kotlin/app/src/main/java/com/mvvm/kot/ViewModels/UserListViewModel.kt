package com.mvvm.kot.ViewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.mvvm.kot.Repository.UserDBRepository
import com.mvvm.kot.Repository.UserDao

class UserListViewModel:AndroidViewModel {

    private  var userRepository: UserDBRepository
    private  var mAllUsers: LiveData<List<User>>


    constructor(application: Application) : super(application){
        userRepository = UserDBRepository(application)
        mAllUsers  = userRepository.getAllUsers()
    }

    fun getAllUsers(): LiveData<List<User>> {
        return mAllUsers
    }

    fun insert(user: User) {
        userRepository.insert(user)
    }



}