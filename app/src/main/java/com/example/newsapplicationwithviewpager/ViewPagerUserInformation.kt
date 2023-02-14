package com.example.newsapplicationwithviewpager

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class ViewPagerUserInformation : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager_user_information, container, false)
        val fName = view.findViewById<EditText>(R.id.first_name)
        val lName = view.findViewById<EditText>(R.id.last_name)
        val emailId = view.findViewById<EditText>(R.id.email)
        val mobileNo = view.findViewById<EditText>(R.id.mobile_number)
        val updateBtn = view.findViewById<Button>(R.id.update)

        val sharedPreferences = this.activity?.getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        val firstName = sharedPreferences?.getString("fName", "")
        val lastName = sharedPreferences?.getString("lName", "")
        val email = sharedPreferences?.getString("eMail", "")
        val mobileNum = sharedPreferences?.getString("mobileNumber", "")

        fName.setText(firstName)
        lName.setText(lastName)
        emailId.setText(email)
        mobileNo.setText(mobileNum)

        updateBtn.setOnClickListener {
            editor?.putString("fName", fName.text.toString())
            editor?.putString("lName", lName.text.toString())
            editor?.putString("eMail", emailId.text.toString())
            editor?.putString("mobileNumber", mobileNo.text.toString())
            editor?.apply()
        }
        return view
    }
}