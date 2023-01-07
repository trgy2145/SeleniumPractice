package tests.day14_testNGFRamwork;

import org.testng.annotations.Test;

public class C01_TestNGFirstTest {
    @Test(priority = 3)
    public void firstTest(){
        System.out.println("first test");
    }

    @Test(priority = 2)
    public void secondTest(){
        System.out.println("second test");
    }
    @Test(priority = 4)
    public void thirdTest(){
        System.out.println("third test");
    }




}
