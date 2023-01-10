package tests.day16_smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class C01_PozitifLoginTest {

    @Test
    public void pozitifLoginTest(){

        Driver.getDriver().get(ConfigReader.getProperty("qualitydemyUrl"));
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();

        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdValidEmail"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdValidPassword"));
        qualitydemyPage.acceptCookies.click();
        ReusableMethod.wait(3);
        qualitydemyPage.loginButton.click();

        Assert.assertTrue(qualitydemyPage.succesfullyLogin.isDisplayed());
        Driver.closeDriver();

    }
}
