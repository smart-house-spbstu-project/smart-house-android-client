package com.yum.sample

import android.view.LayoutInflater
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.test.InstrumentationRegistry
import org.junit.Test

import org.junit.Assert.*

class MainActivityAndroidTest {

    val activity = MainActivity()

    @Test
    fun onCreate() {
        activity.onCreate(null, null)
    }

    @Test
    fun onPostCreate() {
        activity.onPostCreate(null, null)
    }

    @Test
    fun navigate() {
        activity.navigate(activity.findNavController(R.id.imageView), 1)
    }

    @Test
    fun navigate1() {
        activity.navigate(activity.findNavController(R.id.imageView), 1, 12)
    }

    @Test
    fun bindTiles() {
        activity.bindTiles(object : MenuView{
            override fun showList(list: List<MenuItem>) {
                }

            override fun navigate(v: View?) {
                }
        })
    }

    @Test
    fun bindList() {
        activity.bindList(1, object :CustomView{
            override fun showList(list: List<Int>) {
                }

            override fun setTitle(title: Int) {
                }
        })
    }

    @Test
    fun listItemPressed() {
        val navController = activity.findNavController(R.id.imageView)
        activity.listItemPressed(1, navController)
    }

    @Test
    fun tilePressed() {
        val navController = activity.findNavController(R.id.imageView)
        activity.listItemPressed(1, navController)
    }

    @Test
    fun save() {
        activity.save()
    }

    @Test
    fun load() {
        activity.load()
    }
}