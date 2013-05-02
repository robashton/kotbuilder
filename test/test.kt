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

    spec fun can_create_key_value_pair_with_string() {
        var result = json {
            "name" kv "rob"
        }
        assertEquals(result, "{\"name\":\"rob\"}")
    }

    spec fun can_create_key_value_pair_with_integer() {
        var result = json {
            "name" kv 1337
        }
        assertEquals(result, "{\"name\":1337}")
    }

    spec fun can_create_key_value_pair_with_json_value() {
        var result = json {
            "name" kv {

            }
        }
        assertEquals(result, "{\"name\":{}}")
    }

    spec fun can_create_two_key_value_pair_with_strings() {
        var result = json {
            "name" kv "rob"
            "name" kv "robbie"
        }
        assertEquals(result, "{\"name\":\"rob\",\"name\":\"robbie\"}")
    }

    spec fun can_create_key_value_with_array_value() {
        var result = json {
            "name".array("foo", 1337, {

            })
        }
        assertEquals(result, "{\"name\":[\"foo\",1337,{}]}")
    }
}