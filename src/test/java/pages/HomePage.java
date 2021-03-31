package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public HomePage(WebDriver driver) {

        this.driver=driver;
    }

    //Locator for login button
    @FindBy(id = "login")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[2]/span[2]/select")
    private WebElement booksSizeList;

    //Method to click login button
    public void clickLogin() {
        loginBtn.click();
    }

    public void selectToView5BooksOnPage(){
        Select s = new Select(booksSizeList);
        s.selectByValue("5");
    }

    @FindBy(xpath = "//*[@id=\"item-2\"]")
    private WebElement radioButtonSubMenu;

    public void selectRadioButtonMenu(){
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]"));
        dropdown.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item-4")));
        driver.findElement(By.id("item-4")).click();

        driver.findElement((By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/button"))).click();
    }

    public void searchBook(String name){
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys(name);
        driver.findElement(By.id("basic-addon2")).click();
    }

    @FindBy(className = "rt-tr-group")
    public List<WebElement> books;

}
