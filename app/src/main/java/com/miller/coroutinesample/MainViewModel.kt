package com.miller.coroutinesample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miller.coroutinesample.coroutinekotlin.heavyWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

class MainViewModel : ViewModel() {

    val loadingText = MutableLiveData<String>()

    fun loadData() {
        viewModelScope.launch {
            loadingText.value = "Loading on ${Thread.currentThread().name}"

            var data = 0
            val time = measureTimeMillis {
                data = withContext(Dispatchers.IO) {
                    println("Data loading on ${Thread.currentThread().name}")
                    heavyWork(10_000)
                    1
                }
            }

            loadingText.value = "Loaded $data in $time ms"
        }
    }
}
