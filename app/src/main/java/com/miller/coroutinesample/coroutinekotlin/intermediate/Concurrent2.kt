package com.miller.coroutinesample.coroutinekotlin.intermediate

import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() {
    measureTimeMillis {
        runBlocking {
            launch {
                val job1 = launch {
                    launch {
                        heavyWork(1000)
                        println("Data 1 loaded")
                    }
                    launch {
                        heavyWork(1000)
                        println("Data 2 loaded")
                    }
                }
                job1.join()
                val job2 = launch {
                    launch {
                        heavyWork(1000)
                        println("Data 3 loaded")
                    }
                    launch {
                        heavyWork(1000)
                        println("Data 4 loaded")
                    }
                }
                job2.join()
            }
            println("Data loading")
        }
    }.let {
        println("Done in $it ms")
    }
}
