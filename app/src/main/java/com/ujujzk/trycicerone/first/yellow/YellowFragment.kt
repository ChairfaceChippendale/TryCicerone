package com.ujujzk.trycicerone.first.yellow

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ujujzk.trycicerone.BackButtonListener
import com.ujujzk.trycicerone.R
import kotlinx.android.synthetic.main.fragment_color.*
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Router


class YellowFragment : Fragment(), BackButtonListener {

    val router: Router by inject("first")

    companion object {
        fun inst(): YellowFragment {
            return YellowFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.setBackgroundColor(Color.YELLOW)

        root.findViewById<Button>(R.id.button).visibility = View.GONE
        root.findViewById<Button>(R.id.subbutton).visibility = View.GONE

        return root
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}