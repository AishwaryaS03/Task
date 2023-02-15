package com.example.livedataexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
//     var count = 0
    private var viewModel:MainActivityViewModel ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val button = findViewById<Button>(R.id.countButton)
        val textV = findViewById<TextView>(R.id.textV)
        //textV.text=count.toString()
        //textV.text= viewModel?.count.toString()
        viewModel?.count?.observe(this, Observer {
            textV.text = it.toString()
        })
        button.setOnClickListener{
//            ++count
//            textV.text=count.toString()
            viewModel?.updateCount()
           // textV.text = viewModel?.count.toString()


        }


    }
}