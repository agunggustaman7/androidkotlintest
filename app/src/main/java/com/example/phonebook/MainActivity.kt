package com.example.phonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var menu : Menu = bottom_nav.menu

        selectedMenu(menu.getItem(0))
        bottom_nav.setOnNavigationItemSelectedListener {
            item: MenuItem -> selectedMenu(item)
            false
        }
    }

    private fun selectedMenu(item: MenuItem) {
        item.isChecked = true
        when(item.itemId) {
            R.id.itContact -> selectedFragment(FragmentContact.getInstance())
        }

    }

    fun selectedFragment(fragment: Fragment) {
        var transaction : FragmentTransaction? = supportFragmentManager.beginTransaction()
        transaction?.replace(R.id.flFrame, fragment)
        transaction?.commit()
    }

    override fun onBackPressed() {
        finish()
    }

}
