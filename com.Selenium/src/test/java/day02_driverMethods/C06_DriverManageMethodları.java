package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverManageMethodları {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // implicity wait gittiğimiz sayfa acılıncaya veya aradıgınız   webelement bulununcaya kadar
        //driverin bekleyebileceği max süre
    }
}
