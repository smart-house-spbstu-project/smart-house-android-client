package com.yum.sample

import android.content.Context
import android.widget.Toast
import java.io.DataOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import kotlin.collections.HashMap

class CommandFactory {

    companion object {
        val BUTTON_ID: Int = 1

        val commandsMap: HashMap<Int, Command> = HashMap()

        init {
            commandsMap[BUTTON_ID] = TurnCommand(0, "", null, false)
        }

        fun getCommand(ID: Int): Command {
            return commandsMap[ID] ?: object : Command() {
                override fun execute() {

                }
            }
        }
    }

    abstract class Command {
        abstract fun execute()
    }

    class TurnCommand(var id: Int, var title: String, var context: Context?, var boo: Boolean) :
        Command() {
        override fun execute() {
            println("Pending id: $id, name: $title")
            val url = ((context ?: MainActivity()) as MainActivity).getServer()
            try {
                val urlObj = URL(url)
                val conn = urlObj.openConnection() as HttpURLConnection
                conn.doOutput = true
                conn.requestMethod = "POST"
                conn.setRequestProperty("Accept-Charset", "UTF-8")
                conn.readTimeout = 10000
                conn.connectTimeout = 15000
                conn.connect()
                val paramsString = title + " " + if (boo) "ON" else "OFF"
                val wr = DataOutputStream(conn.outputStream)
                wr.writeBytes(paramsString)
                wr.flush()
                wr.close()
            } catch (e: IOException) {
                e.printStackTrace()
                Thread.sleep(1000)
                val toast =
                    Toast.makeText(
                        context,
                        "Could not connect to server \n $url",
                        Toast.LENGTH_SHORT
                    )
                toast.show()
            }
        }

    }

}