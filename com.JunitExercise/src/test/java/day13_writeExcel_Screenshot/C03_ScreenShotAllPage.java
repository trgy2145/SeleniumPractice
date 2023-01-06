package day13_writeExcel_Screenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.io.IOException;

public class C03_ScreenShotAllPage extends TestBase {

    // "https://www.amazon.com" git

    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com.tr");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella", Keys.ENTER);

        // arama sonucları nutella iceriyormu test et.
        WebElement resultText = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedText =  "Nutella";
        String actualText =  resultText.getText();

        Assert.assertTrue(actualText.contains(expectedText));

        // tüm sayfanın ss alın

        ReusableMethod.allPageSS(driver);
            // methodu reusable methoda atıp istediğimizde cağrabiliriz.
      /*  TakesScreenshot tss = (TakesScreenshot) driver;


        // resmi son olarak kaydedeceğimiz dosyayı olustur
        File allPageSS = new File("target/screenShot/allPage.jpeg");

        // tss objesini kullanıp ekran dosyasını gecici dosyaya kaydet

        File tempFile =  tss.getScreenshotAs(OutputType.FILE);

        // gecici dosyayı ana dosyaya ekle

        FileUtils.copyFile(tempFile,allPageSS); */
        ReusableMethod.wait(5);



    }
}
