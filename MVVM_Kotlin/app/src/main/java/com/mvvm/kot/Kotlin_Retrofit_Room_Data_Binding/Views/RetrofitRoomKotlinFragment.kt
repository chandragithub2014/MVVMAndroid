package com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Views

import android.app.ProgressDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Repository.ResultModel
import com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.ViewModels.PostListViewModel
import com.mvvm.kot.R
import com.mvvm.kot.ViewModels.User
import com.mvvm.kot.ViewModels.UserListViewModel
import com.mvvm.kot.databinding.RetrofitFragmentBinding

public class RetrofitRoomKotlinFragment: Fragment() {

    lateinit var retroFitView: View
    lateinit var retrofitRecyclerView: RecyclerView
    lateinit var postListViewModel: PostListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postListViewModel = ViewModelProviders.of(activity!!).get(PostListViewModel::class.java)
    }

lateinit var progressDialog: ProgressDialog
    lateinit var retrofitBinding: RetrofitFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      //  retroFitView = inflater.inflate(R.layout.fragment_retro_fit_post,container,false)
       // initViews(retroFitView)

        /*postListViewModel.getAllPosts().observe(this,object :Observer<List<ResultModel>>{
            override fun onChanged(t: List<ResultModel>?) {
                userPostAdapter.setListItems(t)
            }

        })
*/

        retrofitBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_retro_fit_post_data_binding,container,false)
        retroFitView = retrofitBinding.getRoot()
        retrofitBinding.pbLoading.visibility = View.VISIBLE

     //   progressDialog = ProgressDialog.show(activity,"Progress","Loading...",false)
        setAdapter()
        postListViewModel.fetchPostsFromWebSevice().observe(this,object :Observer<List<ResultModel>>{
            override fun onChanged(t: List<ResultModel>?) {
                 postListViewModel.insertAllPosts(t)
              /*  if(progressDialog.isShowing){
                    progressDialog.dismiss()
                }*/
               if(retrofitBinding.pbLoading.visibility == View.VISIBLE){
                   retrofitBinding.pbLoading.visibility = View.GONE
                   retrofitBinding.progressBarTitle.visibility = View.GONE
               }
            }
        })
       postListViewModel.getAllPosts().observe(this,object:Observer<List<ResultModel>>{
           override fun onChanged(t: List<ResultModel>?) {
               userPostAdapter.setListItems(t)
             /*  if(progressDialog.isShowing){
                   progressDialog.dismiss()
               }*/

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


   /* private fun initViews(view: View){
        retrofitRecyclerView = view.findViewById(R.id.post_list)as RecyclerView
    }*/
     lateinit var userPostAdapter:PostsAdapter
    private  fun setAdapter(){
       /* if(progressDialog!=null && progressDialog.isShowing){
            progressDialog.dismiss()
        }*/
       /* if(retrofitBinding.pbLoading.visibility == View.VISIBLE){
            retrofitBinding.pbLoading.visibility = View.GONE
            retrofitBinding.progressBarTitle.visibility = View.GONE
        }*/
        userPostAdapter = PostsAdapter()
        retrofitBinding.postList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
     //   retrofitRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        retrofitBinding.postList.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
        retrofitBinding.postList.adapter = userPostAdapter

    }

}