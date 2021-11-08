package com.example.myapplication.binder.service

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.myapplication.R
import com.example.myapplication.tab.TabActivity

class ServiceActivity : AppCompatActivity() {

    private val TAG = "ServiceActivity"

    private var serviceIntent: Intent = Intent()

    private  var bindRemoteService: BindRemoteService? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        bindService()
        findViewById<Button>(R.id.button2).apply {

            this.setOnClickListener {
                serviceIntent.setClass(this@ServiceActivity, RemoteService().javaClass)
                serviceIntent.putExtra("from", "ServiceAcitity通过intent传递的数据")
                startService(serviceIntent)
            }
        }

        findViewById<Button>(R.id.button3).apply {

            this.setOnClickListener {
                stopService(serviceIntent)
            }
        }

        findViewById<Button>(R.id.button4).apply {

            this.setOnClickListener {
               bindRemoteService?.playMusic()
            }
        }

        findViewById<Button>(R.id.button5).apply {

            this.setOnClickListener {
                bindRemoteService?.pauseMusic()
            }
        }
    }

    private fun bindService() {
        val intent = Intent()
//        intent.setClass(this, BindRemoteService().javaClass)
        intent.setAction("com.example.myapplication")
        intent.setPackage("com.example.myapplication")
        intent.putExtra("from", "{'name':'ServiceActivity'}")

        bindService(intent, object : ServiceConnection {
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
               Log.i(TAG,"--onServiceConnected--")
                bindRemoteService = (service as BindRemoteService.MyBinder).getRemoteService()

            }

            override fun onServiceDisconnected(name: ComponentName?) {
                Log.i(TAG,"--onServiceDisconnected--")
            }

        }, BIND_AUTO_CREATE)
    }


    public interface WGPrint {

        fun print() {}
    }

}