package com.ujujzk.trycicerone

import ru.terrakok.cicerone.BaseRouter

class SwitchRouter : BaseRouter() {
    fun switchFragment(fr: TabFragment) {
        executeCommands(SwitchNavigator.SwitchFragment(fr))
    }
}