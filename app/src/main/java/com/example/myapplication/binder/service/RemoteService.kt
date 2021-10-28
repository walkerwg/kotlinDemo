package com.example.myapplication.binder.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class RemoteService : Service(),ServiceActivity.WGPrint {

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        Log.i("RemoteService","--intent-- " + intent?.extras?.get("from"))
        Thread(MyRun()).start()
        return  START_NOT_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("RemoteService","--onCreate-- ")


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("RemoteService","--onDestroy-- ")

    }

    private  class MyRun: Runnable {
        override fun run() {
            Log.i("RemoteService",Thread.currentThread().name)
            Log.i("RemoteService","耗时操作最好在开辟子线程")


        }

    }

    override fun print() {
        print("哈哈哈哈")
    }
}