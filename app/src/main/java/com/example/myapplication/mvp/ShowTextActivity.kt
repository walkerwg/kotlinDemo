package com.example.myapplication.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.example.myapplication.R
import java.io.FileInputStream

class ShowTextActivity : AppCompatActivity(),IShowView {

    private lateinit var editText: EditText
    private  lateinit var myPresenter: MyPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)
        myPresenter = MyPresenter(this)
        editText = findViewById(R.id.editTextTextPersonName)
        findViewById<Button>(R.id.button6).apply {
            this.setOnClickListener {
               myPresenter.showText("天气真香")
            }
        }

        findViewById<Button>(R.id.button7).apply {
            this.setOnClickListener {
            }
        }
    }

    override fun showText(text: String) {
       editText.setText(text)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }
}