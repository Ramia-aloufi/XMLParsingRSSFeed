package com.example.myretrofitexample.model.entry

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import java.io.Serializable

@Root(name = "item", strict = false)
class Item constructor(): Serializable {

    @field:Element(name = "title")
    var title: String? = null

    override fun toString(): String {
        return "Author{" +
                "title='" + title + '\'' +
                '}'
    }
}