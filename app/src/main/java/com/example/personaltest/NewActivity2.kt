package com.example.personaltest
/*
* This is my initial attempt at making the API call to HAC for user data.
* Some of this is copied over from the API call thread in my MinWeather project.
*/

import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.Scanner
import com.android.volley.RequestQueue
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class NewActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        val str1 = intent.getStringExtra("user")
        val str2 = intent.getStringExtra("pass")
        //get tv variables
        var tV1 = findViewById<TextView>(R.id.textView1)
        APICall("https://apple.com/")

        tV1.setText(str1)
        //Delete eventually
    }


    //TODO: Q: call in first activity or second?
    //TODO: Q: is it better to use a thread or just a regular function?

    fun makeApiCall(url: String) {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            // Your API call logic using libraries like Volley or Retrofit here
            val jsonObjectRequest = JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->
                    // Handle the response here
                    val value = response.getString("value") // Assuming "value" is the key in the response
                    println(value)
                },
                { error ->
                    // Handle error here
                    error.printStackTrace()
                }
            )
        }
    }
    fun APICall(inputurl:String){
        //url to store the url for the https request
        var url : URL? = null;
        //strline will store each string being read
        val strLine = ""
        val stream: InputStream? = null
        val scanner: Scanner? = null
        var response = 0

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