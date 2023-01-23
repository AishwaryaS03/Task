package com.example.myfragmentrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(),HomeFragmentToDetailedFragmentCommunicator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(homeFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.frameLayout,homeFragment)
        fragmentTransaction.commit()

    }

    override fun passData() {
        val transaction = this.supportFragmentManager.beginTransaction()
        val detailedNewsFragment = DetailedNewsFragment()
        transaction.replace(R.id.frameLayout , detailedNewsFragment)
        transaction.commit()

    }
}
