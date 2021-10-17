package com.example.myretrofitexample.model.entry

import com.example.myretrofitexample.model.entry.Item
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "channel", strict = false)
class Channel @JvmOverloads constructor(
//    @field:Element(name = "content")
//    @param:Element(name = "content")
//    var content: String? = null,

//    @field:Element(required = false, name = "item")
//    @param:Element(name = "item")
//    var item: Item? = null,


    @field:ElementList(inline = true, name = "item")
    var item: List<Item>? = null

) : Serializable {


}