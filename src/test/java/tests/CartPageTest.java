package tests;
import Drivers.GuiDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

import static Readers.PropertyReader.getProperty;

public class CartPageTest {
    private WebDriver driver;


    //configuration
    @BeforeMethod
    public void setup() {

        driver = GuiDriver.initDriver();         // create driver once
        driver.get(getProperty("baseUrl"));


    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            GuiDriver.quitDriver();
        }
    }


    @Test
    @Description("verify that user cannot checkout when cart is empty")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void CP_TC_01() {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .addToCartValidation()
                .cartClick()
                .removeBackbagFromCart()
                .clickCheckoutofCartWhenEmpty();

    }
    @Test
    @Description("verify that user can remove a Backbag product and checkout correctly")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void CP_TC_02() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .addOnesieToCart()
                .addToCartValidation()
                .cartClick()
                .removeBackbagFromCart()
                .clickCheckoutofCart();

    }

    @Test
    @Tag("valid scenario")
    @Description("Verify that clicking Continue Shopping returns user to Home Page")
    public void CP_TC_03() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .addToCartValidation()
                .cartClick()
                .clickContinueShopping(getProperty("expectedUrl"));

    }

    @Test
    @Tag("valid scenario")
    @Description("Verify that clicking Continue Shopping returns user to Home Page")
    public void CP_TC_04() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .addToCartValidation()
                .cartClick()
                .clickCheckoutofCart();

    }


    @Test
    @Description("Verify that Backpack details in Cart are the same as displayed on Home Page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void CP_TC_05() {

        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .oneItemInCartValidation()
                .cartClick()
                .backbagCartValidation();
    }


    @Test
    @Description("Verify cart badge updates correctly when adding products")
    @Tag("valid scenario")
    public void CP_TC_06() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .validateCartBadgeCount(1);

    }
    @Test
    @Description("Verify cart badge counts after navigating back to home page and adding another product")
    @Tag("valid scenario")
    public void CP_TC_07() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .validateCartBadgeCount(1)
                .clickContinueShopping(getProperty("expectedUrl"))
                .addOnesieToCart()
                .cartClick()
                .validateCartBadgeCount(2);
    }
    @Test
    @Description("Verify cart badge updates correctly when removing products")
    @Tag("valid scenario")
    public void CP_TC_08() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .addOnesieToCart()
                .cartClick()
                .validateCartBadgeCount(2)
                .removeBackbagFromCart()
                .validateCartBadgeCount(1);

    }

    @Test
    @Description("Cart badge persists after page reload")
    @Tag("valid scenario")
    public void CP_TC_09() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .addOnesieToCart()
                .cartClick()
                .reloadPage()
                .validateCartBadgeCount(2);
    }

    @Test
    @Description("cart badge is hidden when cart is empty")
    @Tag("valid scenario")
    public void CP_TC_10() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()

                .cartClick()
                .removeBackbagFromCart()

                .validateCartBadgeNotPresent();
    }






}

