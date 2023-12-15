package com.example.mvvmpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var incrementBtn: Button
    private lateinit var counterText: TextView
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycle.addObserver(MainActivityObserver())
        Log.d("Main", "onCreate: MainActivity")
        mainViewModel = ViewModelProvider(this, MainActivityViewModelFactory(1))[MainViewModel::class.java]
        counterText = findViewById(R.id.counter)
        incrementBtn = findViewById(R.id.incrementBtn)
        incrementBtn.setOnClickListener(this)
        setText()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.incrementBtn -> {
                mainViewModel.increment()
                setText()
            }
        }
    }

    private fun setText() {
        counterText.text = mainViewModel.counter.toString()
    }
}
