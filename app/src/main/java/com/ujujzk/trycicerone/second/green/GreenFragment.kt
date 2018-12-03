package com.ujujzk.trycicerone.second.green

import android.graphics.Color
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.ujujzk.trycicerone.BackButtonListener
import com.ujujzk.trycicerone.R
import com.ujujzk.trycicerone.second.cyan.CyanFragment
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen


class GreenFragment : Fragment(), BackButtonListener {

    val router: Router by inject("second")

    companion object {
        fun inst(): GreenFragment {
            return GreenFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_color, container, false)
        root.setBackgroundColor(Color.GREEN)

        root.findViewById<Button>(R.id.button).apply {
            text = "Open Cyan"
            setOnClickListener {
                router?.navigateTo(object : SupportAppScreen() {
                    override fun getFragment(): Fragment {
                        return CyanFragment.inst()
                    }
                })
            }
        }

        root.findViewById<Button>(R.id.subbutton).visibility = View.GONE
        return root
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

}