package tests.day15;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethod;

public class C01_SoftAssert {
    @Test
    public void test(){

        //  "https://www.amazon.com"

        Driver.getDriver().get("https://www.amazon.com");

        // amazona gidildiğini test et

        SoftAssert softAssert =  new SoftAssert();
        String expectedUrl ="amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrl));

        // nutella aratın

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Nutellla"+ Keys.ENTER);

        // arama sonuclarının nutella icerdiğini test et

        String resultText = amazonPage.searchResultElement.getText();
        softAssert.assertFalse(resultText.contains("Nutella"));

        // java aratın (java aratmadan önce search u temizle cünkü son aratılan kalır

        amazonPage.amazonSearchBox.clear();
        amazonPage.amazonSearchBox.sendKeys("Java"+Keys.ENTER);
       // ReusableMethod.wait(10);

        // arama sonuclarının 1000 den fazla oldugunu dogrulayınız..
        resultText = amazonPage.searchResultElement.getText();
        String[] resultArr = resultText.split(" ");
        String resultStr = resultArr[3];
        resultStr = resultStr.replaceAll("\\W","");  //7000
        softAssert.assertTrue(Integer.parseInt(resultStr) > 1000);


        softAssert.assertAll();
        Driver.closeDriver();

    }
}
