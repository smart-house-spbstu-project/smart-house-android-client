package com.yum.sample.fragments

import android.view.LayoutInflater
import androidx.test.InstrumentationRegistry
import com.yum.sample.R
import org.junit.Test

import org.junit.Assert.*

class DevicePageAndroidTest {

    val page = DevicePage()
    @Test
    fun onCreateView() {
        val inf = LayoutInflater.from(InstrumentationRegistry.getInstrumentation().context)
        val view = page.onCreateView(
            inf,
            null,
            null
        )
        val view1 = inf.inflate(R.layout.device_page, null, false)
        assertEquals(view1?.layoutDirection, view?.layoutDirection)
    }

    @Test
    fun onViewCreated() {
        val inf = LayoutInflater.from(InstrumentationRegistry.getInstrumentation().context)
        val view1 = inf.inflate(R.layout.device_page, null, false)
        page.onViewCreated(view1, null)
    }
}