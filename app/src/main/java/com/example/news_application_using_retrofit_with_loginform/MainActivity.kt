package com.example.news_application_using_retrofit_with_loginform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log


const val BASE_URL = "https://mocki.io/v1/"

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentLogin: LoginFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentLogin = LoginFragment()
        supportFragmentManager.beginTransaction().replace(R.id.container, fragmentLogin).commit()
    }

    fun callBackToActivity(image: String?, news: String?) {
        Log.d("image1", "$image")
        val bundle = Bundle()
        bundle.apply {
            putString("image", image)
            putString("news", news)
        }
        val fragmentDetailedNewsFragment = DetailedNewsFragment()
        fragmentDetailedNewsFragment.arguments = bundle
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentLogin = LoginFragment()
        val backStateName = fragmentLogin.javaClass.name
        fragmentTransaction.addToBackStack(backStateName)
        fragmentTransaction.replace(R.id.container, fragmentDetailedNewsFragment)
        fragmentTransaction.commit()

    }

}
