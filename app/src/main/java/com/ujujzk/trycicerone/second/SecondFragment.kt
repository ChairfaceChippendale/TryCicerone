package com.ujujzk.trycicerone.second

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.trycicerone.R
import kotlinx.android.synthetic.main.fragment_container.*


class SecondFragment : Fragment() {

    companion object {
        fun inst(): SecondFragment {
            return SecondFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_container, container, false)
        title.text = "Second"
        root.setBackgroundColor(Color.LTGRAY)
        return root
    }

}