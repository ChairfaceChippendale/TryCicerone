package com.ujujzk.trycicerone

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Back
import ru.terrakok.cicerone.commands.Command

class SwitchNavigator(
    private val activity: FragmentActivity,
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) : Navigator {

    override fun applyCommands(commands: Array<out Command>) {
        for (command in commands) applyCommand(command)
    }

    private fun applyCommand(command: Command) {
        when (command) {
            is Back -> activity.finish()
            is SwitchFragment -> changeTab(command.fr)
        }
    }

    //we could also use attach() and detach() instead of show() and hide().
    private fun changeTab(targetFragment: TabFragment) {
        with(fragmentManager.beginTransaction()) {

            fragmentManager.fragments.filter{ it != targetFragment }.forEach {
                hide(it)
                it.userVisibleHint = false //since hide doesn't trigger onPause, we use this instead to let the fragment know it is not visible
            }

            targetFragment.let {

                if (it.isAdded) {
                    show(it)
                } else {
                    add(containerId, it, it.tagd)
                }
                it.userVisibleHint = true
            }
            commit()
        }
    }

    class SwitchFragment(val fr: TabFragment) : Command

}