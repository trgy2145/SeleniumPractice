package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.layertree.model.StickyPositionConstraint;

public class C03_DriverMethods {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        String pageSource = driver.getPageSource();
        String expectedWord = "MEOW";

        if(pageSource.contains(expectedWord)){
            System.out.println("test passed");
        }else {
            System.out.println("test not passed");
        }
    driver.close();
    }

}
