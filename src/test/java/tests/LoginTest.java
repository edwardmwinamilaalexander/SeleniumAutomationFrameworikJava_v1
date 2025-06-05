package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	 @Test
	    public void testValidLogin() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.enterUsername("admin@yourstore.com");
	        loginPage.enterPassword("admin");
	        loginPage.clickLoginButton();
	        System.out.println(driver.getTitle());
	        Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Login");
	    }

}
