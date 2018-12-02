package com.ujujzk.trycicerone.first

import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.trycicerone.R
import kotlinx.android.synthetic.main.fragment_container.*


class FirstFragment : Fragment() {

    companion object {
        fun inst(): FirstFragment {
            return FirstFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_container, container, false)
        title.text = "First"
        root.setBackgroundColor(Color.GRAY)
        return root
    }

}