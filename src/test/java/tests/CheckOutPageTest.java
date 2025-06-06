package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckOutPage;
import pages.MyAccountPage;
import pages.ShopPage;
import utils.ExtentReportManager;
import utils.Log;

public class CheckOutPageTest extends BaseTest {

    @Test
    public void testCheckOut() {
        Log.info("Starting checkout test...");
        test = ExtentReportManager.createTest("CheckOut Test - ");

        test.info("Navigating to URL");

        // Step 1: Go to shop and add item to cart
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        ShopPage shopPage = myAccountPage.clickShopPageLink();
        shopPage.clickAddToCart();

        // Step 2: Go to cart and proceed to checkout
        CartPage cartPage = shopPage.clickOnViewCart();
        cartPage.clickOnProceedToCheckOut();

        // ✅ Step 3: Initialize CheckOutPage object
        CheckOutPage checkOutPage = new CheckOutPage(driver);

        // Step 4: Verify coupon amount (optional)
        Assert.assertTrue(checkOutPage.isCouponAmountDisplayed(), "Amount after coupon is not displayed.");

        // Step 5: Enter billing details
        Log.info("Adding customer details");
        test.info("Adding customer details");
        checkOutPage.enterBillingFirstName("John");
        checkOutPage.enterBillingLastName("Doe");
        checkOutPage.enterBillingAddress("2 London Road");
        checkOutPage.enterBillingTownCity("Gotham");
        checkOutPage.enterPostCode("SW16 4DE");
        checkOutPage.enterEmailAddress("gumba@gmail.com");

        checkOutPage.clickOnPlaceOrderButton();
        
        
     // Step 6: Verify Order received Text
        String orderDetails = checkOutPage.getOrderDetailsText();
        System.out.println("Order Success Message: " + orderDetails); // optional debug print
        Assert.assertEquals(orderDetails, "Order details", "Order details mismatch!");


        test.pass("Checkout page tested successfully");
    }
}
