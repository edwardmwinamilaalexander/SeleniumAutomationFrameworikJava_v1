package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;
import utils.Log;

public class LoginPageTest extends BaseTest {
	@Test
    public void testValidLogin() {
		Log.info("Starting login test...");
		test = ExtentReportManager.createTest("Login Test - ");

		test.info("Navigating to URL");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickMyAccountLink();

		Log.info("Adding credentials");
		test.info("Adding Credentails");
		loginPage.enterUsername("gumba@gmail.com");
		loginPage.enterPassword("Nsumba1984&&");
		test.info("Clicking on Login button");
		loginPage.clickLoginButton();

		Assert.assertEquals(loginPage.getLoginPageTitle(), "My account – Edko Fashion");


		test.pass("Login Successful");
	}

}
	
	
	