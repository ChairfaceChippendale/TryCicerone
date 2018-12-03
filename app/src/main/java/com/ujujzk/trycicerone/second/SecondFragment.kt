package com.ujujzk.trycicerone.second

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ujujzk.trycicerone.R
import com.ujujzk.trycicerone.TabFragment


class SecondFragment : TabFragment() {

    companion object {
        fun inst(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_container, container, false)
        val title = root.findViewById<TextView>(R.id.title)
        title.text = "Second"
        root.setBackgroundColor(Color.LTGRAY)
        return root
    }

}