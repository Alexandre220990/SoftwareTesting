import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

class DriverTest {
    Driver driver = new Driver("buddy", 12345);

    @Test
    public void getName(){
        assertEquals("buddy", driver.getDriverName());
    }

    @Test
    public void getNameFail(){
        assertThrows(IllegalArgumentException.class, () -> {
            Driver Driver2 = new Driver("", 12345);
        });
    }

    @Test
    public void getNum(){
        assertEquals(12345, driver.getDriverNum());
    }

    @Test
    public void getNumFail(){
        assertThrows(IllegalArgumentException.class, () -> {
            Driver Driver3 = new Driver("John", 12);
        });
    }

    @Test
    public void checkStatus(){
        assertFalse(driver.check_status());
    }

    @Test public void waitTillWorking() throws InterruptedException {
        driver.waitTillbanned();
    }

    @Test
    public void timeoutExceeded() {
        assertTimeout(ofMillis(10), () -> {
            driver.waitTillbanned();
        });
    }
}

