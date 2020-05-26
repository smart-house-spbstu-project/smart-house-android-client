package com.yum.sample.providers

interface IdDataProvider {

    fun provide(key: Int) : Int
}