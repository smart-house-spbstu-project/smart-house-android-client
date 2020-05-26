package com.yum.sample

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket


class SplashActivity : AppCompatActivity() {

    init {
        if (!isOnline()) {
            val toast = Toast.makeText(applicationContext, "Could not connect to server", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    fun isOnline(): Boolean {
        return try {
            val timeoutMs = 1500
            val sock = Socket()
            val sockaddr = InetSocketAddress("localhost", 8080)
            sock.connect(sockaddr, timeoutMs)
            sock.close()
            true
        } catch (e: IOException) {
            false
        }

    }
}