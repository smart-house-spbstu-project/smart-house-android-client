package com.yum.sample

import androidx.navigation.findNavController
import org.junit.Test

import org.junit.Assert.*

class NavigatorAndroidTest {

    @Test
    fun route() {
        val activity = MainActivity()
        val navController = activity.findNavController(R.id.imageView)
        val navigator = Navigator(navController)
        navigator.route(1)
    }

    @Test
    fun route1() {
        val activity = MainActivity()
        val navController = activity.findNavController(R.id.imageView)
        val navigator = Navigator(navController)
        navigator.route(1, 1)
    }
}