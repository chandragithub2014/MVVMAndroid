package com.andr.mvvm.RetrofitRoom.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.andr.mvvm.RetrofitRoom.Models.ResultModel;
import com.andr.mvvm.RetrofitRoom.Repository.PostRoomDBRepository;
import com.andr.mvvm.RetrofitRoom.Repository.WebServiceRepository;
import com.andr.mvvm.repository.User;
import com.andr.mvvm.repository.UserRepository;

import java.util.List;

public class PostsListViewModel extends AndroidViewModel {

    private PostRoomDBRepository postRoomDBRepository;
    private LiveData<List<ResultModel>> mAllPosts;
    WebServiceRepository webServiceRepository ;
    private final LiveData<List<ResultModel>>  retroObservable;
    public PostsListViewModel(Application application){
        super(application);
        postRoomDBRepository = new PostRoomDBRepository(application);
        webServiceRepository = new WebServiceRepository(application);
        retroObservable = webServiceRepository.providesWebService();
        //postRoomDBRepository.insertPosts(retroObservable.getValue());
        mAllPosts = postRoomDBRepository.getAllPosts();
    }

    public LiveData<List<ResultModel>> getAllPosts() {
        return mAllPosts;
    }

   /* public LiveData<List<ResultModel>> getProjectRetroListObservable() {
        return retroObservable;
    }*/

/*    public void insert(User user) {
        userRepository.insert(user);
    }*/
}
