package com.ujujzk.trycicerone

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ujujzk.trycicerone.first.FirstFragment
import com.ujujzk.trycicerone.second.SecondFragment
import ru.terrakok.cicerone.Cicerone
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import ru.terrakok.cicerone.BaseRouter

class MainActivity : AppCompatActivity() {

    private val firstFragment: FirstFragment by lazy {
        supportFragmentManager.findFragmentByTag("FirstFragment") as? FirstFragment ?: FirstFragment.inst()
    }
    private val secondFragment: SecondFragment by lazy {
        supportFragmentManager.findFragmentByTag("SecondFragment") as? SecondFragment ?: SecondFragment.inst()
    }

    private val localCicerone : Cicerone<BaseRouter> by inject("main")
    private val router: SwitchRouter by inject(name="main")
    private val navigator = SwitchNavigator(this, supportFragmentManager, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firts.setOnClickListener { router.switchFragment(firstFragment) }
        second.setOnClickListener { router.switchFragment(secondFragment) }

        if (savedInstanceState == null) {
            router.switchFragment(firstFragment)
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




