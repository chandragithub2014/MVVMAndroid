package com.mvvm.kot.Kotlin_Retrofit.Views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.mvvm.kot.Kotlin_Retrofit.Adapter.UserPostAdapter
import com.mvvm.kot.Kotlin_Retrofit.Repository.ResultModel
import com.mvvm.kot.Kotlin_Retrofit.ViewModels.RetroViewModel
import com.mvvm.kot.R
import com.mvvm.kot.ViewModels.User
import com.mvvm.kot.ViewModels.UserListViewModel

public class RetrofitKotlinFragment: Fragment() {

    lateinit var retroFitView: View
    lateinit var retrofitRecyclerView: RecyclerView
    lateinit var retroViewModel: RetroViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retroViewModel = ViewModelProviders.of(activity!!).get(RetroViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retroFitView = inflater.inflate(R.layout.fragment_retro_fit_post,container,false)
        initViews(retroFitView)
        setAdapter()
        retroViewModel.getProjectRetroListObservable().observe(this,object :Observer<List<ResultModel>>{
            override fun onChanged(t: List<ResultModel>?) {
                userPostAdapter.setListItems(t)
            }

        })

        /*
        userViewModel.getAllUsers().observe(this, object : Observer <List<User>> {
            override fun onChanged(users: List<User>?) {
                // Update the cached copy of the words in the adapter.
                userAdapter.setListItems(users)
            }
        })
         */

        return retroFitView
    }


    private fun initViews(view: View){
        retrofitRecyclerView = view.findViewById(R.id.post_list)as RecyclerView
    }
     lateinit var userPostAdapter:UserPostAdapter
    private  fun setAdapter(){
         userPostAdapter = UserPostAdapter()
        retrofitRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        retrofitRecyclerView.adapter = userPostAdapter

    }

}