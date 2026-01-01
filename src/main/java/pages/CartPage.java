package pages;

import MyActions.ElementActions;
import Readers.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CartPage {
    private final WebDriver driver ;
    private ElementActions elementActions;
    public static SoftAssert softAssert;

    //locators
    private final By checkout_Button = By.cssSelector(PropertyReader.getProperty("checkoutButtonLocator"));
    private final By removeBackbagBtn = By.cssSelector(PropertyReader.getProperty("removeProductFromCartLocator"));
    private final By continueShopping_Button= By.cssSelector(PropertyReader.getProperty("continueShoppingBtnLocator"));
    private final By cartProductName= By.cssSelector(PropertyReader.getProperty("Header_BackbagcartLocator"));
    private final By cartProductDescription =By.cssSelector(PropertyReader.getProperty("paragraphBackbagcartLocator"));
    private final By cartProductPrice =By.cssSelector(PropertyReader.getProperty("priceBackbagcartLocator"));
    private final By cartBadge = By.cssSelector(PropertyReader.getProperty("cartBadgeLocator"));


    public CartPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementActions=new ElementActions(driver);
        softAssert = new SoftAssert();
    }

    //Methods-actions

    @Step("click on checkout button")
    public CheckOutPage checkOutClick()
    {
        elementActions.myCLick(checkout_Button);

        return new CheckOutPage(driver);
    }


    @Step("Remove Backbag product from the cart")
    public CartPage removeBackbagFromCart() {
        elementActions.myCLick(removeBackbagBtn);
        return this;
    }


    @Step("Click Checkout button and verify user is not redirected when cart is empty")
    public CartPage clickCheckoutofCartWhenEmpty() {

        boolean isProductPresent = !driver.findElements(removeBackbagBtn).isEmpty();
        Assert.assertFalse(isProductPresent,"Cart is not empty");
        elementActions.myCLick(checkout_Button);

        String actualUrl = driver.getCurrentUrl();
        String cartPageUrl = PropertyReader.getProperty("cartlink");

        Assert.assertEquals(
                actualUrl,
                cartPageUrl,"User is redirected to checkout page when cart is empty");

        return this;
    }

    @Step("verify that checkout button is redirected correctly to checkout ")
    public CheckOutPage clickCheckoutofCart() {
        elementActions.myCLick(checkout_Button);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlcart = PropertyReader.getProperty("checkoutPageUrl");
        Assert.assertEquals(actualUrl, expectedUrlcart,"User is not redirected to checkout page");
        return new CheckOutPage(driver);

    }


    @Step("Verify that clicking the Continue Shopping button redirects the user to the Home page")
    public HomePage clickContinueShopping(String expectedUrl) {
        elementActions.myCLick(continueShopping_Button);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl,"User is not redirected to home page");
        return new HomePage(driver);
    }


    @Step("Validate that details are displayed correctly for Backbag product in Cart")
    public CartPage backbagCartValidation() {
        SoftAssert softAssert = new SoftAssert();
        elementActions.findElement(cartProductName);
        softAssert.assertEquals(
                elementActions.getText(cartProductName),
                "Sauce Labs Backpack",
                " Product name mismatch");
        softAssert.assertTrue(
                elementActions.getText(cartProductDescription).contains("allTheThings()"),
                "Product description mismatch");

        softAssert.assertEquals(
                elementActions.getText(cartProductPrice),
                "$29.99",
                "Product price mismatch");
        softAssert.assertAll();

        return this;
    }


    @Step("Validate cart badge counts correctly")
    public CartPage validateCartBadgeCount(int expected) {
        WebElement badgeElement = elementActions.findElement(cartBadge);
        String text = badgeElement.getText();
        int actualCount = Integer.parseInt(text);
        Assert.assertEquals(actualCount, expected," Cart badge count mismatch");
        return this;
    }

    @Step("Validate cart badge is not present")
    public CartPage validateCartBadgeNotPresent() {
        boolean isPresent = !driver.findElements(cartBadge).isEmpty();
        Assert.assertFalse(isPresent,"Cart badge is present");
        return this;
    }
    @Step("Reload the cart page")
    public CartPage reloadPage() {
        driver.navigate().refresh();
        return this;
    }



}


