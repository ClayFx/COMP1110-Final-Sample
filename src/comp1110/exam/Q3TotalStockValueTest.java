package comp1110.exam;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertTrue;

/**
 * COMP1110 Final Exam, Question 3ii
 */
public class Q3TotalStockValueTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(500);

    // FIXME add one ore more JUnit unit tests that test the totalStockValue() method of the Q3SimpleStockManager class.
    @Test
    public void TestSimple(){
        Q3SimpleStockManager sm = new Q3SimpleStockManager();
        sm.newItem("1234", "Jam", 3);
        sm.addStock("1234", 100);
        sm.newItem("5678", "Coffee", 4);
        sm.addStock("5678", 50);
        double value = sm.totalStockValue();
        assertTrue("Experted 500 but get" + value, value==500 );
    }
}
