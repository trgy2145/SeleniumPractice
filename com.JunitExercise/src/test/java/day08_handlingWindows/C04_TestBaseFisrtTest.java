package day08_handlingWindows;

import org.junit.Test;
import utilities.ReusableMethod;
import utilities.TestBase;

public class C04_TestBaseFisrtTest extends TestBase {


    @Test
    public void test01(){
        // amazona gidin
        driver.get("https://www.amazon.com");
        ReusableMethod.wait(3);


    }
}
