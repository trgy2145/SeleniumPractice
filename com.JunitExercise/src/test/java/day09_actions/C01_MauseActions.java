package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethod;
import utilities.TestBase;

import java.util.Set;

public class C01_MauseActions extends TestBase {
     @Test
     public void test01(){
          // https://the-internet.herokuapp.com/context_menu sitesine git
          driver.get("https://the-internet.herokuapp.com/context_menu");

          // çizili alan üzerinde sağ click yap
          WebElement drawedArea =  driver.findElement(By.xpath("//*[@id='hot-spot']"));
          Actions actDrawedArea = new Actions(driver);
          actDrawedArea.contextClick(drawedArea).perform();

          ReusableMethod.wait(2);

          // alertte cıkan yazının "You selected a context menu" oldugunu test edin

          String expectedText = "You selected a context menu";
          String actualAlertText = driver.switchTo().alert().getText();
          Assert.assertEquals(expectedText,actualAlertText);

          ReusableMethod.wait(2);

          //tamam diyerek alert i kapatın
          driver.switchTo().alert().accept();

          // elemental selenium linkine tıklayın
          String firstPageWHD =  driver.getWindowHandle();

          driver.findElement(By.linkText("Elemental Selenium")).click();

          //acılan sayfada h1 tagında "Elemental Selenium" yazdıgını test edin
          Set<String> windowHandles = driver.getWindowHandles();

          String secondPageWHD ="";
          for (String eachWHD: windowHandles) {

               if (!eachWHD.equals(firstPageWHD)){
                    secondPageWHD = eachWHD;
               }

          }
          driver.switchTo().window(secondPageWHD);

          String expectedNewPageText = "Elemental Selenium";
          String actualNewPageText = driver.findElement(By.tagName("h1")).getText();
          Assert.assertEquals(expectedNewPageText,actualNewPageText);

          ReusableMethod.wait(4);


     }


}
