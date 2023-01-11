package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] amazonSearcWords() {
        // dataprovider istediğimiz test metoduna test datası saglamak icin kullanılır.
        // sadece bir sartı vardır.
        // iki katlı bir obje arrayi döndürmelidir.
        Object[][] searchWordArray = {{"Nutella"},{"Java"},{"Apple"},{"Samsung"},{"Armut"}};

        return searchWordArray;
    }
    // amazona gidelim
    // Nutella ,Java,Apple,Samsung,Armut kelimeleri aratalım
    //sonucların bu kelimeleri icerdiğini test edelim
    int count =  0;

    @Test(dataProvider = "amazonSearcWords")
    public void searchTest01(String searchWord){

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.amazonSearchBox.sendKeys(searchWord+ Keys.ENTER);
        String actualResultText = amazonPage.searchResultElement.getText();
        Assert.assertTrue(actualResultText.contains(searchWord));
        count++;

        if(count == 5){
            Driver.closeDriver();
        }

    }
}
