/*
* Made by Tuhina Das, June 2024.
*
* This is a quick project to better understand making API calls in Kotlin.
* The app uses an API to access student data from Powerschool's Home Access Center (HAC) software.
* Learn more about the API here: https://friscoisdhacapi.vercel.app/
*/
package com.example.personaltest

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.Scanner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //variables for username and password input
        var user = "";
        var pass = "";

        //TODO: good idea to be able to explain this
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //initialize all UI variables
        val inputBtn = findViewById<Button>(R.id.signInBtn)
        val userTextInput = findViewById<EditText>(R.id.editTextText)
        val passTextInput = findViewById<EditText>(R.id.editTextTextPassword)


        inputBtn.setOnClickListener(){
            //after signing in, set the values inputted equal to the variables user and pass
            user = userTextInput.text.toString()
            pass = passTextInput.text.toString()
            //create an intent to move to the second activity
            val help = NewActivity::class.java
            val intent = Intent(this, help)
            intent.putExtra("user", user)
            intent.putExtra("pass", pass)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}