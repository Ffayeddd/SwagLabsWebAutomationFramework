package tests;
import Drivers.GuiDriver;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

import static Readers.PropertyReader.getProperty;

public class CartTest {
     WebDriver driver;



    @Test
    @Description("Verify that the user can not proceed to checkout when the cart is empty")
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
    @Description("Verify that user can remove a Backbag product and proceed to checkout")
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
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that clicking Continue Shopping button redirects user to Home Page")

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
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user can proceed to checkout from the cart page")
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
    @Description("Verify that the cart badge updates correctly when a product is added")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void CP_TC_06() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .validateCartBadgeCount(1);

    }
    @Test
    @Description("Verify that the cart badge count updates after navigating back to Home and adding another product")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
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
    @Description("Verify that the cart badge updates when a product is removed")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
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
    @Description("Verify that the cart badge persists after page reload")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
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
    @Description("Verify that the cart badge is hidden when the cart is empty")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void CP_TC_10() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .removeBackbagFromCart()
                .validateCartBadgeNotPresent();
    }



    //configuration
    @BeforeMethod
    public void setup() {
        driver= GuiDriver.initDriver();
        driver.get(getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        GuiDriver.quitDriver();
    }



}

