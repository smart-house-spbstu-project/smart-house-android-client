package com.yum.sample.repositories

class TitlesRepository {
    val repository: HashMap<Int, String> = HashMap()

    init{
        repository[0] = "Lamp"
        repository[1] = "Door"
        repository[2] = "Window"
        repository[3] = "Fire Alarm"
        repository[4] = "Firefighting"
        repository[5] = "Others"
    }
}