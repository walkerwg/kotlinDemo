package com.example.myapplication.looper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.example.myapplication.R
import java.util.*
import javax.security.auth.callback.Callback

class LooperActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_looper)

//        Looper.prepare()
        var handler = Handler()
        Thread {

            println("thread is ${Thread.currentThread()}")
            println("请输入内容（输入q退出）")
            var quit = false
            var scanner = Scanner(System.`in`)
            while (scanner.hasNextLine() && !quit) {
                val line = scanner.nextLine()
                println("${Thread.currentThread().name}  输入的:$line")

                handler.sendMessage(Message())

                when (line) {
                    "q" -> {
                        Looper.getMainLooper().quit()
                        quit = true
                    }
                }
            }

        }.also {
            it.name = "子线程"
            it.start()
        }

//        Looper.loop()
    }

}

fun main(args: Array<String>) {
    Looper.prepare()
    val handler = Handler()

    Thread {
        println("请输入内容(输入q退出)")
        val scanner = Scanner(System.`in`)
        var quit = false
        while (scanner.hasNextLine() && !quit) {
            val line = scanner.nextLine()
            println("${Thread.currentThread().name}  输入的:$line")

            handler.sendMessage(Message())

            when (line) {
                "q" -> {
                    Looper.getMainLooper().quit()
                    quit = true
                }
            }
        }

    }.also {
        it.name = "子线程"
        it.start()
    }
    Looper.loop()

}