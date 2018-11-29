package com.ujujzk.trycicerone.first.red

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.trycicerone.R
import kotlinx.android.synthetic.main.fragment_color.*
import kotlinx.android.synthetic.main.fragment_color.view.*


class RedFragment : Fragment() {

    companion object {
        fun inst(): RedFragment {
            return RedFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.setBackgroundColor(Color.RED)

        button.text = "Open Yellow"
        subbutton.text = "Close this and open Yellow"

        return root
    }

}