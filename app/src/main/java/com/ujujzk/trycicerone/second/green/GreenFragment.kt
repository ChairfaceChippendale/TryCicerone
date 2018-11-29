package com.ujujzk.trycicerone.second.green

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ujujzk.trycicerone.R
import kotlinx.android.synthetic.main.fragment_color.*


class GreenFragment : Fragment() {

    companion object {
        fun inst(): GreenFragment {
            return GreenFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.setBackgroundColor(Color.GREEN)

        button.text = "Open Cyan"
        subbutton.visibility = View.GONE
        return root
    }

}