package com.yum.sample.fragments

import android.view.LayoutInflater
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import androidx.test.InstrumentationRegistry
import com.yum.sample.R
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.util.zip.Inflater

class ListPageAndroidTest {

    var page = ListPage()

    @Test
    fun getNavController() {
        val navController = NavHostFragment.findNavController(page)
        page.showList(listOf())
        assertEquals(navController, page.navController)
    }

    @Test
    fun setNavController() {
        val navController = NavHostFragment.findNavController(page)
        page.navController = navController
        assertEquals(navController, page.navController)
    }

    @Test
    fun getRecyclerView() {
        page.recyclerView
    }

    @Test
    fun setRecyclerView() {
        val rv =RecyclerView(InstrumentationRegistry.getInstrumentation().context)
        page.recyclerView = rv
        assertEquals(rv, page.recyclerView)
    }

    @Test
    fun onCreateView() {
        val inf = LayoutInflater.from(InstrumentationRegistry.getInstrumentation().context)
        val view = page.onCreateView(
            inf,
            null,
            null
        )
        val view1 = inf.inflate(R.layout.device_page, null, false)
        assertEquals(view1?.layoutDirection, view?.layoutDirection)
    }

    @Test
    fun onViewCreated() {
        val inf = LayoutInflater.from(InstrumentationRegistry.getInstrumentation().context)
        val view1 = inf.inflate(R.layout.device_page, null, false)
        page.onViewCreated(view1, null)
    }

    @Test
    fun showList() {
        page.showList(listOf())
    }
}