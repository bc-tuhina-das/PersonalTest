package com.example.personaltest

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
        //saving user and pass to make the request!
        val str1 = intent.getStringExtra("user")
        val str2 = intent.getStringExtra("pass")

        var tV1 = findViewById<TextView>(R.id.textView1)

        //TODO: break this down. read up on Volley's documentation?
        val queue: RequestQueue by lazy {
            Volley.newRequestQueue(this) // Replace 'this' with the context if needed
        }

        makeApiCall("https://friscoisdhacapi.vercel.app/api/info?username=${str1}&password=${str2}", queue, tV1)
    }

    //TODO: why didn't i need a coroutine? take this code and break it down completely via docs, a whiteboard etc

    /*
    * Initial issue: NetworkOnMainThreadException
    */
    fun makeApiCall(url: String, queue: RequestQueue, tV1:TextView) {
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                //now we need to parse the response as a json object and chuck it out onto the screen
                //get the keys and iterate through them, modifying the arr
                val keys = response.keys()
                var tvString = ""
                for (key in keys){
                    tvString += "\n" + key.toString().capitalize() + ": " + response[key].toString()
                }
                tV1.setText(tvString)
            },
            { error ->
                // Handle error here
                error.printStackTrace()
            }
        )
        queue.add(jsonObjectRequest)
    }


}