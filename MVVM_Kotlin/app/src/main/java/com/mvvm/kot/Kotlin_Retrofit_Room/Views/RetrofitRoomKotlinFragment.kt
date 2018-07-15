package com.mvvm.kot.Kotlin_Retrofit_Room.Views

import android.app.ProgressDialog
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
import com.mvvm.kot.Kotlin_Retrofit_Room.Repository.ResultModel
import com.mvvm.kot.Kotlin_Retrofit_Room.ViewModels.PostListViewModel
import com.mvvm.kot.R
import com.mvvm.kot.ViewModels.User
import com.mvvm.kot.ViewModels.UserListViewModel

public class RetrofitRoomKotlinFragment: Fragment() {

    lateinit var retroFitView: View
    lateinit var retrofitRecyclerView: RecyclerView
    lateinit var postListViewModel: PostListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postListViewModel = ViewModelProviders.of(activity!!).get(PostListViewModel::class.java)
    }

lateinit var progressDialog: ProgressDialog
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        retroFitView = inflater.inflate(R.layout.fragment_retro_fit_post,container,false)
        initViews(retroFitView)
        progressDialog = ProgressDialog.show(activity,"Progress","Loading...",false)
        setAdapter()
        /*postListViewModel.getAllPosts().observe(this,object :Observer<List<ResultModel>>{
            override fun onChanged(t: List<ResultModel>?) {
                userPostAdapter.setListItems(t)
            }

        })
*/

        postListViewModel.fetchPostsFromWebSevice().observe(this,object :Observer<List<ResultModel>>{
            override fun onChanged(t: List<ResultModel>?) {
                 postListViewModel.insertAllPosts(t)
                if(progressDialog.isShowing){
                    progressDialog.dismiss()
                }
            }
        })
       postListViewModel.getAllPosts().observe(this,object:Observer<List<ResultModel>>{
           override fun onChanged(t: List<ResultModel>?) {
               userPostAdapter.setListItems(t)
               if(progressDialog.isShowing){
                   progressDialog.dismiss()
               }
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
     lateinit var userPostAdapter:PostsAdapter
    private  fun setAdapter(){
        if(progressDialog!=null && progressDialog.isShowing){
            progressDialog.dismiss()
        }
         userPostAdapter = PostsAdapter()
        retrofitRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        retrofitRecyclerView.adapter = userPostAdapter

    }

}