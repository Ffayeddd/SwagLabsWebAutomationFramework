package pages;

import MyActions.ElementActions;
import Readers.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

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
        this. elementActions=new ElementActions(driver);
        softAssert = new SoftAssert();
    }

    //Methods-ations

    @Step("clicking on checkout button")
    public CheckOutPage checkOutClick()
    {
        elementActions.myCLick(checkout_Button);

        return new CheckOutPage(driver);
    }


    @Step("Remove Backbag product from the cart")
    public CartPage removeBackbagFromCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement removeBtn = wait.until(ExpectedConditions.elementToBeClickable(removeBackbagBtn));
        removeBtn.click();
        return this;
    }


    @Step("Click Checkout button and verify user is NOT redirected when cart is empty")
    public CartPage clickCheckoutofCartWhenEmpty() {

        boolean isProductPresent = !driver.findElements(removeBackbagBtn).isEmpty();
        Assert.assertFalse(isProductPresent, "Cart should be empty after removing all products");
        elementActions.myCLick(checkout_Button);

        String actualUrl = driver.getCurrentUrl();
        String checkoutPageUrl = PropertyReader.getProperty("checkoutPageUrl");

        Assert.assertNotEquals(
                actualUrl,
                checkoutPageUrl,
                " Bug: User was redirected to checkout page even though cart is empty!"
        );
        return this;
    }

    @Step("verify that checkout button is redirected correctly to checkout ")
    public CheckOutPage clickCheckoutofCart() {
        elementActions.myCLick(checkout_Button);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrlcart = PropertyReader.getProperty("checkoutPageUrl");
        Assert.assertEquals(actualUrl, expectedUrlcart, " User should be redirected to Checkout page after clicking Checkout button");
        return new CheckOutPage(driver);

    }


    @Step("verify that continue shopping button is redirected correctly to home page")
    public HomePage clickContinueShopping(String expectedUrl) {
        elementActions.myCLick(continueShopping_Button);
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "User should be redirected back to Home Page after clicking Continue Shopping");
        return new HomePage(driver);
    }


    @Step("Validation that details are displayed correctly for Backbag product in Cart")
    public CartPage backbagCartValidation() {
        SoftAssert softAssert = new SoftAssert();

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(cartProductName));

        softAssert.assertEquals(
                driver.findElement(cartProductName).getText(),
                "Sauce Labs Backpack",
                " Product name mismatch");
        softAssert.assertTrue(
                driver.findElement(cartProductDescription).getText().
                        contains("allTheThings()"),
                "Product description mismatch");

        softAssert.assertEquals(
                driver.findElement(cartProductPrice).
                        getText(),
                "$29.99",
                "Product price mismatch");


        return this;
    }


    @Step("Validate cart badge count equals {count}")
    public CartPage validateCartBadgeCount(int expected) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement badgeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        int actualCount = Integer.parseInt(badgeElement.getText());
        Assert.assertEquals(actualCount, expected, "Cart badge count mismatch");
        return this;
    }

    @Step("Validate cart badge is not present")
    public CartPage validateCartBadgeNotPresent() {
        boolean isPresent = !driver.findElements(cartBadge).isEmpty();
        Assert.assertFalse(isPresent, "Cart badge should not be present when cart is empty");
        return this;
    }
    @Step("Reload the cart page")
    public CartPage reloadPage() {
        driver.navigate().refresh();
        return this;
    }



}


