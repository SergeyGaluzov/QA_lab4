package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import pages.UserPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTestCase {

    private WebDriver driver;
    private static String siteUrl = "https://www.demoqa.com/books";

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void signIn(){

        driver.get(siteUrl);
        HomePage home = PageFactory.initElements(driver, HomePage.class);

        LoginPage login = PageFactory.initElements(driver, LoginPage.class);

        home.clickLogin();
        login.enterUsername("SergeyGaluzo");
        login.enterPassword("A123=4567890g@");
        login.clickLogin();


        UserPage user = PageFactory.initElements(driver, UserPage.class);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName-value")));

        assertEquals("SergeyGaluzov", user.getUserName());


    }
}
