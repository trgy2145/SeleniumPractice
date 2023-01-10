package tests.day15_softAssert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebPage;
import utilities.Driver;
import utilities.ReusableMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C02_SoftAssert {
    @Test(groups = "deneme1")
    public void test01(){

        // "http://zero.webappsecurity.com/"git
        Driver.getDriver().get("http://zero.webappsecurity.com/");
        //  Sign In butonuna basınız.
        ZeroWebPage zeroWebPage =  new ZeroWebPage();
        zeroWebPage.signInButton.click();


        // login kutusuna "username" yazın

        zeroWebPage.loginElement.sendKeys("username");

        //password kutusuna password yazın
        zeroWebPage.passwordElement.sendKeys("password");

        // Sign in e bas
        zeroWebPage.signInElement.click();

        // online banking menusu icinde Pay Bills sayfasına gidin
        Driver.getDriver().navigate().back();
        // Driver.getDriver().switchTo().alert().accept();
        zeroWebPage.onlineBanking.click();
        zeroWebPage.payBillLink.click();

        // "Purchase Foreign Currency" tusuna basınız
        zeroWebPage.purchaseFCButton.click();

        // "Currency" drop down menusunden Eurozone ' eu secin
        // drop down elementi secmek icin önce select i locate edip sonra Select objesi olusturup
        // locate ettiğimiz elementi yollamalıyız.obje üzerinde işlem yaparız

        Select select = new Select(zeroWebPage.currencyDropDown);
        select.selectByVisibleText("Eurozone (euro)");

        // soft assert kullanarak Eurozone secildiğini test edin
        SoftAssert softassert = new SoftAssert();
        String actualText =  select.getFirstSelectedOption().getText();
        String expectedText =  "Eurozone (euro)";
        softassert.assertEquals(actualText,expectedText,"eurozone test failed");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)",
        // "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)",
        // "Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)",
        // "Thailand (baht)"

        List<WebElement> optionsElementListesi= select.getOptions();
        List<String> actualOptionsListesiStr= new ArrayList<>();

        for (WebElement each: optionsElementListesi
        ) {
            actualOptionsListesiStr.add(each.getText());
        }
        String[] arr={"Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"};
        List<String> expectedOptionsListesi= Arrays.asList(arr);

        Collections.sort(actualOptionsListesiStr);
        Collections.sort(expectedOptionsListesi);

        softassert.assertEquals(actualOptionsListesiStr,expectedOptionsListesi);



        softassert.assertAll();
        ReusableMethod.wait(5);
        Driver.closeDriver();



    }
}
