package com.yum.sample

import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.yum.sample.repositories.TitlesRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class UITests {


    @Test
    fun test_connection() {
        val activity = MainActivity()
        val li = LayoutInflater.from(activity)
        val promptsView: View = li.inflate(R.layout.login_dialog, null)
        val userInput =
            promptsView.findViewById<View>(R.id.input_text_url) as EditText
        val portInput = promptsView.findViewById<View>(R.id.input_text_port) as EditText
        userInput.setText("localhost")
        portInput.setText("1010")
        activity.showLoginDialog()
        assertEquals("localhost", activity.url)
    }

    @Test
    fun check_not_connection() {
        val activity = MainActivity()
        val li = LayoutInflater.from(activity)
        val promptsView: View = li.inflate(R.layout.login_dialog, null)
        val userInput =
            promptsView.findViewById<View>(R.id.input_text_url) as EditText
        val portInput = promptsView.findViewById<View>(R.id.input_text_port) as EditText
        userInput.setText("localhost")
        portInput.setText("1010")
        activity.showLoginDialog()
        val command = CommandFactory.getCommand(CommandFactory.BUTTON_ID)
        command.execute()
        assertEquals("localhost:1010", activity.getServer())
    }

    @Test
    fun check_titles() {
        val activity = MainActivity()
        val nav = Navigator(activity.findNavController(R.id.components))
        val repo = TitlesRepository()
        for (i in nav.destinations) {
            activity.navigate(activity.findNavController(R.id.components), i.value)
            assertEquals(repo.repository[i.value], activity.gettitle())
        }
    }

    @Test
    fun check_buttons() {
        val activity = MainActivity()
        val nav = Navigator(activity.findNavController(R.id.components))
        for (i in nav.destinations) {
            var n = 0
            activity.navigate(activity.findNavController(R.id.components), i.value)
            if(activity.findViewById<Button>(R.id.disable).isEnabled) n++
            if(activity.findViewById<Button>(R.id.enable).isEnabled) n++
            assertEquals(2, n)
        }
    }

    @Test
    fun check_onBackButtonPressed(){
        val activity = MainActivity()
        val nav = Navigator(activity.findNavController(R.id.components))
        for (i in nav.destinations) {
            activity.navigate(activity.findNavController(R.id.components), i.value)
            activity.supportActionBar?.addOnMenuVisibilityListener { nav.route(R.id.mainMenu) }
            assertEquals(R.id.mainMenu, activity.findNavController(R.id.mainMenu).currentDestination)
        }
    }
}