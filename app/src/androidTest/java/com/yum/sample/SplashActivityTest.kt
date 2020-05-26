package com.yum.sample

import org.junit.Test

import org.junit.Assert.*

class SplashActivityTest {

    val activity = SplashActivity()

    @Test
    fun isOnline() {
        assertEquals(false, activity.isOnline())
    }
}