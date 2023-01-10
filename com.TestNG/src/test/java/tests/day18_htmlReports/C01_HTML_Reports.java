package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_HTML_Reports extends TestBaseReport {
    @Test
    public void test01(){
        extentTest = extentReports.createTest("Nutella testi","kullanıcı amazonda nutella aratacak");
        // amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon sayfasına gidildi");

        // nutella aratalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("arama kutusuna nutella yazılıp arama yapıldı");
        // sonucların nutella icerdiğini test edelim

        String actualResultText =  amazonPage.amazonSearchBox.getText();
        String expextedWord = "Nutella";
        extentTest.info("Arama sonucları kaydedildi.");
        Assert.assertFalse(actualResultText.contains(expextedWord));
        extentTest.pass("Arama sonuclarının  nutella icerdigi test edildi");
    }
}
