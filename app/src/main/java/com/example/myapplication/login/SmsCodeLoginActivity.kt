package com.example.myapplication.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import android.widget.ImageView
import com.example.myapplication.R
import com.google.android.material.animation.AnimationUtils
import java.util.*
import kotlin.concurrent.schedule

class SmsCodeLoginActivity : AppCompatActivity(), View.OnClickListener {

    private var second: Int = 30 //倒计时
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms_code_login)
        //隐藏顶部actionbar
        supportActionBar.apply {
            this?.hide()
        }
        //载入动画
        val animation =
            android.view.animation.AnimationUtils.loadAnimation(this, R.anim.ani_translate)
        findViewById<ImageView>(R.id.imageView).startAnimation(animation)

        findViewById<Button>(R.id.btn_smscode).apply {
            this.setOnClickListener(this@SmsCodeLoginActivity)
            this.setOnClickListener {
                Timer().schedule(0, 1000) {
                    second--
                    if (second > 0) {
                        (it as Button).text = "${second}s"

                    } else {
                        this.cancel()
                        second = 30
                        (it as Button).text = "重新获取"
                    }
                }
            }
        }
        findViewById<Button>(R.id.btn_pwd_login).apply {
            this.setOnClickListener(this@SmsCodeLoginActivity)
        }
    }

    override fun onClick(v: View?) {


        when (v?.id) {

            R.id.btn_code -> Log.i("ffff", v?.id.toString())
            R.id.btn_pwd_login -> Log.i("ffff", (v as Button).text as String)
        }
    }
}