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

public class CheckOutTest {
   private WebDriver driver ;
   private GuiDriver guiDriver;
    //configuration
    @BeforeMethod
    public void setup() {
        guiDriver = new GuiDriver();
        driver = guiDriver.get(); // constructor sets ThreadLocal
        driver.get(getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        guiDriver.quitDriver();
    }

    @Test
    @Description("Validate ability to continue without filling firstname ")
    @Tag("invalidScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void CO_TC_01 ()
    {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .lastNameType()
                .postalCodeType()
                .continueClick()
                .firstNameIsRequiredError();

    }

    @Test
    @Description("Validate ability to continue without filling lastname ")
    @Tag("invalidScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void CO_TC_02 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameType()
                .postalCodeType()
                .continueClick()
                .lastNameIsRequiredError();
    }

    @Test
    @Description("Validate ability to continue without filling postalcode ")
    @Tag("invalidScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void CO_TC_03 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameType()
                .lastNameType()
                .continueClick()
                .Zip_postalCodeIsRequiredError();
    }
    @Test
    @Description("Validate ability to cancel after filling all information  ")
    @Tag("validScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void CO_TC_04 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameType()
                .lastNameType()
                .postalCodeType()
                .cancelClick()
                .cancelFunctionalityValidation();
    }
    @Test
    @Description("Validate ability to continue after filling all required information ")
    @Tag("validScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void CO_TC_05 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameType()
                .lastNameType()
                .postalCodeType()
                .continueClick()
                .continueFunctionalityValidation();
    }

    @Test
    @Description("validating that cart icon will direct me to cart page   ")
    @Tag("validScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void CO_TC_06 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameType()
                .lastNameType()
                .postalCodeType()
                .catIconClick()
                .cartIconValidation();
    }

    @Test
    @Description("validating that twitter icon will direct me the rightlink   ")
    @Tag("validScenario")
    @Severity(SeverityLevel.MINOR)
    public  void CO_TC_07 ()
    {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .twitterIconClick()
                .twitterIconClick();
    }

    @Test
    @Description("validating that facebook icon will direct me the rightlink   ")
    @Tag("validScenario")
    @Severity(SeverityLevel.MINOR)
    public void CO_TC_08 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .faceBookIconClick()
                .faceBookIconValidation();
    }

    @Test
    @Description("validating that linkidin icon will direct me the rightlink   ")
    @Tag("validScenario")
    @Severity(SeverityLevel.MINOR)
    public  void CO_TC_09 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .linkidINIconClick()
                .linkIdInIconValidation();
    }

    @Test
    @Description("validating that firstname textbox will not accept numbers   ")
    @Tag("validScenario")
    @Severity(SeverityLevel.NORMAL)
    public  void CO_TC_010 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameDigitType()
                .lastNameType()
                .postalCodeType()
                .continueClick()
                .samePageAssertion();

    }

    @Test
    @Description("validating that first name textbox will not accept 1 letter  ")
    @Tag("validScenario")
    @Severity(SeverityLevel.NORMAL)
    public  void CO_TC_011() {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstName1LetterType()
                .lastNameType()
                .postalCodeType()
                .continueClick()
                .samePageAssertion();
    }

    @Test
    @Description("validating that lastname textbox will not accept numbers   ")
    @Tag("validScenario")
    @Severity(SeverityLevel.NORMAL)
    public  void CO_TC_012 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameType()
                .lastNameDigitType()
                .postalCodeType()
                .continueClick()
                .samePageAssertion();
    }

    @Test
    @Description("validating that lstname textbox will not accept 1 letter   ")
    @Tag("validScenario")
    @Severity(SeverityLevel.NORMAL)
    public  void CO_TC_013 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameType()
                .lastName1letterType()
                .postalCodeType()
                .continueClick()
                .samePageAssertion();
    }

    @Test
    @Description("validating that zip code textbox will not accept letters   ")
    @Tag("validScenario")
    @Severity(SeverityLevel.NORMAL)
    public  void CO_TC_014 () {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameType()
                .lastNameType()
                .postalCodeLettersType()
                .continueClick()
                .samePageAssertion();

    }

    @Test
    @Description("validating that postal code textbox will not accept 1 digit   ")
    @Tag("validScenario")
    @Severity(SeverityLevel.NORMAL)
    public  void CO_TC_015() {
        new LoginPage(driver)
                .validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .cartClick()
                .checkOutClick()
                .firstNameType()
                .lastNameType()
                .postalCode1DigitType()
                .continueClick()
                .samePageAssertion();
    }

}
