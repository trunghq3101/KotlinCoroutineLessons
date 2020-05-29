package com.miller.coroutinesample.coroutinekotlin.basics.u3

import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() {
    measureTimeMillis {
        GlobalScope.launch {
            heavyWork(1500)
            println("Data loaded")
        }
        println("UI rendered")
        runBlocking {
            println("Waiting for 2 second")
            delay(2000)
        }
    }.let {
        println("Done in $it ms")
    }
}
