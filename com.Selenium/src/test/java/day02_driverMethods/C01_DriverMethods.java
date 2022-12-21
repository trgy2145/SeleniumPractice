package day02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        String expectedWord = "amazon";
        String actualTitle = driver.getTitle();

        // do title contain "amazon"?
        if(actualTitle.contains(expectedWord)){
            System.out.println("test passed");
        }else{
            System.out.println("title dont contains amazon");
            System.out.println(driver.getTitle());
        }

        System.out.println("***********************************");
        // current url is "https://www.amazon.com/"
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(actualUrl)){
            System.out.println("test passed");
        }else
        {
            System.out.println("test not passed");
            System.out.println(driver.getCurrentUrl());
        }
        System.out.println("*****************************************");
        Thread.sleep(5000);
        driver.close();

    }
}
