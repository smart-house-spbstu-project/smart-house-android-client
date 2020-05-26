package com.yum.sample

import android.view.View
import androidx.navigation.NavController

interface CustomActivity {

    fun setTitle(titleId: Int)
    fun setTitle(title: String)
    fun gettitle(): String
    fun navigate(navController: NavController, id: Int)
    fun navigate(navController: NavController, id: Int, idArg: Int)
    fun bindTiles(view: MenuView)
    fun bindList(id: Int, fragment: CustomView)
    fun listItemPressed(id: Int, navController: NavController)
    fun tilePressed(v: View?, view: MenuView)
}