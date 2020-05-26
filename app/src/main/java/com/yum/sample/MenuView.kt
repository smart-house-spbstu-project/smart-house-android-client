package com.yum.sample

import android.view.View

interface MenuView {

    fun showList(list : List<MenuItem>)
    fun navigate(v: View?)
}