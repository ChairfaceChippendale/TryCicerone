package com.ujujzk.trycicerone

import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.frag.*


class Frag : Fragment() {

    companion object {
        fun inst(@ColorInt color: Int, text: String): Frag {
            return Frag().apply {
                arguments = Bundle().apply {
                    putInt("color", color)
                    putString("text", text)
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.frag, container, false)
        textView.text = arguments?.getString("text")
        root.setBackgroundColor(arguments?.getInt("color") ?: Color.RED)
        return root
    }

}