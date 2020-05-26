package com.yum.sample.components

import androidx.test.InstrumentationRegistry.getInstrumentation
import com.yum.sample.MenuItem
import com.yum.sample.R
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.menu_button.view.*
import org.junit.Before
import org.junit.Test

class MenuButtonTest {

    lateinit var button : MenuButton
    lateinit var model : MenuItem

    @Before
    fun init(){
        button = MenuButton(getInstrumentation().context, null)
        model = MenuItem(0, 0, R.string.variables_button)
        button.bind(model)
    }

    @Test
    fun getModel() {
        assertEquals(model.id, button.model?.id)
    }

    @Test
    fun setModel() {
        button.bind(MenuItem(1,1,R.string.variables_button))
        assertEquals(1, button.model?.id)
    }

    @Test
    fun bind() {
        button.bind(MenuItem(2,2,R.string.variables_button))
        assertEquals(2, button.model?.id)
    }

    @Test
    fun setEnabled() {
        button.setEnabled(false)
        assertEquals(false,button.button_text.isEnabled)
    }
}