package com.example.personaltest

import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.Scanner

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val str1 = intent.getStringExtra("user")
        val str2 = intent.getStringExtra("pass")
        //get tv variables
        var tV1 = findViewById<TextView>(R.id.textView1)
        var tV2 = findViewById<TextView>(R.id.textView2)
        APICall("https://apple.com/")


        tV1.setText(str1)
        tV2.setText(str2)
        //Delete eventually


    }


    //TODO: Q: call in first activity or second?
    //TODO: Q: is it better to use a thread or just a regular function?

    fun APICall(inputurl:String){
        //url to store the url for the https request
        var url : URL? = null;
        //strline will store each string being read
        val strLine = ""
        val stream: InputStream? = null
        val scanner: Scanner? = null
        var response = 0

        /*TODO: better understand what a bundle is for. I can't seem to get it.*/
        val bError = Bundle()
        val errMsg = Message()

        try{
            url = URL(inputurl)
            val connection = url.openConnection()
            val HTTPconn = connection as HttpURLConnection
            Log.i("Driver says: ", "This works")
            response = HTTPconn.responseCode
            Log.i("Driver says: ", ""+response)

        }
        catch (e: Exception){
            Log.i("Driver says: ", "This is brocken 💔")
        }
    }
}