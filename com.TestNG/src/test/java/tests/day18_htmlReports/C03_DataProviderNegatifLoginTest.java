package tests.day18_htmlReports;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class C03_DataProviderNegatifLoginTest {
    @DataProvider
    public static Object[][] userData() {
        Object[][] user = {{"A11","A12345"},{"B11","B12345"},{"C11","C12345"},{"D11","D12345"},{"E11","E12345"}};
        return user;
    }

    // Qualitydemy anasayfasına gidin
    // yanlıs kullanıcı adı ve pass girin
    // giris yapılamadıgını test edin
    // username                 password
    // A11                      A12345
    // B11                      B12345
    // C11                      C12345
    // D11                      D12345
    // E11                      E12345
    boolean b = true;
    @Test(dataProvider = "userData")
    public void negativeLoginTest(String username,String password){
        Driver.getDriver().get(ConfigReader.getProperty("qualitydemyUrl"));
        QualitydemyPage qualitydemyPage =new QualitydemyPage();
        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys(username);
        qualitydemyPage.passwordBox.sendKeys(password);

        if (b){
            qualitydemyPage.acceptCookies.click();
        }

        b = false;


        ReusableMethod.wait(4);
        qualitydemyPage.loginButton.click();
    }
}
