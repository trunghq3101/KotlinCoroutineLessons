package com.miller.coroutinesample.coroutinekotlin

import kotlinx.coroutines.delay

suspend fun heavyWork(delayTime: Long = 1000) {
    delay(delayTime)
}

suspend fun fastWork() {
    delay(100)
}
