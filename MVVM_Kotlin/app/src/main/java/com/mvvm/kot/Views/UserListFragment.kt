package com.mvvm.kot.Views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.mvvm.kot.Adapter.UserListAdapter
import com.mvvm.kot.R
import com.mvvm.kot.ViewModels.User
import com.mvvm.kot.ViewModels.UserListViewModel

class UserListFragment:Fragment() {
    lateinit var listFragmentView: View
    lateinit var userViewModel: UserListViewModel
    lateinit var recyclerView:RecyclerView
    lateinit var userAdapter:UserListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(activity!!).get(UserListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listFragmentView = inflater.inflate(R.layout.fragment_user_list,container,false)
        initVars(listFragmentView)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        userAdapter = UserListAdapter()
        recyclerView.setAdapter(userAdapter)
        userViewModel.getAllUsers().observe(this, object : Observer <List<User>> {
            override fun onChanged(users: List<User>?) {
                // Update the cached copy of the words in the adapter.
                userAdapter.setListItems(users)
            }
        })
        return listFragmentView
    }

    private fun setAdapter(){

    }

    private fun initVars(view:View){
        recyclerView = view.findViewById(R.id.user_list)
    }
}