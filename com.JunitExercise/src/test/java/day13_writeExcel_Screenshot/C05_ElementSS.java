package day13_writeExcel_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_ElementSS extends TestBase {
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

        ReusableMethod.elementSs(resultText);

        // ss alacagımız elementi locate et
        // kaydedeceğimiz dosyayı olustur.
     /*   File elements =  new File("target/screenShot/elementSS.jpeg");

        // gecici dosyayı olusturup element üzerinden ss yapalim

        File tempFile =  resultText.getScreenshotAs(OutputType.FILE);
        //gecici dosyayı hedef dosyaya kaydedelim
        FileUtils.copyFile(tempFile,elements);  */
        ReusableMethod.wait(5);
    }
}
