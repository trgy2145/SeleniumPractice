package day07_dropdown_jsAlert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_HandleDropDownMenu {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // amazon sayfasına git
        driver.get("https://www.amazon.com/");

        //select obj olusturmadan önce dropdown elementini locate et

        WebElement dropDownElement =  driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownElement);
        // select by value

        select.selectByValue("search-alias=stripbooks-intl-ship");

       // select by index
        //select.selectByIndex(4);


        //select by visibletext

        //select.selectByVisibleText("Bücher");

        // web elemenet kutusuna java yaz ve arat.

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        // title java içerdiğini test et.

        String expectedWort = "Java";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedWort));

        //dropdown menüden Bücher seceneğinin secili oldugunu test edin
        // asagıdaki kodu yazıp tekrar textboxa Bücher yazdır cünkü yazmazsak searc boxta java yazılı olur  hata verir
        dropDownElement =  driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropDownElement);
        select.selectByValue("search-alias=stripbooks-intl-ship");

        String actualSelectedOption = select.getFirstSelectedOption().getText();
        String expectedSelectedOption = "Books";
       Assert.assertEquals(expectedSelectedOption,actualSelectedOption);

       // Dropdown menüdeki secenek sayısının 28  oldugunu test edin
        int expectedIntNumber = 28;
        List<WebElement> optionsNumber = select.getOptions();
        Assert.assertEquals(expectedIntNumber,optionsNumber.size());


        Thread.sleep(3000);
    }
}
