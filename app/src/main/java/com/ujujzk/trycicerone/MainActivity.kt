package com.ujujzk.trycicerone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.Toast
import com.ujujzk.trycicerone.first.FirstFragment
import com.ujujzk.trycicerone.second.SecondFragment
import ru.terrakok.cicerone.Cicerone
import kotlinx.android.synthetic.main.activity_main.*
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command

class MainActivity : AppCompatActivity() {

    private val firstFragment: FirstFragment by lazy {
        supportFragmentManager.findFragmentByTag("FirstFragment") as? FirstFragment ?: FirstFragment.inst()
    }
    private val secondFragment: SecondFragment by lazy {
        supportFragmentManager.findFragmentByTag("SecondFragment") as? SecondFragment ?: SecondFragment.inst()
    }

    private val localCicerone = Cicerone.create(object : Router(){
        fun switchFragment(fr: Fragment){
            executeCommands(SwitchFragment(fr))
        }
    })

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
        override fun applyCommands(commands: Array<out Command>) {
            for (command in commands) applyCommand(command)

        }

        private fun applyCommand(command: Command) {
            when (command) {
                is Back -> finish()
                is SwitchFragment -> changeTab(command.fr)
            }
        }

        //we could also use attach() and detach() instead of show() and hide().
        private fun changeTab(targetFragment: Fragment) {
            with(supportFragmentManager.beginTransaction()) {

                supportFragmentManager.fragments.filter{ it != targetFragment }.forEach {
                    hide(it)
                    it.userVisibleHint = false //since hide doesn't trigger onPause, we use this instead to let the fragment know it is not visible
                }

                targetFragment.let {

                    if (it.isAdded) {
                        show(it)
                    } else {
                        add(R.id.container, it)
                    }
                    it.userVisibleHint = true
                }
                commit()
            }
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        localCicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        localCicerone.navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.filter{ it.isVisible }.forEach {
            if (!(it as BackButtonListener).onBackPressed())
                finish()
        }
    }

}

class SwitchFragment(val fr: Fragment) : Command {

}


