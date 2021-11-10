package com.example.myapplication.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.example.myapplication.R
import kotlin.concurrent.thread

class ThreadActivity : AppCompatActivity() {

     @Volatile private var flag = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)
        Log.i("ThreadActivity", "ssssss" + Thread.currentThread().name)

        thread {
            Log.i("ThreadActivity", "dddddd" + Thread.currentThread().name)
        }
        testVolatileProperty()

    }


    private fun testVolatileProperty() {

        thread {

            while (!flag) {
                Log.i("ThreadActivity", "eeeeee" + Thread.currentThread().name)

            }
            Log.i("ThreadActivity", "fffff" + Thread.currentThread().name)
        }

        Thread.sleep(200)
        thread {
            flag = true
            Log.i("ThreadActivity", "ssssss" + Thread.currentThread().name)

        }
    }


}