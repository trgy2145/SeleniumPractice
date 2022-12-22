package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_AutomationExercise {
    public static void main(String[] args) {

        // set up
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // go to "https://automationexercise.com/"
        driver.get("https://automationexercise.com/");

        // there are 147 links on the page, test it

        List<WebElement> linklList = driver.findElements(By.tagName("a"));

        if (linklList.size() == 147){
            System.out.println("test passed");
        }else {
            System.out.println("there are "+ linklList.size() +"links on the page Test failed");
        }

        // click products link

        driver.findElement(By.partialLinkText(" Products")).click();

        // special offer text is visible or not? test it
        WebElement specialOfferElement = driver.findElement(By.id("sale_image"));

        if (specialOfferElement.isDisplayed()){
            System.out.println("special offer is visible");
        }else {
            System.out.println("special offer text is not visible");
        }

        // close the page
        driver.close();
    }
}
