/**
 * Created with IntelliJ IDEA.
 * User: robashton
 * Date: 02/05/13
 * Time: 13:31
 * To change this template use File | Settings | File Templates.
 */

class JsonBuilder {

}

class Json

fun json() {

}

fun kv(key: Any, value: Any) {}

fun kv(key: Any, value: Json.() -> Unit) : Json {
    val json = Json()
    json.value()
    return json;
}

fun tst() {
    kv("sheep") {

    }
}
