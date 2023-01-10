package tests.day15_softAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethod;

public class C03_PozitifTest {
    @Test
    public void test01(){

        // https://www.qualitydemy.com/  sayfasına git

        Driver.getDriver().get("https://www.qualitydemy.com/");

        // login linkine basın
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.firstLoginLink.click();

        // kullanıcı email icin valid bir email girin
        qualitydemyPage.emailBox.sendKeys("user_1104147@login.com");

        // valid bir password giriniz
        qualitydemyPage.passwordBox.sendKeys("31488081");

        // login e bas ve login ol
        qualitydemyPage.acceptCookies.click();
        qualitydemyPage.loginButton.click();

        // login oldugunu test et
        Assert.assertTrue(qualitydemyPage.succesfullyLogin.isDisplayed());


        ReusableMethod.wait(5);

        Driver.closeDriver();


    }
}
