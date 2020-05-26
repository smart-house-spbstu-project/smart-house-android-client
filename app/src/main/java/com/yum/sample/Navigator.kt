package com.yum.sample

import android.os.Bundle
import androidx.navigation.NavController

class Navigator(val navController: NavController) : Router {

    val destinations: HashMap<Int, Int> = HashMap()
    val layouts: HashMap<Int, Int> = HashMap()

    init {
        destinations[R.id.textStyles] = R.id.action_mainMenu_to_pageFragment
        destinations[R.id.templates] = R.id.action_mainMenu_to_fragmentList
        destinations[R.id.variables] = R.id.action_mainMenu_to_pageFragment
        destinations[R.id.colors] = R.id.action_mainMenu_to_pageFragment
        destinations[R.id.components] = R.id.action_mainMenu_to_pageFragment
        destinations[R.id.modules] = R.id.action_mainMenu_to_pageFragment

        layouts[0] = 0
        layouts[1] = 1
        layouts[2] = 2
        layouts[3] = 3
        layouts[4] = 4
        layouts[5] = 5
    }

    override fun route(labelID: Int) {
        if (destinations[labelID] != null)
            navController.navigate(
                destinations[labelID] ?: R.id.action_fragmentList_to_pageFragment
            )
    }

    override fun route(labelID: Int, idArg: Int) {
        if (destinations[labelID] != null) {
            val args = Bundle()
            if (layouts[idArg] != null)
                args.putInt("button_id", layouts[idArg] ?: 0)
            else
                args.putInt("button_id", idArg)
            navController.navigate(
                destinations[labelID] ?: R.id.action_fragmentList_to_pageFragment, args
            )
        }
    }
}