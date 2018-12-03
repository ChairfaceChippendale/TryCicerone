package com.ujujzk.trycicerone

import android.support.v4.app.Fragment

abstract class TabFragment :Fragment(), BackButtonListener {

    override fun onBackPressed(): Boolean {
        return if (isAdded) {
            val childFragment = childFragmentManager.findFragmentById(R.id.container)
            childFragment != null && childFragment is BackButtonListener && childFragment.onBackPressed()
        } else false
    }
}