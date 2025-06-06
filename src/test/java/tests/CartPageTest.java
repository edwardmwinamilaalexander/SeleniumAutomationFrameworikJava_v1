package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.MyAccountPage;
import pages.ShopPage;
import utils.ExtentReportManager;
import utils.Log;

public class CartPageTest extends BaseTest {
    @Test
    public void testCart() {
        Log.info("Starting cart test...");
        test = ExtentReportManager.createTest("Cart Test - ");

        test.info("Navigating to URL");
        
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        ShopPage shopPage = myAccountPage.clickShopPageLink();  // Correct navigation

        Log.info("Adding item to cart");
        test.info("Adding item to cart");
        shopPage.clickAddToCart();  // Must add to cart to enable "View cart"

        Log.info("Clicking view cart ...");
        test.info("Clicking view cart ...");
        CartPage cartPage = shopPage.clickOnViewCart();  // Now it should work

        Log.info("Adding coupon code");
        test.info("Adding coupon code");
        cartPage.addCouponCode();

        Log.info("Applying coupon code");
        test.info("Applying coupon code");
        cartPage.applyCouponCode();

        test.info("Getting coupon success message");
        cartPage.getCouponSuccessMessage();

        test.info("Verifying amount after discount");
        Assert.assertTrue(cartPage.isAmountAfterDiscountDisplayed(), "Amount after coupon is not displayed.");

        test.info("Clicking on proceed to checkout");
        cartPage.clickOnProceedToCheckOut();
    }
}
