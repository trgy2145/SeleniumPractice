package day09_actions;

import com.github.javafaker.Faker;
import org.bouncycastle.crypto.modes.KCCMBlockCipher;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.nio.file.WatchEvent;

public class C05_Form extends TestBase {
    @Test
    public void test01(){

        // facebook git
        driver.get("https://www.facebook.com");
        // cookies kabul et
        driver.findElement(By.xpath("//button[@title='Sadece temel çerezlere izin ver']")).click();

        // yeni hesap olustur butonuna tıkla
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // ilgili alanları doldur..faker indir.
        // faker ve action da nesne üret
        // önce ilk giriş yapacagın yeri locate et.
        WebElement firstName = driver.findElement(By.name("firstname"));
        Actions action = new Actions(driver);
        Faker faker  =  new Faker();
        //kayıt yaparken email dogrulaması ister faker rastgele üretir onun için iki mail aynı olması icin üret ve kaydet
        String emailAdress = faker.internet().emailAddress();
        action.click(firstName).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(emailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(emailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("4")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1980")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();

        // daha sonra kaydola tıkla
        driver.findElement(By.name("websubmit")).click();
        // cıkan uyarı ekranında hayırı tıkla
        driver.findElement(By.xpath("//button[@id='action_dialog_disabled_register_button']")).click();

        //kayıt olamadıgını test et.
        //reg_error_inner
        WebElement errorMessage = driver.findElement(By.id("reg_error_inner"));
        Assert.assertTrue(errorMessage.isDisplayed());



        ReusableMethod.wait(3);

    }
}
