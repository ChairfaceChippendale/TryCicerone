package com.ujujzk.trycicerone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.ujujzk.trycicerone.first.FirstFragment
import com.ujujzk.trycicerone.second.SecondFragment
import ru.terrakok.cicerone.Cicerone
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.Command

class MainActivity : AppCompatActivity() {

    private val firstFragment: FirstFragment by lazy {
        supportFragmentManager.findFragmentByTag("First") as? FirstFragment ?: FirstFragment.inst()
    }
    private val secondFragment: SecondFragment by lazy {
        supportFragmentManager.findFragmentByTag("Second") as? SecondFragment ?: SecondFragment.inst()
    }

    private val localCicerone = Cicerone.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firts.setOnClickListener { localCicerone.router.switchFragment(firstFragment) }

        second.setOnClickListener { localCicerone.router.switchFragment(secondFragment) }

        if (savedInstanceState == null) {
            localCicerone.router.switchFragment(firstFragment)
        } else {

        }
    }

    private val navigator = object : Navigator {
        override fun applyCommands(commands: Array<out Command>?) {

        }
    }


}

fun Router.switchFragment(fr: Fragment) {
    this.replaceScreen(object : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return fr
        }
    })
}
