package pages;

import MyActions.ElementActions;
import Readers.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class HomePage {

    private final WebDriver driver ;
    private ElementActions elementActions;

    //add locators
    private final By sl_BackbagAddToCart = By.id(PropertyReader.getProperty("scBackBagLocator"));
    private final By sl_BikeLightAddToCart = By.id(PropertyReader.getProperty("scBikeLightLocator"));
    private final By sl_BoltTShirtAddToCart = By.id(PropertyReader.getProperty("scBoltTShirtLocator"));
    private final By sl_FleeceJacketAddToCart = By.id(PropertyReader.getProperty("scFleeceJacketLocator"));
    private final By sl_OnesieAddToCart = By.id(PropertyReader.getProperty("scOnesieLocator"));
    private final By sl_RedTShirtAddToCart = By.id(PropertyReader.getProperty("scRedTShirtLocator"));
    private  final By cartProductQuantity = By.cssSelector(PropertyReader.getProperty("cartProductQuantityLocator"));

    //remove locators
    private  final By sl_BackbagRemoveFromCart = By.id(PropertyReader.getProperty("sl_BackButtonRemoveLocator"));
    private final By sl_BikeLightRemoveFromCart = By.id(PropertyReader.getProperty("sl_BikeLightRemoveLocator"));
    private final By sl_BoltTShirtRemoveFromCart = By.id(PropertyReader.getProperty("sl_BoltTShirtRemoveLocator"));
    private final By  sl_FleeceJacketRemoveFromCart = By.id(PropertyReader.getProperty("sl_FleeceJacketRemoveLocator"));
    private final By sl_OnesieRemoveFromCart = By.id(PropertyReader.getProperty("sl_OnesieRemoveLocator"));
    private  final By sl_RedTShirtRemoveFromCart = By.id(PropertyReader.getProperty("sl_RedTShirtRemoveLocator"));
    //image locators and paragraph locators
    //Backbag locators
    private final By img_Backbag = By.cssSelector(PropertyReader.getProperty("imgBackBagLocator"));
    private final By no_Header_Backbag = By.cssSelector(PropertyReader.getProperty("normalHeaderBackBagLocator"));
    private final By de_Header_Backbag = By.cssSelector(PropertyReader.getProperty("detailedHeaderBackBagLocator"));
    private final By paragraph_Backbag = By.cssSelector(PropertyReader.getProperty("paragraphBackBagLocator"));
    private final By price_Backbag = By.cssSelector(PropertyReader.getProperty("priceBackBagLocator"));
    //BikeLight locators
    private final By img_BikeLight = By.cssSelector(PropertyReader.getProperty("imgBikeLightLocator"));
    private final By no_Header_BikeLight = By.cssSelector(PropertyReader.getProperty("normalHeaderBikeLightLocator"));
    private final By de_Header_BikeLight = By.cssSelector(PropertyReader.getProperty("detailedHeaderBikeLightLocator"));
    private final By paragraph_BikeLight = By.cssSelector(PropertyReader.getProperty("paragraphBikeLightLocator"));
    private final By price_BikeLight = By.cssSelector(PropertyReader.getProperty("priceBikeLightLocator"));
    //BoltTShirt locators
    private final By img_BoltTShirt = By.cssSelector(PropertyReader.getProperty("imgBoltTShirtLocator"));
    private final By no_Header_BoltTShirt = By.cssSelector(PropertyReader.getProperty("normalHeaderBoltTShirtLocator"));
    private final By de_Header_BoltTShirt = By.cssSelector(PropertyReader.getProperty("detailedHeaderBoltTShirtLocator"));
    private final By paragraph_BoltTShirt = By.cssSelector(PropertyReader.getProperty("paragraphBoltTShirtLocator"));
    private final By price_BoltTShirt = By.cssSelector(PropertyReader.getProperty("priceBoltTShirtLocator"));
    //FleeceJacket locators
    private final By img_FleeceJacket = By.cssSelector(PropertyReader.getProperty("imgFleeceJacketLocator"));
    private final By no_Header_FleeceJacket = By.cssSelector(PropertyReader.getProperty("normalHeaderFleeceJacketLocator"));
    private final By de_Header_FleeceJacket = By.cssSelector(PropertyReader.getProperty("detailedHeaderFleeceJacketLocator"));
    private final By paragraph_FleeceJacket = By.cssSelector(PropertyReader.getProperty("paragraphFleeceJacketLocator"));
    private final By price_FleeceJacket = By.cssSelector(PropertyReader.getProperty("priceFleeceJacketLocator"));
    //Onesie locators
    private final By img_Onesie = By.cssSelector(PropertyReader.getProperty("imgOnesieLocator"));
    private final By no_Header_Onesie = By.cssSelector(PropertyReader.getProperty("normalHeaderOnesieLocator"));
    private final By de_Header_Onesie = By.cssSelector(PropertyReader.getProperty("detailedHeaderOnesieLocator"));
    private final By paragraph_Onesie = By.cssSelector(PropertyReader.getProperty("paragraphOnesieLocator"));
    private final By price_Onesie = By.cssSelector(PropertyReader.getProperty("priceOnesieLocator"));
    //RedTShirt locators
    private final By img_RedTShirt = By.cssSelector(PropertyReader.getProperty("imgRedTShirtLocator"));
    private final By no_Header_RedTShirt = By.cssSelector(PropertyReader.getProperty("normalHeaderRedTShirtLocator"));
    private final By de_Header_RedTShirt = By.cssSelector(PropertyReader.getProperty("detailedHeaderRedTShirtLocator"));
    private final By paragraph_RedTShirt = By.cssSelector(PropertyReader.getProperty("paragraphRedTShirtLocator"));
    private final By price_RedTShirt = By.cssSelector(PropertyReader.getProperty("priceRedTShirtLocator"));
     //cart button
    private final By cartButton =By.cssSelector(PropertyReader.getProperty("cartButtonLocator"));
    //sideMenu
    private final By hamburgerButton =By.cssSelector(PropertyReader.getProperty("hamburgerButtonLocator"));
    private final By aboutLink =By.cssSelector(PropertyReader.getProperty("aboutLinkLocator"));
    private final By logoutLink =By.cssSelector(PropertyReader.getProperty("logoutLinkLocator"));
    // Filteration Locators
    private final By filterDropdownLocator = By.className(PropertyReader.getProperty("dropDownLocator"));
    private final By productNameLocator = By.className(PropertyReader.getProperty("productNameLocator"));
    private final By productPriceLocator = By.className(PropertyReader.getProperty("productPriceLocator"));




    //constructor
    public  HomePage(WebDriver driver)
    {
        this.driver=driver;
        this.elementActions=new ElementActions(driver);

    }
    //Methods / Actions

    @Step("Filter products by first dropdown option")
    public HomePage filterByFirstOption() {
        elementActions.Dropdown(filterDropdownLocator, 0);
        return this;
    }
    @Step("Verify products are sorted A-Z")
    public HomePage isSortedAtoZ() {
        List<String> names = driver.findElements(productNameLocator)
                .stream()
                .map(WebElement::getText)
                .toList();

        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames);
        Assert.assertEquals(names, sortedNames, "Products are not sorted A-Z");
        return this;
    }

    @Step("Filter products by second dropdown option")
    public HomePage filterBySecondOption() {
        elementActions.Dropdown(filterDropdownLocator, 1);
        return this;
    }

    @Step("Verify products are sorted Z-A")
    public HomePage isSortedZtoA() {
        List<String> names = driver.findElements(productNameLocator)
                .stream()
                .map(WebElement::getText)
                .toList();

        List<String> sortedNames = new ArrayList<>(names);
        Collections.sort(sortedNames, Collections.reverseOrder());

        Assert.assertEquals(names, sortedNames, "Products are not sorted Z-A");
        return this;
    }


    @Step("Filter products by third dropdown option(price low-high)")
    public HomePage filterByThirdOption() {
        elementActions.Dropdown(filterDropdownLocator, 2);
        return this;
    }


    @Step("Verify products are sorted from low to high price")
    public HomePage isSortedasc() {
        List<Double> prices = driver.findElements(productPriceLocator)
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .toList();

        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices);

        Assert.assertEquals(prices, sortedPrices, "Products are not sorted from low to high price");
        return this;
    }

    @Step("Filter products by fourth dropdown option(price high-low)")
    public HomePage filterByFourthOption() {
        elementActions.Dropdown(filterDropdownLocator, 3);
        return this;
    }

    @Step("Verify products are sorted from high to low price")
    public HomePage isSorteddesc() {
        List<Double> prices = driver.findElements(productPriceLocator)
                .stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "")))
                .toList();

        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices, Collections.reverseOrder());

        Assert.assertEquals(prices, sortedPrices, "Products are not sorted from high to low price");
        return this;
    }





    //*********************************************************************
    //Methods / Actions

    @Step("click on cart Button")
    public CartPage cartClick()
    {
        elementActions.myCLick(cartButton);
        return new CartPage(driver);
    }
    @Step("Add product to the cart")
    public HomePage addToCart (By locator )
    {
        elementActions.myCLick(locator);
        return this ;
    }

    @Step("Add Backbag product to the cart")
    public HomePage addBackbagToCart ()
    {
        addToCart(sl_BackbagAddToCart);
        return this ;
    }
    @Step("Add Bike Light product to the cart")
    public HomePage addBikeLightToCart ()
    {
        addToCart(sl_BikeLightAddToCart);
        return this ;
    }

    @Step("Add Bolt TShirt product to the cart")
    public HomePage addBoltTShirtToCart ()
    {
        addToCart(sl_BoltTShirtAddToCart);
        return this ;
    }
    @Step("Add Fleece Jacket product to the cart")
    public HomePage addFleeceJacketToCart ()
    {
        addToCart(sl_FleeceJacketAddToCart);
        return this ;
    }
    @Step("Add Onesie product to the cart")
    public HomePage addOnesieToCart ()
    {
        addToCart(sl_OnesieAddToCart);
        return this ;
    }

    @Step("Add Red TShirt product to the cart")
    public HomePage addRedTShirtToCart ()
    {
        addToCart(sl_RedTShirtAddToCart);
        return this ;
    }

    @Step("Remove Backbag product from the cart")
    public HomePage removeBackbagFromCart () {
        elementActions.myCLick(sl_BackbagRemoveFromCart);
        return this;
    }

    @Step("Remove Bike Light product from the cart")
    public HomePage removeBikeLightFromCart () {
        elementActions.myCLick(sl_BikeLightRemoveFromCart);
        return this;
    }

    @Step("Remove Bolt TShirt product from the cart")
    public HomePage removeBoltTShirtFromCart () {
        elementActions.myCLick(sl_BoltTShirtRemoveFromCart);
        return this;
    }

    @Step("Remove Fleece Jacket product from the cart")
    public HomePage removeFleeceJacketFromCart () {
        elementActions.myCLick(sl_FleeceJacketRemoveFromCart);
        return this;
    }

    @Step("Remove Onesie product from the cart")
    public HomePage removeOnesieFromCart () {
        elementActions.myCLick(sl_OnesieRemoveFromCart);
        return this;
    }

    @Step("Remove Red TShirt product from the cart")
    public HomePage removeRedTShirtFromCart () {
        elementActions.myCLick(sl_RedTShirtRemoveFromCart);
        return this;
    }

    @Step("Click on Backbag image")
    public HomePage clickOnBackbagImage ()
    {
        elementActions.myCLick(img_Backbag);
        return this ;
    }

    @Step("Click on Backbag header")
    public HomePage clickOnBackbagHeader ()
    {
        elementActions.myCLick(no_Header_Backbag);
        return this ;
    }
    @Step("Click on Bike Light image")
    public HomePage clickOnBikeLightImage ()
    {
        elementActions.myCLick(img_BikeLight);
        return this ;
    }

    @Step("Click on Bike Light header")
    public HomePage clickOnBikeLightHeader ()
    {
        elementActions.myCLick(no_Header_BikeLight);;
        return this ;
    }
    @Step("Click on Bolt TShirt image")
    public HomePage clickOnBoltTShirtImage ()
    {
        elementActions.myCLick(img_BoltTShirt);
        return this ;
    }
    @Step("Click on Bolt TShirt header")
    public HomePage clickOnBoltTShirtHeader ()
    {
        elementActions.myCLick(no_Header_BoltTShirt);
        return this ;
    }
    @Step("Click on Fleece Jacket image")
    public HomePage clickOnFleeceJacketImage ()
    {
        elementActions.myCLick(img_FleeceJacket);
        return this ;
    }
    @Step("Click on Fleece Jacket header")
    public HomePage clickOnFleeceJacketHeader ()
    {
        elementActions.myCLick(no_Header_FleeceJacket);
        return this ;
    }
    @Step("Click on Onesie image")
    public HomePage clickOnOnesieImage ()
    {
        elementActions.myCLick(img_Onesie);
        return this ;
    }
    @Step("Click on Onesie header")

    public HomePage clickOnOnesieHeader ()
    {
        elementActions.myCLick(no_Header_Onesie);
        return this ;
    }
    @Step("Click on Red TShirt image")
    public HomePage clickOnRedTShirtImage ()
    {
        elementActions.myCLick(img_RedTShirt);
        return this ;
    }
    @Step("Click on Red TShirt header")
    public HomePage clickOnRedTShirtHeader ()
    {
        elementActions.myCLick(no_Header_RedTShirt);
        return this ;
    }

    //side menu methods

    @Step("hamburger button clicking")
    public HomePage hamburgerButtonClick()
    {
        elementActions.myCLick(hamburgerButton);
        return this ;
    }

    @Step("about  hyperlink clicking")
    public HomePage aboutLinkClick()
    {
        elementActions.myCLick(aboutLink);
        return this ;
    }

    @Step("logout  hyperlink clicking")
    public HomePage logoutLinkClick()
    {
        elementActions.myCLick(logoutLink);
        return this ;
    }





    // --Assertions----Assertions----Assertions----Assertions----Assertions----Assertions--
                           //Hard Assertions

    @Step("Validation to make sure that the product added to the cart ")
    public HomePage addToCartValidation ()
    {
        Assert.assertTrue(driver.findElement(cartProductQuantity).isDisplayed());
        return this;
    }

    @Step("Validation to make sure that the product added to the cart ")
    public HomePage oneItemInCartValidation()
    {
        Assert.assertEquals(driver.findElement(cartProductQuantity).getText(),"1");
        return this;
    }

    @Step ("Validation to make sure that two products added to the cart ")
    public HomePage twoItemsInCartValidation ()
    {
        Assert.assertEquals(driver.findElement(cartProductQuantity).getText(),"2");
        return this;
    }

    @Step ("Validation to make sure that three products added to the cart ")
    public HomePage threeItemsInCartValidation ()

    {
        Assert.assertEquals(driver.findElement(cartProductQuantity).getText(),"3");
        return this;
    }
    @Step ("Validation to make sure that four products added to the cart ")
    public HomePage fourItemsInCartValidation ()
    {
        Assert.assertEquals(driver.findElement(cartProductQuantity).getText(),"4");
        return this;
    }
    @Step ("Validation to make sure that five products added to the cart ")
    public HomePage fiveItemsInCartValidation ()
    {
        Assert.assertEquals(driver.findElement(cartProductQuantity).getText(),"5");
        return this;
    }

    @Step ("Validation to make sure that all products added to the cart ")
    public HomePage sixItemsInCartValidation()
    {
        Assert.assertEquals(driver.findElement(cartProductQuantity).getText(),"6");
        return this;
    }

    private   boolean availabilityoOfCartQuantity () {

        try {
            return driver.findElement(cartProductQuantity).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    @Step("Validation to make sure that one product removed from the cart ")
    public void removeOneFromCartValidation()
    {

        Assert.assertFalse(availabilityoOfCartQuantity());

    }

                    // Soft Assertions
    @Step("validation that image and other details are displayed correctly for Backbag product")
    public void backbagDetailsValidation ()
    {
        SoftAssert softAssert = new SoftAssert();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(img_Backbag));
        softAssert.assertTrue(driver.findElement(img_Backbag).isDisplayed());
        softAssert.assertEquals(driver.findElement(de_Header_Backbag).getText(),"Sauce Labs Backpack");
        softAssert.assertTrue(driver.findElement(paragraph_Backbag).getText().contains("carry.allTheThings()"));
        softAssert.assertEquals(driver.findElement(price_Backbag).getText(),"$29.99");
        softAssert.assertAll();

    }

    @Step("validation that image and other details are displayed correctly for Bike Light product")
    public void bikeLightDetailsValidation () {
        SoftAssert softAssert = new SoftAssert();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(img_BikeLight));
        softAssert.assertTrue(driver.findElement(img_BikeLight).isDisplayed());
        softAssert.assertEquals(driver.findElement(de_Header_BikeLight).getText(), "Sauce Labs Bike Light");
        softAssert.assertTrue(driver.findElement(paragraph_BikeLight).getText().contains("A red light isn't the desired state "));
        softAssert.assertEquals(driver.findElement(price_BikeLight).getText(), "$9.99");
        softAssert.assertAll();
    }

    @Step("validation that image and other details are displayed correctly for Bolt TShirt product")
    public void boltTShirtDetailsValidation () {
        SoftAssert softAssert = new SoftAssert();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(img_BoltTShirt));
        softAssert.assertTrue(driver.findElement(img_BoltTShirt).isDisplayed());
        softAssert.assertEquals(driver.findElement(de_Header_BoltTShirt).getText(), "Sauce Labs Bolt T-Shirt");
        softAssert.assertTrue(driver.findElement(paragraph_BoltTShirt).getText().contains("Get your testing superhero"));
        softAssert.assertEquals(driver.findElement(price_BoltTShirt).getText(), "$15.99");
        softAssert.assertAll();
    }
    @Step("validation that image and other details are displayed correctly for Fleece Jacket product")
    public void fleeceJacketDetailsValidation () {
        SoftAssert softAssert = new SoftAssert();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(img_FleeceJacket));
        softAssert.assertTrue(driver.findElement(img_FleeceJacket).isDisplayed());
        softAssert.assertEquals(driver.findElement(de_Header_FleeceJacket).getText(), "Sauce Labs Fleece Jacket");
        softAssert.assertTrue(driver.findElement(paragraph_FleeceJacket).getText().contains("It's not every day that you come"));
        softAssert.assertEquals(driver.findElement(price_FleeceJacket).getText(), "$49.99");
    }
    @Step("validation that image and other details are displayed correctly for Onesie product")
    public void onesieDetailsValidation () {
        SoftAssert softAssert = new SoftAssert();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(img_Onesie));
        softAssert.assertTrue(driver.findElement(img_Onesie).isDisplayed());
        softAssert.assertEquals(driver.findElement(de_Header_Onesie).getText(), "Sauce Labs Onesie");
        softAssert.assertTrue(driver.findElement(paragraph_Onesie).getText().contains("Rib snap infant onesie for the junior"));
        softAssert.assertEquals(driver.findElement(price_Onesie).getText(), "$7.99");
        softAssert.assertAll();
    }

    @Step("validation that image and other details are displayed correctly for Red TShirt product")
    public void redTShirtDetailsValidation () {
        SoftAssert softAssert = new SoftAssert();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(img_RedTShirt));
        softAssert.assertTrue(driver.findElement(img_RedTShirt).isDisplayed());
        softAssert.assertEquals(driver.findElement(de_Header_RedTShirt).getText(), "Test.allTheThings() T-Shirt (Red)");
        softAssert.assertTrue(driver.findElement(paragraph_RedTShirt).getText().contains("ringspun combed cotton"));
        softAssert.assertEquals(driver.findElement(price_RedTShirt).getText(), "$15.99");
        softAssert.assertAll();
    }

    @Step("hamburger button functionality validation")
    public HomePage hamburgerButtonValidation ()
    {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(aboutLink));
        Assert.assertTrue(driver.findElement(aboutLink).isDisplayed());
        return this;
    }

    @Step("about hyperlink functionality validation ")
    public void aboutlinkValidaiton ()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("aboutSauceLabs"));
    }

    @Step("logout hyperlink functionality validation ")
    public void logOutValidaiton ()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("baseUrl"));
    }


}
