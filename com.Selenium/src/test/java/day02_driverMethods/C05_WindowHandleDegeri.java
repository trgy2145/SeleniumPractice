package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_WindowHandleDegeri {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        System.out.println(driver.getWindowHandle()); // uniqe bir değer cevirir.

        driver = new ChromeDriver(); // yeni bir tarayıcı actık..
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        System.out.println(driver.getWindowHandle()); // her seferinde farklı bir deger döner..

        driver.quit();
    }

}
