package com.example.personaltest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val str1 = intent.getStringExtra("user")
        val str2 = intent.getStringExtra("pass")
        println("HOORAY! YOUR USER IS -----> " + str1)
        println("HOORAY! YOUR PASS IS -----> " + str2)
    }
}