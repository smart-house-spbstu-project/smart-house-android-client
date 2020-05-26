package com.yum.sample.repositories

import org.junit.Test

import org.junit.Assert.*

class ListRepositoryTest {

    @Test
    fun provide() {
        val controller = ListRepository()
        val item = controller.provide(5)
        assertEquals(2, item.size)
    }
}