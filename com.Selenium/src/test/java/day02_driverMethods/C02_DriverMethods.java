package day02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_DriverMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println("size of maximize = " + driver.manage().window().getSize());
        System.out.println("position = "+ driver.manage().window().getPosition());

        Thread.sleep(3000);
        driver.manage().window().fullscreen();
        System.out.println("size of fullscreen = " +  driver.manage().window().getSize());
        System.out.println("position = "+ driver.manage().window().getPosition());

        //resize and reposition of browser

        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(300,300));

        Thread.sleep(5000);
        driver.close();
    }

}
