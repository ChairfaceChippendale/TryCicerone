package com.ujujzk.trycicerone

import org.koin.dsl.module.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val appModule = module {

    single<Router> { Cicerone.create().router }




}