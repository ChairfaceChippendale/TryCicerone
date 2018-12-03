package com.ujujzk.trycicerone.second.pink

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ujujzk.trycicerone.BackButtonListener
import com.ujujzk.trycicerone.R
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Router


class CyanFragment : Fragment(), BackButtonListener {

    val router: Router by inject("second")

    companion object {
        fun inst(): CyanFragment {
            return CyanFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.findViewById<Button>(R.id.button).visibility = View.GONE
        root.findViewById<Button>(R.id.subbutton).visibility = View.GONE
        root.setBackgroundColor(Color.CYAN)
        return root
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}