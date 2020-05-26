package com.yum.sample

import android.view.View
import androidx.navigation.NavController
import com.yum.sample.presenters.Presenter
import org.junit.Test

import org.junit.Assert.*

class MainActivityTest {

    val activity = MainActivity()
    val presenter = Presenter(object : CustomActivity {

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
    })

    @Test
    fun getPresenter() {
        val val1 = activity.presenter.listRepo.provide(0)
        val val2 = presenter.listRepo.provide(0)
        assertEquals(val1, val2)
    }

    @Test
    fun getUrl() {
        assertEquals("", activity.url)
    }

    @Test
    fun setUrl() {
        activity.url = "test"
        assertEquals("test", activity.url)
    }

    @Test
    fun getPort() {
        assertEquals(0, activity.port)
    }

    @Test
    fun setPort() {
        activity.port = 1
        assertEquals(1, activity.port)
    }

    @Test
    fun getServer() {
        val url = ""
        val port = 0
        val serv = "$url:$port"
        assertEquals(serv, activity.getServer())
    }
    /* ANDROID API TESTS
     @Test
    fun setTitle() {
        activity.title = "120"
        assertEquals("120", activity.title)
    }

    @Test
    fun gettitle() {
        activity.title = ""
        assertEquals("", activity.title)
    }
     */
}