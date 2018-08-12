package com.mvvm.kot.Kotlin_login_dataBinding.Views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mvvm.kot.Kotlin_login_dataBinding.Listeners.MyListener
import com.mvvm.kot.Kotlin_login_dataBinding.ViewModels.LoginViewModel
import com.mvvm.kot.R
import com.mvvm.kot.databinding.LoginFragmentBinding

class LoginDatabindingFragment:Fragment() {
    lateinit var loginView:View
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProviders.of(activity!!).get(com.mvvm.kot.Kotlin_login_dataBinding.ViewModels.LoginViewModel::class.java)
    }

lateinit var myListener: MyListener
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val loginBinder : LoginFragmentBinding  = DataBindingUtil.inflate(inflater,R.layout.login_data_binding,container,false)
        loginView = loginBinder.getRoot()
        myListener = MyListener()
        loginBinder.handlers = myListener
        loginBinder.loginbtn.setOnClickListener(View.OnClickListener {
           Log.d("LoginDatabinding",loginBinder.editTextemailID.getText().toString())
            val email:String = loginBinder.editTextemailID.getText().toString()
            val password:String = loginBinder.editTextpassID.text.toString()
            loginViewModel.validateCredentials(email,password).observe(this,object: Observer<String> {
                override fun onChanged(t: String?) {
                    Toast.makeText(activity, t, Toast.LENGTH_LONG).show()
                }
            })
        })
       // loginView = inflater.inflate(R.layout.login_data_binding,container,false)
        return loginView
    }

}