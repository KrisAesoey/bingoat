package com.zorac.model

class Cell(val value: String, var isInitialized: Boolean = false) {
    override fun toString(): String {
        return value
    }

}