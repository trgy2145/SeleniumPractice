package day13_writeExcel_Screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase;

public class C06_JsExecuter extends TestBase {

    @Test
    public void test(){
        driver.get("https://www.amazon.com.tr");

        WebElement sellLink =  driver.findElement(By.xpath("//a[text()='Satış Yap']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",sellLink);
        jse.executeScript("alert('bu iş bu kadar')");

        //istenen web elemente gitmek icin


       // WebElement hesapAc =  driver.findElement(By.xpath("(//div[text()='Bizimle Para Kazanın']"));
        // jse.executeScript("arguments[0].scrollIntoView();",hesapAc);
        ReusableMethod.wait(5);

    }
}
