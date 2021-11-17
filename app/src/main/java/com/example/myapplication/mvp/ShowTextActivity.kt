package com.example.myapplication.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class ShowTextActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private  lateinit var myPresenter: MyPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_text)

        editText = findViewById(R.id.editTextTextPersonName)
        findViewById<Button>(R.id.button6).apply {
            this.setOnClickListener {
                editText.setText("天气不错哟")
            }
        }

    }
}