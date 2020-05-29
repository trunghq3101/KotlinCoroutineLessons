package com.miller.coroutinesample.coroutinekotlin.basics.u5

import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis


fun main() {
    var time = 0L
    GlobalScope.launch {
        time = measureTimeMillis {
            val job = GlobalScope.launch {
                heavyWork()
                println("Data loaded")
            }
            println("UI rendered")
            job.join()
        }
    }
    Thread.sleep(3000)
    println("Done in $time ms")
}
