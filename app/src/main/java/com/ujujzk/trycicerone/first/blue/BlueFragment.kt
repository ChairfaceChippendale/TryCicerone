package com.ujujzk.trycicerone.first.blue

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.trycicerone.R
import kotlinx.android.synthetic.main.fragment_color.*


class BlueFragment : Fragment() {

    companion object {
        fun inst(): BlueFragment {
            return BlueFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.setBackgroundColor(Color.BLUE)

        button.text = "Open Red"
        subbutton.text = "Open Yellow"
        return root
    }

}