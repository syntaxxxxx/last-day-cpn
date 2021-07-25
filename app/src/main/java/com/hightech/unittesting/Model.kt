package com.hightech.unittesting

class Model {

    private var length: Double = 0.0
    private var width: Double = 0.0

    fun saveData(length: Double, width: Double) {
        this.length = length
        this.width = width
    }

    fun getData(): Double = length * width

}