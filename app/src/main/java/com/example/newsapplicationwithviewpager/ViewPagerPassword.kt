package com.example.newsapplicationwithviewpager

import android.content.Context
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class ViewPagerPassword : Fragment() {
    private val passwd = "password"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_view_pager_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val reset = view.findViewById<Button>(R.id.reset)
        val newPassword = view.findViewById<EditText>(R.id.new_password)
        val oldPassword = view.findViewById<EditText>(R.id.old_password)
        val etPasswordTwo = view.findViewById<EditText>(R.id.et_password_two)
        newPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        etPasswordTwo.transformationMethod = PasswordTransformationMethod.getInstance()
        val sharedPreferences = this.activity?.getSharedPreferences("LoginPref", Context.MODE_PRIVATE)
        val password = sharedPreferences?.getString(passwd, "")

        reset.setOnClickListener {
            val newPasswords = newPassword.text.toString()
            val retypedPassword = etPasswordTwo.text.toString()
            val oldPasswords = oldPassword.text.toString()

            if (newPasswords != retypedPassword) {
                Toast.makeText(activity, R.string.new_pass_not_retype_pass, Toast.LENGTH_SHORT).show()
            }
            else if(password != oldPasswords){
                Toast.makeText(activity,R.string.password_tost, Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(activity,R.string.reset_toast, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
