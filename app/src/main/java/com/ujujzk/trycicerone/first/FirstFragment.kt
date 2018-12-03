package com.ujujzk.trycicerone.first

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ujujzk.trycicerone.BackButtonListener
import com.ujujzk.trycicerone.R


class FirstFragment : Fragment(), BackButtonListener {

    companion object {
        fun inst(): FirstFragment {
            return FirstFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_container, container, false)
        val title = root.findViewById<TextView>(R.id.title)
        title.text = "First"
        root.setBackgroundColor(Color.GRAY)
        return root
    }

    override fun onBackPressed(): Boolean {
        return if (isAdded) {
            val childFragment = childFragmentManager.findFragmentById(R.id.container)
            childFragment != null && childFragment is BackButtonListener && childFragment.onBackPressed()
        } else false
    }
}