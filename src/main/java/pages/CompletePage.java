package pages;

import MyActions.ElementActions;
import Readers.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CompletePage {
    private final WebDriver driver ;
    private ElementActions elementActions;

     //locators
    private final By correctMark =By.cssSelector(PropertyReader.getProperty("correctMarkLocator"));
    private final By thanksMessage =By.cssSelector(PropertyReader.getProperty("thanksMessageLocator"));
    private final By paraghragh =By.cssSelector(PropertyReader.getProperty("paraghraghLocator"));
    private final By backHomeButton =By.cssSelector(PropertyReader.getProperty("backHomeButtonLocator"));


    //constructor
    public CompletePage(WebDriver driver)
    {
        this.driver=driver;
        elementActions=new ElementActions(driver);
    }


    //methods
    @Step("clicking on back home button")
    public CompletePage backHomeClick()
    {
        elementActions.myCLick(backHomeButton);
        return this ;
    }
    // --Assertions----Assertions----Assertions----Assertions----Assertions----Assertions--
                                     //Hard Assertions
    @Step("validate on backhome functionality")
    public void backHomeValidation ()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("expectedUrl"));
    }
                                    //soft Assertion

    @Step("validate on complete page details")
    public void completeAssertion ()
    {
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(driver.findElement(correctMark).isDisplayed());
        softAssert.assertEquals(driver.findElement(thanksMessage).getText(),"Thank you for your order!");
        softAssert.assertTrue(driver.findElement(paraghragh).getText().contains("Your order has been dispatched"));
        softAssert.assertAll();
    }

}
