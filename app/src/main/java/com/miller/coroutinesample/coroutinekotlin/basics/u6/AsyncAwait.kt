package com.miller.coroutinesample.coroutinekotlin.basics.u6

import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() {
    val time = measureTimeMillis {
        runBlocking {
            val data1 = async {
                heavyWork(1000)
                1
            }
            val data2 = async {
                heavyWork(1000)
                2
            }
            println("Data loading")
            val result = data1.await() + data2.await()
            println("Result is $result")
        }
    }
    println("Done in $time ms")
}
