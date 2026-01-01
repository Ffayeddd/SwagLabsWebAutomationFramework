package pages;

import MyActions.ElementActions;
import Readers.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOutPage {
    private final WebDriver driver ;
    private ElementActions elementActions;

    //locators
    private final By firstNameLabel = By.cssSelector(PropertyReader.getProperty("firstNameLabelLocator"));
    private final By lastNameLabel =By.cssSelector(PropertyReader.getProperty("lastNameLabelLocator"));
    private final By zip_postalCode=By.cssSelector(PropertyReader.getProperty("zip_postalCodeLocators"));
    private final By cancelButton=By.cssSelector(PropertyReader.getProperty("cancelButtonLocator"));
    private final By continueButton=By.cssSelector(PropertyReader.getProperty("continueButtonLocator"));
    private final By errorMessage =By.cssSelector(PropertyReader.getProperty("errorMessageLocator"));
    private final By cartIcon =By.cssSelector(PropertyReader.getProperty("cartIconLocator"));
    private final By twitterIcon=By.cssSelector(PropertyReader.getProperty("twitterIconLocator"));
    private final By faceBookIcon=By.cssSelector(PropertyReader.getProperty("faceBookIconLocator"));
    private final By linkidINIcon =By.cssSelector(PropertyReader.getProperty("linkidINIconLocator"));

    //Constructor
    public CheckOutPage(WebDriver driver)
    {
        this.driver=driver;
        elementActions=new ElementActions(driver);
    }

    //Methods-Actions

    @Step("entering frist name ")
    public CheckOutPage firstNameType()
    {
        elementActions.MyType(firstNameLabel,PropertyReader.getProperty("validfirstName"));
        return this;

    }

    @Step("entering last name ")
    public CheckOutPage lastNameType()
    {
        elementActions.MyType(lastNameLabel,PropertyReader.getProperty("validlastName"));
        return this;
    }

    @Step("entering zipCode ")
    public CheckOutPage postalCodeType()
    {
        elementActions.MyType(zip_postalCode,PropertyReader.getProperty("validzipCode"));
        return  this;

    }

    @Step("clicking on cancel button ")
    public CheckOutPage cancelClick ()
    {
        elementActions.myCLick(cancelButton);
        return  this;
    }

    @Step("entering continue  button ")
    public CheckOutPage continueClick()
    {
        elementActions.myCLick(continueButton);
        return  this;
    }
    @Step("entering continue  button ")
    public OverViewPage continueClickmove()
    {
        elementActions.myCLick(continueButton);
        return  new OverViewPage(driver);
    }





    @Step("clicking on cartIcon")
    public CheckOutPage catIconClick()
    {
        elementActions.myCLick(cartIcon);
        return  this;
    }

    @Step("Entering invalid firstname (number)")
    public CheckOutPage firstNameDigitType()
    {
        elementActions.MyType(firstNameLabel,"firstNameDigits");
        return this ;
    }
    @Step("Entering invalid firstname (1 letter)")
    public CheckOutPage firstName1LetterType()
    {
        elementActions.MyType(firstNameLabel,"firstName1letter");
        return this ;
    }
    @Step("Entering invalid lastname (number)")
    public CheckOutPage lastNameDigitType()
    {
        elementActions.MyType(lastNameLabel,"lastNameDigits");
        return this ;
    }
    @Step("Entering invalid lastname (1letter)")
    public CheckOutPage lastName1letterType()
    {
        elementActions.MyType(lastNameLabel,"lastName1letter");
        return this ;
    }

    @Step("Entering invalid postalcode (letters)")
    public CheckOutPage postalCodeLettersType()
    {
        elementActions.MyType(zip_postalCode,"zipCodeletter");
        return this ;
    }

    @Step("Entering invalid postalcode (1number)")
    public CheckOutPage postalCode1DigitType()
    {
        elementActions.MyType(zip_postalCode,"zipCode1digit");
        return this ;
    }





    //footer methods
    @Step("clicking on twitter icon")
    public CheckOutPage twitterIconClick ()
    {
        elementActions.myCLick(twitterIcon);
        return  this;
    }
    @Step("clicking on facebook icon")
    public CheckOutPage faceBookIconClick ()
    {
        elementActions.myCLick(faceBookIcon);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        return  this;
    }
    @Step("clicking on Linkidin icon")
    public CheckOutPage linkidINIconClick ()
    {
        elementActions.myCLick(linkidINIcon);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        return  this;
    }



    // --Assertions----Assertions----Assertions----Assertions----Assertions----Assertions--
    //Hard Assertions
    @Step("validating on firstName error message")
    public void firstNameIsRequiredError()
    {

        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Error: First Name is required");

    }

    @Step("validating on lastName error message")
    public void lastNameIsRequiredError()
    {

        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Error: Last Name is required");

    }

    @Step("validating on ziCode error message")
    public void Zip_postalCodeIsRequiredError()
    {

        Assert.assertEquals(driver.findElement(errorMessage).getText(),"Error: Postal Code is required");
    }

    @Step("validating on cancel button functionality")
    public void cancelFunctionalityValidation()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("cartlink"));
    }

    @Step("validating on continue button functionality")
    public void continueFunctionalityValidation()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("overviewlink"));
    }

    @Step ("cart icon return to cart page validation ")
    public void cartIconValidation()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("cartlink"));
    }

    @Step ("Validate that we still in the same page ")
    public void samePageAssertion()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("checkOutPageLink"),"you are not in the same page");
    }

    //footer validation

    @Step ("twitter icon direction validation ")
    public void twitterIconValidation()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("twitterLink"));
    }
    @Step ("facebook icon direction validation ")
    public void faceBookIconValidation()
    {
        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("facebookLink"));
    }

    @Step ("linkidin icon direction validation ")
    public void linkIdInIconValidation()
    {

        Assert.assertEquals(driver.getCurrentUrl(),PropertyReader.getProperty("linkidInLink"));
    }



}
