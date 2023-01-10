package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QualitydemyPage {

    public QualitydemyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement firstLoginLink;
    @FindBy(id = "login-email")
    public WebElement emailBox;

    @FindBy(id = "login-password")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@class='btn red radius-5 mt-4 w-100']")
    public WebElement loginButton;


    @FindBy(xpath = "//a[text()='Accept']")
    public WebElement acceptCookies;

    @FindBy(linkText = "My courses")
    public WebElement succesfullyLogin;
}
