package com.ujujzk.trycicerone

import android.support.v4.app.Fragment
import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val appModule = module {

    single<Cicerone<SwitchRouter>>(name = "main") {
        Cicerone.create(SwitchRouter())
    }

    single<SwitchRouter>(name = "main") {
        get<Cicerone<SwitchRouter>>(name = "main").router
    }
}
