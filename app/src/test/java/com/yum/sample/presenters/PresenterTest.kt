package com.yum.sample.presenters

import android.view.View
import androidx.navigation.NavController
import com.yum.sample.CustomActivity
import com.yum.sample.CustomView
import com.yum.sample.MenuView
import com.yum.sample.repositories.ButtonsController
import com.yum.sample.repositories.ListRepository
import com.yum.sample.repositories.TitlesRepository
import org.junit.Test

import org.junit.Assert.*

class PresenterTest {

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
    fun getListRepo() {
        val value1 = presenter.listRepo.provide(0)
        val value2 = ListRepository().provide(0)
        assertEquals(value1, value2)
    }

    @Test
    fun getMenuRepo() {
        val value1 = presenter.menuRepo.provide(0).id
        val value2 = ButtonsController().provide(0).id
        assertEquals(value1, value2)
    }

    @Test
    fun getTitlesRepo() {
        val value1 = presenter.titlesRepo.repository[0]
        val value2 = TitlesRepository().repository[0]
        assertEquals(value1, value2)
    }

    @Test
    fun onBindTitle() {
        presenter.onBindTitle(1)
        val title = TitlesRepository().repository[1]
        assertEquals(presenter.activity.gettitle(), title)
    }

    @Test
    fun getActivity() {
        val test = object : CustomActivity {

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
        }.testtitle
        assertEquals(presenter.activity.gettitle(), test)
    }
}