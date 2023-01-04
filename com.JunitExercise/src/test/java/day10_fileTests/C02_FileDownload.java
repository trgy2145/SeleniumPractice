package day10_fileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    @Test
    public void test01(){

        // "https://the-internet.herokuapp.com/download" adresine git

        driver.get("https://the-internet.herokuapp.com/download");

        // webdriverIO.png indir

        driver.findElement(By.xpath("//a[text()='webdriverIO.png']")).click();
        ReusableMethod.wait(5);

        // dosya basarı ile indimi test et..
        // dosyanın öncelikle indiğinden emin ol ve yolunu al..

        String dynamicPath = System.getProperty("user.home") +"\\Downloads\\webdriverIO.png";

        // bir dosyanın pc de var oldugunu test etmek icin javadaki file classından yardım alacagız.

        Assert.assertTrue(Files.exists(Paths.get(dynamicPath)));

    }
}
