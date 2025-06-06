package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckOutPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private By couponValue = By.xpath("//span[@class='woocommerce-Price-amount amount']");
	private By billingFirstName = By.id("billing_first_name");
	private By billingLastName = By.id("billing_last_name");
	private By billingStrAddress = By.id("billing_address_1");
	private By billingTownCity = By.id("billing_city");
	private By billingPostCode = By.id("billing_postcode");
	private By billingEmailAddress = By.id("billing_email");
	private By placeOrder = By.id("place_order");
	private By orderDetails = By.cssSelector(".woocommerce-order-details__title");

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	}

	public boolean isCouponAmountDisplayed() {
	    
	    WebElement couponElement = driver.findElement(couponValue);
	    return couponElement.isDisplayed();
	}

	public String getPageTitle() {
	    return driver.getTitle();
	}

	public void enterBillingFirstName(String firstName) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    System.out.println("Waiting for billing first name field...");

	    WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(billingFirstName));
	    System.out.println("Found billing first name field!");

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstNameInput);
	    firstNameInput.clear();
	    firstNameInput.sendKeys(firstName);
	}


	public void enterBillingLastName(String lastName) {
		driver.findElement(billingLastName).clear();
		driver.findElement(billingLastName).sendKeys(lastName);
	}

	public void enterBillingAddress(String address) {
		driver.findElement(billingStrAddress).clear();
		driver.findElement(billingStrAddress).sendKeys(address);
	}

	public void enterBillingTownCity(String town_city) {
		driver.findElement(billingTownCity).clear();
		driver.findElement(billingTownCity).sendKeys(town_city);
	}

	public void enterPostCode(String postCode) {
		driver.findElement(billingPostCode).clear();
		driver.findElement(billingPostCode).sendKeys(postCode);
	}

	public void enterEmailAddress(String email) {
		driver.findElement(billingEmailAddress).clear();
		driver.findElement(billingEmailAddress).sendKeys(email);
	}

	public void clickOnPlaceOrderButton() {
		
		driver.findElement(placeOrder).click();

	}
	
	public String getOrderDetailsText() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(orderDetails));
		return driver.findElement(orderDetails).getText();
		
	}
}
