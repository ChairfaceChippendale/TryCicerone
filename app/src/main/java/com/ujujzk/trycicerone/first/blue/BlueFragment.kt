package com.ujujzk.trycicerone.first.blue

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ujujzk.trycicerone.R
import com.ujujzk.trycicerone.first.red.RedFragment
import com.ujujzk.trycicerone.first.yellow.YellowFragment
import kotlinx.android.synthetic.main.fragment_color.*
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen


class BlueFragment : Fragment() {

    val router: Router by inject("first")

    companion object {
        fun inst(): BlueFragment {
            return BlueFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.setBackgroundColor(Color.BLUE)

        root.findViewById<Button>(R.id.button).apply {
            text = "Open Red"
            setOnClickListener {
                router?.navigateTo(object : SupportAppScreen() {
                    override fun getFragment(): Fragment {
                        return RedFragment.inst()
                    }
                })
            }
        }

        root.findViewById<Button>(R.id.subbutton).apply {
            text = "Open Yellow"
            setOnClickListener {
                router?.navigateTo(object : SupportAppScreen() {
                    override fun getFragment(): Fragment {
                        return YellowFragment.inst()
                    }
                })
            }
        }

        return root
    }

}