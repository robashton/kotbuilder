/**
 * Created with IntelliJ IDEA.
 * User: robashton
 * Date: 02/05/13
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */

import java.util.HashMap
import java.util.List
import java.util.ArrayList
import java.util.Arrays

class Json () {

    var builder = StringBuilder()
    var hasSeenFields = false

    private fun insertPotentialComma() {
        if(hasSeenFields)
            builder.append(",")
        hasSeenFields = true
    }


    fun String.array(vararg value : Any) {
        insertPotentialComma()
        builder.append("\"$this\":")
        builder.append("[")

        var elements = ArrayList<String>()

        for(i in value) {
            when(i) {
                is Int ->
                    elements.add(i.toString())
                is String ->
                    elements.add("\"$i\"")
                is Function0<*> -> {
                    var subObject = Json()
                    i.invoke()
                    elements.add(subObject.toString())
                }
                else -> {
                    throw Exception("OMG NO!")
                }
            }
        }
        builder.append(elements.makeString(","))
        builder.append("]")

    }

    fun String.rangeTo(value: Int) : Int {
        insertPotentialComma()
        builder.append("\"$this\":$value")
        return 0
    }

    fun String.rangeTo(content: Json.() -> Unit) : Int {
        insertPotentialComma()
        var subObject = Json()
        subObject.content()
        builder.append("\"$this\":${subObject.toString()}")
        return 0
    }


    fun String.rangeTo(a: String) : Int {
        insertPotentialComma()
        builder.append("\"$this\":\"$a\"")
        return 0
    }


    fun toString() : String  {
        return "{" +  builder.toString() + "}"
    }
}

fun json(content: Json.() -> Unit) : String {
    var json = Json()
    json.content()
    return json.toString()
}

