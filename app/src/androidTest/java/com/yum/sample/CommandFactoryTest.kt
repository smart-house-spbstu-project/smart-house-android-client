package com.yum.sample

import com.yum.sample.CommandFactory.Companion.BUTTON_ID
import org.junit.Assert.assertTrue
import org.junit.Test

class CommandFactoryTest{

    @Test
    fun getCommand(){
        assertTrue(CommandFactory.getCommand(BUTTON_ID) is CommandFactory.TurnCommand)
    }
    @Test
    fun executeCommand(){
        CommandFactory.getCommand(BUTTON_ID).execute()
    }

}
