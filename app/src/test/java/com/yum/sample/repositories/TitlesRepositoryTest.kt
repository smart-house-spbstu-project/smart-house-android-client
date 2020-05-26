package com.yum.sample.repositories

import org.junit.Test

import org.junit.Assert.*

class TitlesRepositoryTest {

    @Test
    fun getRepository() {
        val controller = TitlesRepository()
        val repo = controller.repository
        assertEquals("Lamp", repo[0])
    }
}