package com.example.phonebook.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentTransaction
import com.example.phonebook.Fragment.BlankFragment
import com.example.phonebook.Fragment.ContactFragment
import com.example.phonebook.R
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initFragmen()
    }

    private fun initFragmen() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ContactFragment(), "Contact")
        adapter.addFragment(BlankFragment(), "Calendar")
        adapter.addFragment(BlankFragment(), "Inbox")
        adapter.addFragment(BlankFragment(), "Setting")

        viewPager.adapter = adapter

        tblayout.setupWithViewPager(viewPager)
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        private var fragmentList: ArrayList<Fragment> = ArrayList()
        private var fragmentTitleList: ArrayList<String> = ArrayList()

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {

            return fragmentList[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return fragmentTitleList[position]
        }
    }
}
