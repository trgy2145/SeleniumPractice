package tests.day14_testNGFRamwork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C03_NutellaTest {

    @Test
    public void test01() throws InterruptedException {
        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");


        // nutella icin arama yap
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // sonuclar Nutella iceriyor mu test et..

        WebElement resultText = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedText ="Nutella";
        String actualText = resultText.getText();

        Assert.assertTrue(actualText.contains(expectedText));
        Driver.closeDriver();
    }
}
