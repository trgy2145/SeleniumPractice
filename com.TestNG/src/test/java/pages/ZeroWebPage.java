package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroWebPage {
    public ZeroWebPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "signin_button")
    public WebElement signInButton;

    @FindBy(id = "user_login")
    public WebElement loginElement;

    @FindBy(id = "user_password")
    public WebElement passwordElement;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInElement;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBanking;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillLink;

    @FindBy(xpath = "(//li[@class='ui-state-default ui-corner-top'])[2]")
    public WebElement purchaseFCButton;

    @FindBy(id="pc_currency")
    public WebElement currencyDropDown;

}
