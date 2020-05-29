package com.miller.coroutinesample.coroutinekotlin.basics.u1

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {
    GlobalScope.launch {
        println("Launch {} run on ${Thread.currentThread().name}")
        delay(1000)
        println("Data loaded")
    }
    println("UI rendered")
    Thread.sleep(2000)
}
