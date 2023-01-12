package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Amazonpage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepDefinition {
    Amazonpage amazonpage =new Amazonpage();
    @Given("user get the amazon page")
    public void user_get_the_amazon_page() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

    }
    @Then("user write on the searchbox and searches it.")
    public void user_write_on_the_searchbox_and_searches_it() {
        amazonpage.amazonSearchBox.sendKeys("Nutella"+ Keys.ENTER);

    }
    @Then("user tests it whether the result contain Nutella or not")
    public void user_tests_it_whether_the_result_contain_nutella_or_not() {
        String actualSearchText = amazonpage.searchResult.getText();
        String expectedText = "Nutella";
        Assert.assertTrue(actualSearchText.contains(expectedText));

    }
    @Then("close the page")
    public void close_the_page() {
        Driver.closeDriver();

    }
}
