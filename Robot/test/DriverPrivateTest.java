import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class DriverPrivateTest {
    @Test
    public void testsetAgeMethod() throws Exception {

        System.out.println("setAgeMethod");

        /* Set up a new Robot */
        Driver target = new Driver("robbie", 100);

        /* get the setAge method details */
        Method method = Driver.class.getDeclaredMethod("setDriverNum", int.class);

        /* make the method assessible */
        method.setAccessible(true);

        /* invoke the method setAge with the value 7 */
        method.invoke(target, 170);

        /*access the field age and check its value is set to 7*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("driverNum");

        f.setAccessible(true);

        int result = f.getInt(target);
        System.out.println("The  is " + f.get(target)); assertEquals( 170, result);
    }

}