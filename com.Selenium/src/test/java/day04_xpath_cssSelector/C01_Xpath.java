package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver  =  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // go  to https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // click add element button
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        // is there delete button visible?  test it.
        WebElement deleteButton =  driver.findElement(By.xpath("//*[text()='Delete']"));

        if (deleteButton.isDisplayed()) {
            System.out.println("delete button is visible");

        }else
        {
            System.out.println("delete button is not visible");
        }
        // click the delete button
        driver.findElement(By.xpath("//*[text()='Delete']")).click();

        // "Add/Remove Elements" is visible or not. check out
        WebElement addRemoveText =  driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        if (addRemoveText.isDisplayed()) {
            System.out.println("add/remove is visible");

        }else
        {
            System.out.println("add/remove is not visible");
        }
        Thread.sleep(3000);

        // close
        driver.close();
    }
}
