package day11_seleniumwaits_cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.util.List;

public class C03_WebTable extends TestBase {

    @Test
    public void test01(){
        //  "https://www.amazon.com" git
        driver.get("https://www.amazon.com");
        // sayfanın en altına in..
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();



        // web table daki satır sayısının 10 oldugunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        Assert.assertEquals(10,satirlarListesi.size());

        // tüm satırları yazdır
        for (WebElement eachElement: satirlarListesi
             ) {
            System.out.println(eachElement.getText());
        }
      //  column sayısının 13 oldugunu test et

        List<WebElement> numberOfColumn = driver.findElements(By.xpath("//tbody/tr[1]/td"));

        Assert.assertEquals(13,numberOfColumn.size());

        //  5. sütunu yazdırın

        List<WebElement> besinciColumn = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        System.out.println("*****************************************");
        for (WebElement eachElement : besinciColumn
                ) {
            System.out.println(eachElement.getText());
        }
       //  satır ve stün sayısını parametre olarak alıp hücredeki bilgiyi döndüren bir method olusturun

        WebElement istenenDataElementi =  getElement(3,5);
        System.out.println(istenenDataElementi.getText());


        ReusableMethod.wait(5);
    }

    private WebElement getElement(int row, int column) {

        String dinamicXpath =  "//tbody/tr["+row+"]/td["+column+"]";

        WebElement istenenElement =  driver.findElement(By.xpath(dinamicXpath));
        return istenenElement;
    }

}
