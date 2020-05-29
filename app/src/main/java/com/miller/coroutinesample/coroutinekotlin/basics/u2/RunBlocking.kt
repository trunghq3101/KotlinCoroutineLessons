package com.miller.coroutinesample.coroutinekotlin.basics.u2

import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking {
        println("runBlocking run on ${Thread.currentThread().name}")
        heavyWork()
        println("Data loaded")
    }
    println("UI rendered")
}
