package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By myAccountLink = By.cssSelector("li[id='menu-item-1347'] a");
    private By usernameTextBox = By.id("username");
    private By passwordTextBox = By.id("password");
    private By loginButton = By.cssSelector("button[value='Log in']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Click "My Account" link
    public LoginPage clickMyAccountLink() {
        Log.info("Clicking 'My Account' link...");
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLink)).click();
        return this;
    }

    // Enter username
    public LoginPage enterUsername(String username) {
        Log.info("Entering username...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTextBox)).clear();
        driver.findElement(usernameTextBox).sendKeys(username);
        return this;
    }

    // Enter password
    public LoginPage enterPassword(String password) {
        Log.info("Entering password...");
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTextBox)).clear();
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }
    // get title
    public String getLoginPageTitle() {
	    return driver.getTitle();
	}

    // Click login button and return ShopPage
    public MyAccountPage clickLoginButton() {
        Log.info("Clicking MyAccount button...");
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new MyAccountPage(driver);
    }
}

