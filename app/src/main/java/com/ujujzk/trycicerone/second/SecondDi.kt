package com.ujujzk.trycicerone.second

import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val secondModule = module {

    single<Cicerone<Router>>(name="second"){ Cicerone.create() }

    single<Router>(name="second") { get<Cicerone<Router>>("second").router }

}