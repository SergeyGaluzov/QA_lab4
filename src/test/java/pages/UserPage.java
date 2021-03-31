package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public UserPage(WebDriver driver) {
        this.driver=driver;
    }

    //Locators for the page title and the logout button
    @FindBy(id = "userName-value")
    public WebElement userName;

    @FindBy(id = "submit")
    private WebElement logoutBtn;

    @FindBy(xpath = "//*[@id=\"userForm\"]/div[1]/h5")
    private WebElement logoutText;

    //Method to capture the page heading
    public String getUserName() {
        return userName.getText();
    }

    public String getLogoutText(){
        return logoutText.getText();
    }

    //Method to click on Logout button
    public void clickLogout() {
        logoutBtn.click();
    }
}