package com.mvvm.kot.Views

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mvvm.kot.R
import com.mvvm.kot.ViewModels.User
import com.mvvm.kot.ViewModels.UserListViewModel

class UserInfoFragment: Fragment(),View.OnClickListener {
    lateinit var userInfoFragmentView: View
    lateinit var userViewModel: UserListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userViewModel = ViewModelProviders.of(activity!!).get(UserListViewModel::class.java)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        userInfoFragmentView = inflater.inflate(R.layout.fragment_user_info,container,false)
        initViews(userInfoFragmentView)
        return userInfoFragmentView
    }

   lateinit var userName: EditText
    lateinit var userOccupation:EditText
    lateinit var saveUser: Button

    private fun initViews(view: View) {
        userName = view.findViewById(R.id.user_name) as EditText
        userOccupation = view.findViewById(R.id.user_occupation) as EditText
        saveUser = view.findViewById(R.id.save_info) as Button
        saveUser.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        saveInfo()
    }

    private fun saveInfo() {
        if (!TextUtils.isEmpty(userName.text.toString()) && !TextUtils.isEmpty(userOccupation.text.toString())) {
            val name = userName.text.toString()
            val userOccup = userOccupation.text.toString()
            val user = User(name, userOccup)
            userViewModel.insert(user)
            userName.setText("")
            userOccupation.setText("")



        } else {
            Toast.makeText(activity, "Plz Fill Required info...", Toast.LENGTH_LONG).show()
        }
    }
}