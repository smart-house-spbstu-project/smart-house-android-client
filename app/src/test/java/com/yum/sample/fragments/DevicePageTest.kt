package com.yum.sample.fragments

import android.view.View
import androidx.navigation.NavController
import com.yum.sample.CustomActivity
import com.yum.sample.CustomView
import com.yum.sample.MenuView
import org.junit.Test

import org.junit.Assert.*

class DevicePageTest {

    val page = DevicePage()
    @Test
    fun setActivity() {
        val activity = object : CustomActivity {

            var testtitle = "test"
            override fun setTitle(titleId: Int) {

            }

            override fun setTitle(title: String) {
                testtitle = title
            }

            override fun gettitle(): String {
                return testtitle
            }

            override fun navigate(navController: NavController, id: Int) {

            }

            override fun navigate(navController: NavController, id: Int, idArg: Int) {

            }

            override fun bindTiles(view: MenuView) {

            }

            override fun bindList(id: Int, fragment: CustomView) {

            }

            override fun listItemPressed(id: Int, navController: NavController) {

            }

            override fun tilePressed(v: View?, view: MenuView) {

            }
        }
        page.activity = activity
        assertEquals(activity.testtitle, page.activity.gettitle())
    }

    @Test
    fun getLayoutId() {
        val layout = 0
        page.layoutId = layout
        assertEquals(layout, page.layoutId)
    }

    @Test
    fun setLayoutId() {
        val layout = 1
        page.layoutId = layout
        assertEquals(layout, page.layoutId)
    }

    @Test
    fun setButtons() {
        page.setButtons(1)
    }

    @Test
    fun onClick() {
        page.onClick(false)
    }
}