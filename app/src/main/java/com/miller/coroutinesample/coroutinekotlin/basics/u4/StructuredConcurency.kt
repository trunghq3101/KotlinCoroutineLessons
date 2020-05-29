package com.miller.coroutinesample.coroutinekotlin.basics.u4

import com.miller.coroutinesample.coroutinekotlin.fastWork
import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() {
    val time = measureTimeMillis {
        runBlocking {
            launch {
                heavyWork(1500)
                println("Data heavyWork loaded")
            }
            fastWork()
            println("Data fastWork loaded")
        }
    }
    println("UI Rendered")
    println("Done in $time ms")
}
