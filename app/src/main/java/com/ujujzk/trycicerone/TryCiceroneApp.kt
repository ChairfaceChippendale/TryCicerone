package com.ujujzk.trycicerone

import android.app.Application
import com.ujujzk.trycicerone.first.firstModule
import com.ujujzk.trycicerone.second.secondModule
import org.koin.android.ext.android.startKoin

class TryCiceroneApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule, firstModule, secondModule))
    }
}