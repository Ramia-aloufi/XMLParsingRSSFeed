package com.example.myretrofitexample

import com.example.myretrofitexample.model.RSS
import retrofit2.http.GET
import retrofit2.Call

interface FeedAPI {
    @get:GET("edition_travel.rss")
    val rss: Call<RSS?>?

    companion object {
        const val BASE_URL = "URL: http://rss.cnn.com/rss"
    }
}
