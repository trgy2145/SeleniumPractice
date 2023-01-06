package day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase;

public class C04_SsAllPage2 extends TestBase {


    @Test
    public void test(){

        driver.get("https://wisequarter.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        driver.findElement(By.xpath("(//a[@class='ekit-menu-nav-link'])[1]")).click();

        WebElement aboutText =  driver.findElement(By.xpath("//h2[text()='About Us']"));
        String expectedText =  "About Us";
        String actualText =  aboutText.getText();

        Assert.assertEquals(expectedText,actualText);


        ReusableMethod.allPageSS(driver);

        ReusableMethod.wait(5);






    }
}
