package com.yum.sample.repositories

import org.junit.Test

import org.junit.Assert.*

class ButtonsControllerTest {

    @Test
    fun provide() {
        val controller = ButtonsController()
        val item = controller.provide(1)
        assertEquals(1, item.id)
    }
}