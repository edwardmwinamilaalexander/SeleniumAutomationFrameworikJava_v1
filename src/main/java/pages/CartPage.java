package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import utils.Log;

import java.time.Duration;

public class CartPage {
	private WebDriver driver;
	private WebDriverWait wait;

	private By couponCode = By.id("coupon_code");
	private By applyCoupon = By.cssSelector("button[value='Apply coupon']");
	private By amountAfterCoupon = By.xpath("//tr[@class='order-total']//bdi[1]");
	private By proceedToCheckOut = By.cssSelector(".checkout-button.button.alt.wc-forward");
	private By couponSuccessMessage = By.cssSelector("div[role='alert']");

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	}

	public void addCouponCode() {
		Log.info("Add coupon code  ...");
		wait.until(ExpectedConditions.visibilityOfElementLocated(couponCode));
		driver.findElement(couponCode).clear();
		driver.findElement(couponCode).sendKeys("DISC20");
	}

	public void applyCouponCode() {
		Log.info("Apply coupon code  ...");
		wait.until(ExpectedConditions.elementToBeClickable(applyCoupon));
		driver.findElement(applyCoupon).click();
	}

	public String getCouponSuccessMessage() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(couponSuccessMessage));
		return driver.findElement(couponSuccessMessage).getText();
	}

	public boolean isAmountAfterDiscountDisplayed() {

		wait.until(ExpectedConditions.visibilityOfElementLocated(amountAfterCoupon));
		WebElement amountElement = driver.findElement(amountAfterCoupon);
		return amountElement.isDisplayed();

	}

	public CheckOutPage clickOnProceedToCheckOut() {
	    Log.info("Clicking proceed to check out ...");

	    WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOut));

	    // Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutButton);

	    // Now actually click it
	    checkoutButton.click();

	    return new CheckOutPage(driver);
	}


}
