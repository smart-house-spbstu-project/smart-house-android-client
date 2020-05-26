package com.yum.sample

import com.yum.sample.CommandFactory.Companion.BUTTON_ID
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class CommandFactoryTest {

    @Test
    fun getCommand() {
        assertTrue(CommandFactory.getCommand(BUTTON_ID) is CommandFactory.TurnCommand)
    }

    @Test
    fun getFalseCommand() {
        assertFalse(CommandFactory.getCommand(20) is CommandFactory.TurnCommand)
    }

    @Test
    fun executeCommand() {
        CommandFactory.getCommand(BUTTON_ID).execute()
    }

    @Test
    fun turnCommandExec() {
        CommandFactory.TurnCommand(0, "", null, false).execute()
    }

}
