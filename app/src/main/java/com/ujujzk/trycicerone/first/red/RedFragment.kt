package com.ujujzk.trycicerone.first.red

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ujujzk.trycicerone.BackButtonListener
import com.ujujzk.trycicerone.R
import com.ujujzk.trycicerone.first.yellow.YellowFragment
import kotlinx.android.synthetic.main.fragment_color.*
import kotlinx.android.synthetic.main.fragment_color.view.*
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen


class RedFragment : Fragment(), BackButtonListener {

    val router: Router by inject("first")

    companion object {
        fun inst(): RedFragment {
            return RedFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.setBackgroundColor(Color.RED)

        root.findViewById<Button>(R.id.button).apply {
            text = "Open Yellow"
            setOnClickListener {
                router.navigateTo(object : SupportAppScreen() {
                    override fun getFragment(): Fragment {
                        return YellowFragment.inst()
                    }
                })
            }
        }
        root.findViewById<Button>(R.id.subbutton).apply {
            text = "Close this and open Yellow"
            setOnClickListener {
                router.replaceScreen(object : SupportAppScreen() {
                    override fun getFragment(): Fragment {
                        return YellowFragment.inst()
                    }
                })
            }
        }
        return root
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}