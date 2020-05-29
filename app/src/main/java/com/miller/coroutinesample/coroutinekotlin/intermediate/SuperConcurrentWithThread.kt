package com.miller.coroutinesample.coroutinekotlin.intermediate

import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis


fun main() {
    val numberOfConcurrentJobs = 100_000
    val time = measureTimeMillis {
        (0..numberOfConcurrentJobs).forEach {
            thread {
                sleep(1000)
                println("Data $it loaded")
            }
        }
    }
    println("Created $numberOfConcurrentJobs concurrent jobs in $time ms.")
}
