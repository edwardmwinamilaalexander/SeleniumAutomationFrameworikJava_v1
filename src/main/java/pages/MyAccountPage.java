package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class MyAccountPage {
	private WebDriver driver;
	private WebDriverWait wait;

	private By dashboard = By.xpath("//a[normalize-space()='Dashboard']");
	private By shopLink = By.xpath("//*[@id=\"menu-item-1345\"]/a");

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public boolean isDashBoardDisplayed() {
		WebElement dashboardText = driver.findElement(dashboard);
		return dashboardText.isDisplayed();
	}

	// Click login button and return ShopPage
	public ShopPage clickShopPageLink() {
		Log.info("Clicking Shop Page link..");
		wait.until(ExpectedConditions.elementToBeClickable(shopLink)).click();
		return new ShopPage(driver);
	}
}
