import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    Robot buddy = new Robot("buddy",10);

    @Test
    public void test_Constructor(){
        assertEquals("buddy",buddy.getName());
        assertEquals(10,buddy.getAge());
    }

    @Test
    public void getName(){
        assertEquals("buddy", buddy.getName());
    }

    @Test
    public void isNotWorking(){
        assertFalse(buddy.isWorking());
    }

    @Test
    public void getWorkingMsg() {
        buddy.talkToRobot();
        assertEquals("I am in working mode",buddy.getWorkingMsg());
    }

    @Test()
    @DisplayName("getWorkingMsgFail catch the exception")
    public void getWorkingMsgFail() {
        assertThrows(IllegalStateException.class, () -> {
            buddy.getWorkingMsg();
        });
    }

    @Test()
    public void testName_Fail() {
        assertThrows(IllegalArgumentException.class, () -> {
            Robot chuck = new Robot("");
        });
    }

    @Test public void waitTillWorking() throws InterruptedException {
        buddy.waitTillWorking();
    }

    @Test void timeoutExceeded() {
        assertTimeout(ofMillis(10), () -> {

            buddy.waitTillWorking();
        });
    }

}