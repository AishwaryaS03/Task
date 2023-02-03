package com.example.news_application_using_retrofit_with_loginform

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView = layoutInflater.inflate(R.layout.fragment_login, container, false)
        val signupBtn = rootView.findViewById<Button>(R.id.signup)
        signupBtn.setOnClickListener{
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            val frag2 = HomeFragment()
            transaction?.add(R.id.container2, frag2)
            transaction?.commit()
        }
        return rootView

    }
}
