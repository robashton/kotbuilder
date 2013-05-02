/**
 * Created with IntelliJ IDEA.
 * User: robashton
 * Date: 02/05/13
 * Time: 13:36
 * To change this template use File | Settings | File Templates.
 */

import org.junit.Test as spec
import kotlin.test.*


public class SomeTest {
    spec fun can_pass_in_empty_literal() {
        var result = json {

        }
        assertEquals(result, "{}")
    }

    spec fun can_pass_in_key_value_pair() {
        var result = json {
            kv("foo", "bar")

            kv("goo2", {
                kv("hello", "hello2")
            })
        }
        assertEquals(result, "\"foo\":\"bar\"")
    }
}