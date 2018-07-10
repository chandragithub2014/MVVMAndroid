package com.andr.mvvm.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.andr.mvvm.repository.User;
import com.andr.mvvm.repository.UserRepository;

import java.util.List;

public class UserListViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LiveData<List<User>> mAllUsers;

    public UserListViewModel(Application application){
        super(application);
        userRepository = new UserRepository(application);
        mAllUsers = userRepository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return mAllUsers;
    }

    public void insert(User user) {
        userRepository.insert(user);
    }
}
