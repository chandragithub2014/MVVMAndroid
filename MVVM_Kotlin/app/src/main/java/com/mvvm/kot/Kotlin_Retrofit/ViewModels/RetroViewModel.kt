package com.mvvm.kot.Kotlin_Retrofit.ViewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.mvvm.kot.Kotlin_Retrofit.Repository.APIServiceFactory
import com.mvvm.kot.Kotlin_Retrofit.Repository.ResultModel

class RetroViewModel: AndroidViewModel {
    private var retroRepository: APIServiceFactory
    private val retroObservable: LiveData<List<ResultModel>>

    constructor(application: Application): super(application){
        retroRepository = APIServiceFactory()
        retroObservable = retroRepository.providesWebService()
    }

    fun getProjectRetroListObservable(): LiveData<List<ResultModel>> {
        return retroObservable
    }

}