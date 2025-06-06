package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.MyAccountPage;
import pages.ShopPage;
import utils.ExtentReportManager;
import utils.Log;

public class ShopPageTest extends BaseTest {
    @Test
    public void testShop() {
        Log.info("Starting shop test...");
        test = ExtentReportManager.createTest("Shop Test - ");
        
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        ShopPage shopPage = myAccountPage.clickShopPageLink(); // This already returns ShopPage

        test.info("Navigating to Shop Page");

        Log.info("Adding item to cart");
        test.info("Adding item to cart");
        shopPage.clickAddToCart();

        Log.info("Clicking view cart");
        test.info("Clicking view cart");
        shopPage.clickOnViewCart();

        test.pass("Shop page tested successfully");
    }
}
