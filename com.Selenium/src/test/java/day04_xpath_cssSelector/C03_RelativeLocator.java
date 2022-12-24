package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.ScriptTimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocator {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  get to https://www.diemol.com/selenium-4-demo/relative-locators-demo.html

        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        // two different way locate the berlin
        WebElement sailor =  driver.findElement(By.xpath("//p[text()='Sailor']"));
        WebElement berlin1 =  driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailor));

        WebElement boston  = driver.findElement(By.xpath("//p[text()='Boston']"));
        WebElement berlin2 =  driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(boston).above(sailor));

        //  whether this locator is good working or not.test it

       /* String expectedIdValue = "pid7_thumb";
        String actualIdValue = berlin1.getAttribute("Id");
        if (expectedIdValue.equals(actualIdValue)){
            System.out.println("relative locator is  good working");
        }else {
            System.out.println("relative locator is not working");
        }*/

        String expectedIdValue = "pid7_thumb";
        String actualIdValue = berlin2.getAttribute("Id");
        if (expectedIdValue.equals(actualIdValue)){
            System.out.println("relative locator is  good working");
        }else {
            System.out.println("relative locator is not working");
        }
        driver.close();
    }
}
