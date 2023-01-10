package tests.day16_smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class C02_NegatifLoginTest {
    QualitydemyPage qualitydemyPage = new QualitydemyPage();

    @Test
    public void wrongEmailTest() {

        Driver.getDriver().get(ConfigReader.getProperty("qualitydemyUrl"));
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdUnvalidEmail"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdValidPassword"));
        qualitydemyPage.acceptCookies.click();
        ReusableMethod.wait(3);
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void wrongPasswordTest(){
        qualitydemyPage = new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qualitydemyUrl"));
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdValidEmail"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdUnvalidPassword"));
        qualitydemyPage.acceptCookies.click();
        ReusableMethod.wait(3);
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void wrongPassAndEmailTest(){
        qualitydemyPage = new QualitydemyPage();
        Driver.getDriver().get(ConfigReader.getProperty("qualitydemyUrl"));
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdUnvalidEmail"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdUnvalidPassword"));
        qualitydemyPage.acceptCookies.click();
        ReusableMethod.wait(3);
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();

    }
}
