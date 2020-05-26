package com.yum.sample.repositories

import com.yum.sample.MenuItem
import com.yum.sample.R
import com.yum.sample.providers.ModelDataProvider

class ButtonsController : ModelDataProvider {
    val menuItems: List<MenuItem> = listOf(
        MenuItem(0, 0, R.string.variables_button),
        MenuItem(1, 0, R.string.text_styles_button),
        MenuItem(2, 0, R.string.colors_button),
        MenuItem(3, 0, R.string.components_button),
        MenuItem(4, 0, R.string.modules_button),
        MenuItem(5, 0, R.string.templates_button)
    )

    override fun provide(key: Int): MenuItem {
        return menuItems[key]
    }
}