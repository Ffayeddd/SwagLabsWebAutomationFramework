package pages;

import MyActions.ElementActions;
import Readers.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static Readers.PropertyReader.getProperty;

public class OverViewPage {
    private final WebDriver driver ;
    private ElementActions elementActions;

    //Locators
    private  final By finishButton = By.cssSelector(PropertyReader.getProperty("finishButtonLocator"));
    private  final By cancelButton = By.cssSelector(PropertyReader.getProperty("cancellButtonLocator"));
    private final By BackBagPrice = By.cssSelector(PropertyReader.getProperty("BackBagPriceLocator"));
    private final By backBagHeader = By.cssSelector(PropertyReader.getProperty("backBagHeaderLocator"));
    private final By backBagBaragrapgh = By.cssSelector(PropertyReader.getProperty("backBagBaragrapghLocator"));
    private final By bikeLightPrice = By.xpath(PropertyReader.getProperty("bikeLightPriceLocator"));
    private final By bikeLightHeader= By.cssSelector(PropertyReader.getProperty("bikeLightHeaderLocator"));
    private final By bikeLightParagrapgh= By.xpath(PropertyReader.getProperty("bikeLightParagrapghLocator"));
    private final By totalNetitemsprice= By.cssSelector(PropertyReader.getProperty("totalNetitemspriceLocator"));
    private  final By totalTax = By.cssSelector(PropertyReader.getProperty("totalTaxLocator"));
    private  final By total = By.cssSelector(PropertyReader.getProperty("totalLocator"));

    //constructor
    public OverViewPage(WebDriver driver)
    { this.driver=driver;
        elementActions=new ElementActions(driver);
    }

    //methods

    @Step("Finish Clicking")
    public OverViewPage finishClick()
    {
        elementActions.myCLick(finishButton);
        return this ;

    }
    @Step("Finish Clicking")
    public CompletePage finishClickmove()
    {
        elementActions.myCLick(finishButton);
        return new CompletePage(driver) ;

    }
    @Step("Valid scenario")
    public CompletePage validScenario ()
    {  new LoginPage(driver)
            .validLogin()
            .isLoggedIn(getProperty("expectedUrl"))
            .addBackbagToCart()
            .addBikeLightToCart()
            .cartClick()
            .checkOutClick()
            .firstNameType()
            .lastNameType()
            .postalCodeType()
            .continueClickmove()
            .finishClick();
        return new CompletePage(driver);
    }

    @Step("cancel Clicking")
    public OverViewPage cancelClick()
    {
        elementActions.myCLick(cancelButton);
        return this ;

    }

// --Assertions----Assertions----Assertions----Assertions----Assertions----Assertions--
                               //Hard Assertions
    @Step("validating Finish Button Functionality")
    public void finishButtonValidation()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("completeLink"));
    }

    @Step("Validating cancel Button Functionality")
    public void cancelButtonValidation()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("expectedUrl"));
    }
    @Step("Validating that Total price of the two items is accurate ")
    public void totalItemsValidation ()
    {
         Assert.assertTrue(driver.findElement(totalNetitemsprice).getText().contains("39.98"));
    }
    @Step("Validating that Total tax of the two items is 8% ")
    public void totalITaxValidation ()
    {
        Assert.assertTrue(driver.findElement(totalTax).getText().contains("3.20"));
    }
    @Step("Validating that Total price  of the two items including tax is accurate ")
    public void totalIValidation ()
    {
        Assert.assertTrue(driver.findElement(total).getText().contains("43.18"));
    }


                                    //soft assertion
    @Step("validating that all details for backbag items included")
    public OverViewPage backbagItemValidation ()
    {
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(driver.findElement(backBagHeader).getText(),"Sauce Labs Backpack");
        softAssert.assertTrue(driver.findElement(backBagBaragrapgh).getText().contains("carry.allTheThings"));
        softAssert.assertEquals(driver.findElement(BackBagPrice).getText(),"$29.99");
        softAssert.assertAll();
        return this ;
    }

    @Step("validating that all details for bikeLight items included")
    public OverViewPage bikeLightItemValidation ()
    {
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertEquals(driver.findElement(bikeLightHeader).getText(),"Sauce Labs Bike Light");
        softAssert.assertTrue(driver.findElement(bikeLightParagrapgh).getText().contains("A red light isn't "));
        softAssert.assertEquals(driver.findElement(bikeLightPrice).getText(),"$9.99");
        softAssert.assertAll();
        return this;
    }


    }

