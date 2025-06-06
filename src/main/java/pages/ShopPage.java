package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Log;

import java.time.Duration;

public class ShopPage {
	private WebDriver driver;
	private WebDriverWait wait;

	private By addToCart = By.cssSelector("a[aria-label='Add to cart: “Belt”']");
	private By viewCart = By.cssSelector("a[title='View cart']");

	public ShopPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickAddToCart() {
		Log.info("Clicking add to cart ...");

		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart)).click();
	}
	


	public CartPage clickOnViewCart() {
		Log.info("Clicking view cart ...");
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewCart)).click();
		return new CartPage(driver);
	}
}
