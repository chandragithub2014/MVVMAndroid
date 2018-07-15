package com.mvvm.kot.Kotlin_Login.Views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.mvvm.kot.Kotlin_Login.ViewModels.LoginViewModel
import com.mvvm.kot.Kotlin_Retrofit.ViewModels.RetroViewModel
import com.mvvm.kot.R

public class LoginFragment: Fragment(),View.OnClickListener {
 lateinit var loginView:View
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProviders.of(activity!!).get(LoginViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        loginView = inflater.inflate(R.layout.login_mvvm_layout,container,false)
        initVars(loginView)
        return loginView
    }

    lateinit var loginEmail: EditText
    lateinit var loginPassword: EditText
    lateinit var loginBtn: Button
    private fun initVars(view:View){
        loginEmail = view.findViewById(R.id.login_email) as EditText
        loginPassword = view.findViewById(R.id.login_password) as EditText
        loginBtn = view.findViewById(R.id.login_btn) as Button
        loginBtn.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        if(p0==loginBtn){
         val email:String = loginEmail.text.toString()
            val password:String = loginPassword.text.toString()
            loginViewModel.validateCredentials(email,password).observe(this,object:Observer<String>{
                override fun onChanged(t: String?) {
                    Toast.makeText(activity, t,Toast.LENGTH_LONG).show()
                }
            })

        }
    }
}