package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.MyAccountPage;
import utils.ExtentReportManager;
import utils.Log;

public class MyAccountPageTest extends BaseTest {
	@Test
	public void testMyaccount() {
		Log.info("Starting My Account test...");
		test = ExtentReportManager.createTest("Order Test - ");

		LoginPage loginPage = new LoginPage(driver);
		test.info("Performing login");
		loginPage.clickMyAccountLink();
		loginPage.enterUsername("gumba@gmail.com");
		loginPage.enterPassword("Nsumba1984&&"); 
		loginPage.clickLoginButton();// Replace with valid creds

		test.info("Navigating to URL");
		MyAccountPage myAccountPage = new MyAccountPage(driver);

		

		Log.info("Verifying Dashboard text");
		test.info("Verifying Dashboard text");
		Assert.assertTrue(myAccountPage.isDashBoardDisplayed());

		test.pass("My Account page tested successfully");
	}

}
