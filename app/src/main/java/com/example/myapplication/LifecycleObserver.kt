package com.example.myapplication

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class LifecycleObserver<T:AppCompatActivity>() : DefaultLifecycleObserver {

    lateinit var atv: T
    fun register(tv: T) {
        atv = tv
        tv.lifecycle.addObserver(this)
    }
    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        Log.d("~~~~","onCreate")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        Log.d("~~~~","onPause")

    }
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        Log.d("~~~~","onDestroy")
    }
}