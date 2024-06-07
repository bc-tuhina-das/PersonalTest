package com.example.personaltest

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var user = "";
        var pass = "";

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //TODO: initialize all UI variables here
        val inputBtn = findViewById<Button>(R.id.signInBtn)
        val userTextInput = findViewById<EditText>(R.id.editTextText)
        val passTextInput = findViewById<EditText>(R.id.editTextTextPassword)
//        println("Button ---> " + inputBtn)
//        println("User Input ---> " + userTextInput)
//        println("Pass Input ---> " + passTextInput)


        inputBtn.setOnClickListener(){
            //after signing in, set the values inputted equal to the variables user and pass
            user = userTextInput.text.toString()
            pass = passTextInput.text.toString()
//            println("Username -------> " + user)
//            println("Password -------> " + pass)
            //for today, practice switching activities/views
            val help = NewActivity::class.java
            val intent = Intent(this, help)
            intent.putExtra("user", user)
            intent.putExtra("pass", pass)
            startActivity(intent)
            //eventually, integrate hac api
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        inputBtn.setOnClickListener {
//            val intent = Intent(this, NewActivity::class.java)
//            startActivity(intent)
//        }

    }
}