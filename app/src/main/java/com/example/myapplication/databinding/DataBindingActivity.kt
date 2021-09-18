package com.example.myapplication.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R

class DataBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        DataBindingUtil.setContentView<ActivityDataBindingImpl>(this,R.layout.activity_data)
            .apply {
                name = "绑定的数据:ffffff"
            }
    }
}