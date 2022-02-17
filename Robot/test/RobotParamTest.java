import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotParamTest {

    private String expected;
    private int age;

    @ParameterizedTest
    @CsvSource({"4,10000.00", "9,7500.00", "25,5000.00"})
    void testcheckcostAll( int age,Double expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkCost() );
    }

    //test from robot class
    @ParameterizedTest
    @CsvSource({"10,Age ok", "20,Age ok", "25,Too old"})
    void testcheckageAll( int age, String expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkage() );
    }

    //test from a file
    @ParameterizedTest
    @CsvFileSource(resources ="ParamTestFile.csv", numLinesToSkip = 1 )
    void testcheckageAll2( int age, String expected) {
        Robot buddy = new Robot("buddy", age);
        assertEquals(expected, buddy.checkage() );
    }

}