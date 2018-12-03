package com.ujujzk.trycicerone.first.red

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ujujzk.trycicerone.R
import kotlinx.android.synthetic.main.fragment_color.*
import kotlinx.android.synthetic.main.fragment_color.view.*
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Router


class RedFragment : Fragment() {

    val router: Router by inject("first")

    companion object {
        fun inst(): RedFragment {
            return RedFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.setBackgroundColor(Color.RED)

        root.findViewById<Button>(R.id.button).text = "Open Yellow"
        root.findViewById<Button>(R.id.subbutton).text = "Close this and open Yellow"

        return root
    }

}