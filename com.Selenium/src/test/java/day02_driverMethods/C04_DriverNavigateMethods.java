package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //  driver.get("https://www.amazon.com");
        driver.navigate().to("https://www.amazon.com"); // get ile aynı görevi yapar
        Thread.sleep(3000);
        // google gittim
        driver.get("https://google.com");
        Thread.sleep(3000);
        // geri dönmek icin
        driver.navigate().back();
        Thread.sleep(3000);
        //ileri gitmek icin
        driver.navigate().forward();

        Thread.sleep(3000);
        driver.close();
    }

}
