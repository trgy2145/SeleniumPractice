package day11_seleniumwaits_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicityWait {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void teardown(){
        driver.quit();
    }
    @Test
    public void implicityWait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // "https://the-internet.herokuapp.com/dynamic_controls" adresine git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //click the Remove button
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // check "It's gone!" visible or not?
        WebElement itsGoneElement =  driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsGoneElement.isDisplayed());

        // click Add button
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        //check "It's back" visible or not
        WebElement itsBackElement = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsBackElement.isDisplayed());

    }
    @Test
    public void explicityWait(){
        // "https://the-internet.herokuapp.com/dynamic_controls" adresine git
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //click the Remove button
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        // explicity wait obj olusturalım
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));

        // bundan sonra iki durum söz konusudur
        //işlem edilebilir element locate edilebilir olup olmaması önemlidir
        // eğer locate edilirse, önce locate edip, sonra wait objesi ile o element bekletilebilir
        // locate edilemiyorsa wait objesine bekleme emri locator olarak verilebilir..

        WebElement itsGoneElement =wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@id='message']")));
        // check "It's gone!" visible or not?

        Assert.assertTrue(itsGoneElement.isDisplayed());



    }
}
