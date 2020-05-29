package com.miller.coroutinesample.coroutinekotlin.intermediate

import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import kotlin.system.measureTimeMillis


fun main() {
    val mainThread = newSingleThreadContext("Main thread")
    Dispatchers.setMain(mainThread)
    measureTimeMillis {
        runBlocking {
            launch {
                val job1 = launch {
                    launch {
                        heavyWork(1000)
                        withContext(Dispatchers.Main) {
                            println("Render on ${Thread.currentThread().name}: Data 1")
                        }
                    }
                    launch {
                        heavyWork(1000)
                        withContext(Dispatchers.Main) {
                            println("Render on ${Thread.currentThread().name}: Data 2")
                        }
                    }
                }
                job1.join()
                withContext(Dispatchers.Main) {
                    println("Render UI after data 1 & 2 loaded")
                }
                val job2 = launch {
                    launch {
                        heavyWork(1000)
                        withContext(Dispatchers.Main) {
                            println("Render on ${Thread.currentThread().name}: Data 3")
                        }
                    }
                    launch {
                        heavyWork(1000)
                        withContext(Dispatchers.Main) {
                            println("Render on ${Thread.currentThread().name}: Data 4")
                        }
                    }
                }
                job2.join()
                withContext(Dispatchers.Main) {
                    println("Render UI after data 3 & 4 loaded")
                }
            }
            println("Data loading")
        }
    }.let {
        println("Done in $it ms")
    }
}
