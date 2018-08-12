package com.mvvm.kot.Kotlin_tabs.views

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
import android.widget.Toast
import com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Views.RetrofitRoomKotlinFragment

import  com.mvvm.kot.Kotlin_tabs.viewmodels.PostListViewModel
import com.mvvm.kot.Kotlin_tabs.Repository_RetroFitList.ResultModel
import com.mvvm.kot.Kotlin_tabs.interfaces.OnItemClickListener
import com.mvvm.kot.R
import com.mvvm.kot.ViewModels.User
import com.mvvm.kot.ViewModels.UserListViewModel
import com.mvvm.kot.databinding.RetrofitFragmentBinding

public class RetrofitRoomKotlinFragment: Fragment(),OnItemClickListener {

    lateinit var retroFitView: View
    lateinit var retrofitRecyclerView: RecyclerView
    lateinit var postListViewModel: PostListViewModel
    var mContainerId:Int = 1
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
        mContainerId = container!!.id

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
        userPostAdapter = PostsAdapter(this)
        retrofitBinding.postList.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
     //   retrofitRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        retrofitBinding.postList.addItemDecoration(DividerItemDecoration(activity,DividerItemDecoration.VERTICAL))
        retrofitBinding.postList.adapter = userPostAdapter

    }

    override fun onItemClick(model: ResultModel??) {

        Toast.makeText(activity,"Clicked on Item"+model!!.getId(),Toast.LENGTH_LONG).show()
        launchChildForRetroFitList()
    }

    fun launchChildForRetroFitList(){
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.root_container2, RetroFitListChildFragment()).addToBackStack(null).commit()
    }

}