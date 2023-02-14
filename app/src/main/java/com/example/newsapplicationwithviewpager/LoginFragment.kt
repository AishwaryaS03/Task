package com.example.newsapplicationwithviewpager

import android.content.Context
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment


class LoginFragment : Fragment() {
    val loginPref = "loginpref"
    val named = "name"
    val passwd = "passwd"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = layoutInflater.inflate(R.layout.fragment_login, container, false)
        val userName = rootView.findViewById<EditText>(R.id.et_name)
        val signupBtn = rootView.findViewById<Button>(R.id.sign_up)
        val password = rootView.findViewById<EditText>(R.id.et_password)
        val checkBox = rootView.findViewById<CheckBox>(R.id.check_box)
        password.transformationMethod = PasswordTransformationMethod.getInstance()

        val sharedPreferences = this.activity?.getSharedPreferences(loginPref , Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()

        val name = sharedPreferences?.getString(named, "")
        val passwords = sharedPreferences?.getString(passwd, "")

        password.setText(passwords)
        userName.setText(name)

        signupBtn.setOnClickListener {
            if (checkBox.isChecked) {
                editor?.putString(named, userName.text.toString())
                editor?.putString(passwd, password.text.toString())
                editor?.apply()
            } else {
                editor?.putString(named, "")
                editor?.putString(passwd, "")
                editor?.apply()
            }
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val fragHome = HomeFragment()
            transaction?.add(R.id.container, fragHome)
            signupBtn.visibility=  View.GONE
            transaction?.commit()
        }
        return rootView
    }
}
