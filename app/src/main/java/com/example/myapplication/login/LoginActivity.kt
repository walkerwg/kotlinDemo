package com.example.myapplication.login

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.bumptech.glide.Glide
import com.example.myapplication.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.net.URLEncoder
import kotlin.coroutines.Continuation

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //隐藏顶部actionbar
        supportActionBar.apply {
            this?.hide()
        }
        startRequest()

        findViewById<Button>(R.id.btn_code).apply {
            this.setOnClickListener {
                val intent = Intent()
                intent.setClass(this.context,SmsCodeLoginActivity().javaClass)
                startActivity(intent)
            }
        }
    }


    fun startRequest() {

        GlobalScope.launch {
            Log.i("LogActivity", "sss thead is ${Thread.currentThread().name}")
        }

        Log.i("LogActivity", "bbb thead is ${Thread.currentThread().name}")

    }


}
