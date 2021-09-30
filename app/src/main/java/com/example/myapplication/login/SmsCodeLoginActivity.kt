package com.example.myapplication.login

import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.View.FOCUSABLE
import android.view.View.NOT_FOCUSABLE
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import java.util.*
import kotlin.concurrent.schedule

class SmsCodeLoginActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener,
    TextWatcher {

    private var second: Int = 30 //倒计时

    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    private lateinit var editText4: EditText

    private var whoHasFocus = 1
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
        //焦点监听
        addTextListener()
    }

    private fun addTextListener() {
        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)

        editText1?.addTextChangedListener(this)
        editText1.onFocusChangeListener = this
        editText2?.addTextChangedListener(this)
        editText2.onFocusChangeListener = this

        editText3?.addTextChangedListener(this)
        editText3.onFocusChangeListener = this

        editText4?.addTextChangedListener(this)
        editText4.onFocusChangeListener = this

    }

    override fun onClick(v: View?) {


        when (v?.id) {

            R.id.btn_code -> Log.i("ffff", v?.id.toString())
            R.id.btn_pwd_login -> Log.i("ffff", (v as Button).text as String)
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        Log.i("sss", "onTextChanged")

        when (whoHasFocus) {
            1 -> {
                if (s?.length == 1) {
                    editText2.focusable = FOCUSABLE
                    editText2.requestFocus()
                    editText2.findFocus()
                }
            }
            2 -> {
                if (s?.length == 0) {
                    editText1.focusable = FOCUSABLE
                    editText1.requestFocus()
                    editText1.findFocus()
                }
                if (s?.length == 1) {
                    editText3.focusable = FOCUSABLE
                    editText3.requestFocus()
                    editText3.findFocus()
                }
            }
            3 -> {
                if (s?.length == 0) {
                    editText2.focusable = FOCUSABLE
                    editText2.requestFocus()
                    editText2.findFocus()
                }
                if (s?.length == 1) {
                    editText4.focusable = FOCUSABLE
                    editText4.requestFocus()
                    editText4.findFocus()
                }
            }
            4 -> {
                if (s?.length == 0) {
                    editText3.focusable = FOCUSABLE
                    editText3.requestFocus()
                    editText3.findFocus()
                }
            }

        }
    }

    override fun afterTextChanged(s: Editable?) {
        Log.i("sss", "afterTextChanged")

    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        when (v?.id) {
            R.id.editText1 -> {
                whoHasFocus = 1
            }
            R.id.editText2 -> {
                whoHasFocus = 2
            }
            R.id.editText3 -> {
                whoHasFocus = 3
            }
            R.id.editText4 -> {
                whoHasFocus = 4
            }

        }
    }


}