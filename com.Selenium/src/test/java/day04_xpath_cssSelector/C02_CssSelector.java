package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;
import java.time.Duration;

public class C02_CssSelector {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // browser is fullscreen
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // get the "https://www.amazon.com.tr/"
        driver.get("https://www.amazon.com.tr/");

        // do refresh the page
        driver.navigate().refresh();

        // do title contains "Spend less" ? test it
        String expectedSText = "Spend less";
        String actualTitle =  driver.getTitle();
        if(actualTitle.contains(expectedSText)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }
        // click to "Hediye Kartları"
        driver.findElement(By.xpath("//option[text()='Hediye Kartları']")).click();

        // click to the "Doğum günü" button
        driver.findElement(By.xpath("((//span[text()='Doğum Günü'])[1]")).click();

        // click first product on the best Seller section
        driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[1]"));
        // choose 50 tl from details
        driver.findElement(By.cssSelector("#gc-mini-picker-amount-1")).click();

        //  do price has "50,00 TL" test it
        WebElement priceControl =  driver.findElement(By.xpath("(//span[text()='50,00 TL'])[1]"));
        if (priceControl.getText().equals("50,00 TL")){
            System.out.println("price test passed");
        }else {
            System.out.println("price test failed");
        }



        Thread.sleep(3000);
        // close the page
        driver.close();
    }
}
