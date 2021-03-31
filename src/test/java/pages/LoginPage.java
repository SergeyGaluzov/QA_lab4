package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locator for username field
    @FindBy(id = "userName")
    private WebElement userName;

    //Locator for password field
    @FindBy(id = "password")
    private WebElement userPassword;

    //Locator for login button
    @FindBy(id = "login")
    public WebElement loginBtn;


    //Method to enter username
    public void enterUsername(String login) {
       userName.sendKeys(login);
    }

    //Method to enter password
    public void enterPassword(String pswd) {
        userPassword.sendKeys(pswd);
    }

    //Method to click on Login button
    public void clickLogin() {
        loginBtn.click();
    }
}