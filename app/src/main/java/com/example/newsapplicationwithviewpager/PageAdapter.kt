package com.example.newsapplicationwithviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentTransaction
class PageAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            1 -> {
                ViewPagerPassword()
            }
            0 -> {
                ViewPagerUserInformation()
            }

            else -> {
                ViewPagerPassword()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "User Information"
            }
            1 -> {
                return "Reset Password"
            }

        }
        return super.getPageTitle(position)
    }

}