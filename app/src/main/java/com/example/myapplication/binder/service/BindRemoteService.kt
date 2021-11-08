package com.example.myapplication.binder.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class BindRemoteService : Service() {

    private val TAG = "BindRemoteService"
    private val binder = MyBinder()
    override fun onBind(intent: Intent?): IBinder? {

        return binder
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG, "--onCreate--")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "--onDestroy--")

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "--onStartCommand--startId == $startId")
        return super.onStartCommand(intent, flags, startId)
    }


    public fun playMusic() {

        Log.i(TAG, "--playMusic--")

    }

    public fun pauseMusic() {
        Log.i(TAG, "--pauseMusic--")

    }

    public class MyBinder : Binder() {

        public fun getRemoteService(): BindRemoteService {

            return BindRemoteService()
        }
    }

}