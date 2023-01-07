package tests.day15;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C04_NegativeLoginTest {

    QualitydemyPage qualitydemyPage = new QualitydemyPage();

    @Test
    public void wrongEmailTest(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys("ahmet@gmail.com");
        qualitydemyPage.passwordBox.sendKeys("31488081");
        qualitydemyPage.acceptCookies.click();
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void wrongPasswordTest(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys("user_1106147@login.com");
        qualitydemyPage.passwordBox.sendKeys("314998081");
        qualitydemyPage.acceptCookies.click();
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();
    }
    @Test
    public void wrongPassAndEmailTest(){
        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys("ali_1106147@login.com");
        qualitydemyPage.passwordBox.sendKeys("314998081");
        qualitydemyPage.acceptCookies.click();
        qualitydemyPage.loginButton.click();
        Assert.assertTrue(qualitydemyPage.emailBox.isDisplayed());
        Driver.closeDriver();

    }
}
