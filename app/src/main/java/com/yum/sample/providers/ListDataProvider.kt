package com.yum.sample.providers

interface ListDataProvider {
    fun provide(key: Int) : List<Int>
}