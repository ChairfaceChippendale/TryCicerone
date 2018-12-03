package com.ujujzk.trycicerone.first

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ujujzk.trycicerone.R
import com.ujujzk.trycicerone.TabFragment
import com.ujujzk.trycicerone.first.blue.BlueFragment
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import ru.terrakok.cicerone.android.support.SupportAppScreen


class FirstFragment : TabFragment() {

    val cicerone: Cicerone<Router> by inject("first")

    lateinit var navigator: SupportAppNavigator

    companion object {
        fun inst(): FirstFragment {
            return FirstFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_container, container, false)
        val title = root.findViewById<TextView>(R.id.title)
        title.text = "First"
        root.setBackgroundColor(Color.GRAY)

        navigator = SupportAppNavigator(activity, childFragmentManager, R.id.container)
        return root
    }

    override fun onResume() {
        super.onResume()
        cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (childFragmentManager.findFragmentById(R.id.container) == null) {
            cicerone.router.replaceScreen(object : SupportAppScreen(){
                override fun getFragment(): Fragment {
                    val f = BlueFragment.inst()
                    return f
                }
            })
        }
    }

}