package com.hightech.unittesting

import androidx.lifecycle.ViewModel

class MainViewModel constructor(private val model: Model) : ViewModel() {

    fun saveData(length: Double, width: Double) {
        model.saveData(length = length, width = width)
    }

    fun getData(): Double = model.getData()

}