package tests.day14_testNGFRamwork;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DependsOnMethod {
    @Test(dependsOnMethods = "secondTest")
    public void firstTest(){
        System.out.println("first test");
    }

    @Test()
    public void secondTest(){
        System.out.println("second test");
        Assert.assertTrue(5>9);
    }
    @Test()
    public void thirdTest(){
        System.out.println("third test");
    }




}
