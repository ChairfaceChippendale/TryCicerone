package com.ujujzk.trycicerone.first.yellow

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.trycicerone.R
import kotlinx.android.synthetic.main.fragment_color.*


class YellowFragment : Fragment() {

    companion object {
        fun inst(): YellowFragment {
            return YellowFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.setBackgroundColor(Color.YELLOW)

        button.visibility = View.GONE
        subbutton.visibility = View.GONE

        return root
    }

}