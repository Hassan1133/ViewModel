package com.example.mvvmpractice

import androidx.lifecycle.ViewModel

class MainViewModel(private val counterData : Int) : ViewModel() {
    var counter : Int = counterData
    fun increment()
    {
        counter++
    }
}