package com.andr.mvvm.RetofitMVVM.RetrofitViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.andr.mvvm.RetofitMVVM.Repository.ResultModel;
import com.andr.mvvm.RetofitMVVM.Repository.WebServiceRepository;

import java.util.List;

public class RetroViewModel extends AndroidViewModel {
private final LiveData<List<ResultModel>>  retroObservable;
WebServiceRepository webServiceRepository ;
        public  RetroViewModel(Application application){
            super(application);
            webServiceRepository = new WebServiceRepository();
            retroObservable = webServiceRepository.providesWebService();
        }


    public LiveData<List<ResultModel>> getProjectRetroListObservable() {
        return retroObservable;
    }
}
