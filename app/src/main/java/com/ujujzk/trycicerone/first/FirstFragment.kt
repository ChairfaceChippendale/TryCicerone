package com.ujujzk.trycicerone.first

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ujujzk.trycicerone.R
import com.ujujzk.trycicerone.TabFragment


class FirstFragment : TabFragment() {

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

}