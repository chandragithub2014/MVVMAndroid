package com.mvvm.kot.Kotlin_Simple_List_DataBinding.Views

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
import com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.ViewModels.PostListViewModel
import com.mvvm.kot.Kotlin_Retrofit_Room_Data_Binding.Views.PostsAdapter
import com.mvvm.kot.Kotlin_Simple_List_DataBinding.ViewModels.SimpleListDTO
import com.mvvm.kot.Kotlin_Simple_List_DataBinding.ViewModels.SimpleListViewModel
import com.mvvm.kot.R
import com.mvvm.kot.databinding.SimpleListFragmentBinding

class SimpleListFragment : Fragment() {
    lateinit var simpleListView:View
    lateinit var simpleListBinding: SimpleListFragmentBinding
    lateinit var simpleListViewModel: SimpleListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        simpleListViewModel = ViewModelProviders.of(activity!!).get(SimpleListViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        simpleListBinding = DataBindingUtil.inflate(inflater, R.layout.simple_list_layout,container,false)
        simpleListView = simpleListBinding.getRoot()
        setAdapter()
        simpleListViewModel.getSimpleListData().observe(this,object:Observer<List<SimpleListDTO>>
        {
            override fun onChanged(t: List<SimpleListDTO>?) {
                simpleListAdapter.setListItems(t)
            }
        })
        return  simpleListView
    }


    lateinit var simpleListAdapter: SimpleListAdapter
    private  fun setAdapter(){
        /* if(progressDialog!=null && progressDialog.isShowing){
             progressDialog.dismiss()
         }*/
        /* if(retrofitBinding.pbLoading.visibility == View.VISIBLE){
             retrofitBinding.pbLoading.visibility = View.GONE
             retrofitBinding.progressBarTitle.visibility = View.GONE
         }*/
        simpleListAdapter = SimpleListAdapter()
        simpleListBinding.simpleListFrag.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        //   retrofitRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        simpleListBinding.simpleListFrag.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
        simpleListBinding.simpleListFrag.adapter = simpleListAdapter

    }
}