package com.home.androidcomponentdemo4

import android.os.Bundle
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.home.modulebase.view.BaseActivity
import com.home.modulehome.view.HomeFragment
import com.home.modulemessage.view.MessageFragment
import com.home.modulenotice.view.NoticeFragment
import kotlinx.android.synthetic.main.app_activity_main.*

class MainActivity : BaseActivity() {

    companion object {
        private const val HOME_FRAGMENT = 0
        private const val MESSAGE_FRAGMENT = 1
        private const val NOTICE_FRAGMENT = 2
    }

    override val contentView: Int
        get() = R.layout.app_activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeMeowBottomNavigation()
        initializeFragment()
    }

    private fun initializeMeowBottomNavigation() {
        meow_bottom_navigation.apply {
            add(
                MeowBottomNavigation.Model(
                    HOME_FRAGMENT, R.drawable.icon_app_activity_main_home_bottom
                )
            )
            add(
                MeowBottomNavigation.Model(
                    MESSAGE_FRAGMENT, R.drawable.icon_app_activity_main_message_bottom
                )
            )
            add(
                MeowBottomNavigation.Model(
                    NOTICE_FRAGMENT, R.drawable.icon_app_activity_main_notice_bottom
                )
            )
            val count = 6
            setCount(NOTICE_FRAGMENT, count.toString())
            setOnClickMenuListener {
                when (it.id) {
                    HOME_FRAGMENT -> selectFragment(HOME_FRAGMENT)
                    MESSAGE_FRAGMENT -> selectFragment(MESSAGE_FRAGMENT)
                    NOTICE_FRAGMENT -> selectFragment(NOTICE_FRAGMENT)
                }
            }
        }
        meow_bottom_navigation.show(HOME_FRAGMENT)
    }

    private fun initializeFragment() {
        fragmentList.add(HomeFragment.newInstance(this))
        fragmentList.add(MessageFragment.newInstance(this))
        fragmentList.add(NoticeFragment.newInstance(this))
        selectFragment(HOME_FRAGMENT)
    }
}
