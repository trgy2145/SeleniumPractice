package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        // go amazon webpage
        //search for Nutella
        //find the most expensive price on the first page
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);
        List<WebElement> listOfPrice = driver.findElements(By.className("a-price-whole"));

        // listofprice is a Webelement object.that is why we can not write it direct
        int theMostExpensivePrice= 0;
        int price;
        for (WebElement each: listOfPrice
             ) {
           // System.out.println(each.getText() + " ");
            price = Integer.parseInt(each.getText());
            if (price > theMostExpensivePrice) {
                theMostExpensivePrice = price;
            }
        }

        System.out.println("the most expensive price = " + theMostExpensivePrice);
        Thread.sleep(3000);
        driver.close();
    }
}
