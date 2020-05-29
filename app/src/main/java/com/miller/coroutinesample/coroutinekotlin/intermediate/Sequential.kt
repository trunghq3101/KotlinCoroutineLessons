package com.miller.coroutinesample.coroutinekotlin.intermediate

import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() {
    measureTimeMillis {
        runBlocking {
            launch {
                heavyWork(1000)
                println("Data 1 loaded")
                heavyWork(1000)
                println("Data 2 loaded")
                heavyWork(1000)
                println("Data 3 loaded")
                heavyWork(1000)
                println("Data 4 loaded")
            }
            println("Data loading")
        }
    }.let {
        println("Done in $it ms")
    }
}
