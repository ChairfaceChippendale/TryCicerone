package com.ujujzk.trycicerone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun selectTab(name: String){

        val currentFragment = supportFragmentManager.fragments.find { it.isVisible}
        val newFragment: Fragment? = supportFragmentManager.findFragmentByTag(name)

        if (currentFragment == newFragment) return

        supportFragmentManager.beginTransaction().apply {
            if (newFragment == null) add(R.id.container, , name)
            if (currentFragment != null) hide(currentFragment)
            if (newFragment != null) show(newFragment)
            commitNow()
        }

    }
}
