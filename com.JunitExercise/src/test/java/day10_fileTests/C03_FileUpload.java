package day10_fileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethod;
import utilities.TestBase;

public class C03_FileUpload extends TestBase {
    @Test
    public void test01(){

        //  https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        // click the choose button
        // choose file
        /*
        bu görevi yapabilmek icin chooseFile bastıgımız zaman  acılan pc de file doslarını click yapabilmemiz
        gerekir ancak selenium pc deki dosyaları click yapamaz.(selenium web üzerinde calısır pc de hükmü yok)
        Bunun yerine söyle bir cözüm üretilmistir.
        1- chooseFile butonunu locate edin
        2-upload edilecek dosyanın dosya yolunu olusturun
        3- chooseFile butonuna SendKeys ile dosya yolunu gönder
         */
        WebElement chooseFileElement = driver.findElement(By.xpath("//*[@id='file-upload']"));
        String filePath = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\selenium.txt";

        chooseFileElement.sendKeys(filePath);

        //upload butonuna bas
        driver.findElement(By.xpath("//*[@id='file-submit']"));

        // check out  this "File Uploaded!"  exist or not...

        WebElement uploadedText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(uploadedText.isDisplayed());
        ReusableMethod.wait(5);




    }
}
