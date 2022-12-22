package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ByLinkText {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //go amazon webpage
        // click gift Cards link
        //make test whether we go to the Gift Cards page or not
        driver.get("https://www.amazon.com");
       // WebElement giftCard = driver.findElement(By.linkText("Gift Cards"));
        Thread.sleep(3000);
        // linkin bir kısmınıda yazmak yeterli olur..
        WebElement giftCard = driver.findElement(By.partialLinkText("Gift"));
        giftCard.click();
        String expectedText = "Gift Cards";
        String actualTitle =driver.getTitle();

        if (actualTitle.contains(expectedText)){
            System.out.println("Gift Cards passed");
        }else {
            System.out.println("Gift Cards not Passed");
        }



        driver.close();
    }
}
