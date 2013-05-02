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
    spec fun can_create_builder() {
       var builder = JsonBuilder()
       assertNotNull(builder)
    }
}