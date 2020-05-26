package com.yum.sample

interface Router {

    fun route(labelID: Int)

    fun route(labelID: Int, idArg: Int)
}