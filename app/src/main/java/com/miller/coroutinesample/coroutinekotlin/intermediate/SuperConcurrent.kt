package com.miller.coroutinesample.coroutinekotlin.intermediate

import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() {
    val numberOfConcurrentJobs = 100_000
    measureTimeMillis {
        runBlocking {
            repeat(numberOfConcurrentJobs) {
                launch {
                    heavyWork(1000)
                    println("Data $it loaded")
                }
            }
            println("Data loading")
        }
    }.let {
        println("Created $numberOfConcurrentJobs concurrent jobs in $it ms.")
    }
}
