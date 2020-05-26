package com.yum.sample.providers

import com.yum.sample.MenuItem

interface ModelDataProvider {

    fun provide(key: Int) : MenuItem
}