package day08_handlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindows {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);

        // testin ilerleyen safhalarında bu sayfaya geri dönmek istiyorsak bunun handle window degerini tutmamız gerekir.
        // hangi sayfaya gecmek istiyorsan oranın window handle degerini al öyle gecis yapabilirsin.

        String amazonHnadleValue = driver.getWindowHandle();


        //yeni bir tab da wise quarter sayfasını ac

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String actualUrl = driver.getCurrentUrl();
        String expectedWort = "wisequarter";
        Assert.assertTrue(actualUrl.contains(expectedWort));
        Thread.sleep(3000);

        // daha sonra yeniden amazon sayfasına gecin ve amazon sayfasının acık old test edin

        driver.switchTo().window(amazonHnadleValue);
        actualUrl = driver.getCurrentUrl();
        expectedWort = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedWort));
        Thread.sleep(3000);
    }

}
