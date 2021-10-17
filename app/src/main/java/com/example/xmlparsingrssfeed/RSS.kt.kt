package com.example.myretrofitexample.model

import com.example.myretrofitexample.model.entry.Channel
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import retrofit2.http.Field
import retrofit2.http.GET
import java.io.Serializable


@Root(name = "rss", strict = false)
class RSS constructor() : Serializable   {


    @field:ElementList(inline = true, name = "channel")
    var channel: List<Channel>? = null


}