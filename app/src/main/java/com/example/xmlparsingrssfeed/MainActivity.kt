package com.example.myretrofitexample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import android.widget.Toast
import com.example.myretrofitexample.model.RSS
import com.example.xmlparsingrssfeed.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
var tt = ""
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val BASE_URL = "http://rss.cnn.com/rss/"

    lateinit var tvTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvTitle = findViewById(R.id.tvTitle)


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
        val feedAPI = retrofit.create(FeedAPI::class.java)
        val call = feedAPI.rss

        call!!.enqueue(object : Callback<RSS?> {
            override fun onResponse(call: Call<RSS?>, response: Response<RSS?>) {
                Log.d(TAG, "onResponse: feed: " + response.body().toString())
                Log.d(TAG, "onResponse: Server Response: $response")
                val entries = response.body()!!.channel
                for (entry in entries!!) {
                    Log.d(TAG, "onResponse: " + entry.item)
                    var rr = entry.item
                    for (r in rr!!) {
                        var titleee = r.title
                        tt += "$titleee\n\n"

                    }
                }
                tvTitle.text = tt
            }

            override fun onFailure(call: Call<RSS?>, t: Throwable) {
                Log.e(TAG, "onFailure: Unable to retrieve RSS: " + t.message)
                Toast.makeText(this@MainActivity, "An Error Occured", Toast.LENGTH_SHORT).show()
            }
        })

    }

}


