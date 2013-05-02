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
import jet.runtime.typeinfo.JetMethod
import java.util.Arrays

class Json () {

    var builder = StringBuilder()
    var hasSeenFields = false

    private fun insertPotentialComma() {
        if(hasSeenFields)
            builder.append(",")
        hasSeenFields = true
    }

    fun kv(key: String, value: String) {
        insertPotentialComma()
        builder.append("\"$key\":\"$value\"")
    }

    fun kv(key: String, value: Int) {
        insertPotentialComma()
        builder.append("\"$key\":$value")
    }

    fun kv(key: String, vararg value : Any) {
        insertPotentialComma()
        builder.append("\"$key\":")
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

    fun Int.renderJsonInterpretation(builder: StringBuilder) {
        builder.append(this)
    }

    fun String.renderJsonInterpretation(builder: StringBuilder) {
        builder.append("\"$this\"")
    }

    fun kv(key: String, content: Json.() -> Unit) {
        insertPotentialComma()
        var subObject = Json()
        subObject.content()
        builder.append("\"$key\":${subObject.toString()}")
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

