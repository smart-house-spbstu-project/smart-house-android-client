package com.yum.sample

import androidx.navigation.NavController
import org.junit.Test

import org.junit.Assert.*

class NavigatorTest {

    val nav = Navigator(null)

    @Test
    fun getDestinations() {
        assertEquals(R.id.action_mainMenu_to_pageFragment,
            nav.destinations[R.id.textStyles])
    }

    @Test
    fun getLayouts() {
        assertEquals(0, nav.layouts[0])
    }

    @Test
    fun getNavController() {
        assertEquals(null, nav.navController)
    }
}