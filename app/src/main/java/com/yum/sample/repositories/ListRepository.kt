package com.yum.sample.repositories

import com.yum.sample.R
import com.yum.sample.providers.ListDataProvider

class ListRepository : ListDataProvider {

    val repository: HashMap<Int, List<Int>> = HashMap()


    init {
        repository[0] = listOf()
        repository[1] = listOf()
        repository[2] = listOf()
        repository[3] = listOf()
        repository[4] = listOf()
        repository[5] = listOf(R.string.boiler, R.string.rgb_lamp)
    }

    override fun provide(key: Int): List<Int> {
        return repository[key] ?: listOf()
    }
}