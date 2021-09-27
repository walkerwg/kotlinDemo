package com.example.myapplication.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        thread {
            Log.i("ThreadActivity", "dddddd" + Thread.currentThread().name)
        }

    }
}