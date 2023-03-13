package com.example.caratlanefilterpagerevamp.filterpageviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.caratlanefilterpagerevamp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filterPageRevamp = FilterPageRevamp()
        supportFragmentManager.beginTransaction().replace(R.id.activity_main_container, filterPageRevamp).commit()

    }
}