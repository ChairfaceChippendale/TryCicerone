package com.ujujzk.trycicerone.first

import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val firstModule = module {

    single<Cicerone<Router>>(name="first"){ Cicerone.create() }

    single<Router>(name="first") { get<Cicerone<Router>>("first").router }

}