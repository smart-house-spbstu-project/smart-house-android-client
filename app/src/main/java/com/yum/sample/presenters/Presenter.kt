package com.yum.sample.presenters

import android.view.View
import androidx.navigation.NavController
import com.yum.sample.*
import com.yum.sample.components.MenuButton
import com.yum.sample.repositories.ListRepository
import com.yum.sample.repositories.ButtonsController
import com.yum.sample.repositories.TitlesRepository

class Presenter(val activity: CustomActivity) {

    val listRepo: ListRepository = ListRepository()
    val menuRepo: ButtonsController = ButtonsController()
    val titlesRepo: TitlesRepository = TitlesRepository()

    fun onNavigate(navController: NavController, destinationId: Int) {
        val navigator = Navigator(navController)
        navigator.route(destinationId)
    }

    fun onNavigate(navController: NavController, destinationId: Int, idArg: Int) {
        val navigator = Navigator(navController)
        navigator.route(destinationId, idArg)
        onBindTitle(idArg)
    }

    fun onBindTiles(view: MenuView) {
        view.showList(menuRepo.menuItems)
    }

    fun onListItemClick(id: Int, navController: NavController) {
        onNavigate(navController, id)
    }

    fun onTileClick(v: View?, view: MenuView) {
        v as MenuButton
        view.navigate(v)
    }

    fun onBindTitle(id: Int) {
        activity.setTitle(titlesRepo.repository[id] ?: "")
    }

    fun onBindList(id: Int, fragment: CustomView) {
        fragment.showList(listRepo.repository[id] ?: listOf())
    }
}