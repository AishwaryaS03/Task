package com.example.task2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment


class loginpage : Fragment() {
    private lateinit var mytext: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.loginpage, container, false)
        mytext = view.findViewById(R.id.textm)
        val data = arguments
        mytext.text = data?.get("").toString()
        return view



    }
}







