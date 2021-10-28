package com.example.myapplication.binder.service

import android.app.Service
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class ServiceActivity : AppCompatActivity() {


    private var serviceIntent: Intent = Intent()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        findViewById<Button>(R.id.button2).apply {

            this.setOnClickListener {
                serviceIntent.setClass(context, RemoteService().javaClass)
                serviceIntent.putExtra("from", "ServiceAcitity通过intent传递的数据")
                startService(serviceIntent)
            }
        }

        findViewById<Button>(R.id.button3).apply {

            this.setOnClickListener {
                stopService(serviceIntent)
            }
        }
    }

    public interface WGPrint {

        fun print() {}
    }

}