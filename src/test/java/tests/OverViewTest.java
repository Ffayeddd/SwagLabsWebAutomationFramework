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

public class OverViewTest {
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
    @Description("validating that all details for the two  item (BackBag,bike light ) are correct")
    @Tag("validScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void OV_TC_01()
    { new LoginPage(driver)
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
            .backbagItemValidation()
            .bikeLightItemValidation();
    }

    @Test
    @Description("validating the functionality of finish button  ")
    @Tag("validScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void OV_TC_02()
    { new LoginPage(driver)
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
            .finishClick()
            .finishButtonValidation();

    }
    @Test
    @Description("validating the functionality of cancel button  ")
    @Tag("validScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void OV_TC_03()
    { new LoginPage(driver)
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
            .cancelClick()
            .cancelButtonValidation();
    }

    @Test
    @Description("validating the total amount of two items(back bag , bike light ) is correct  ")
    @Tag("validScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void OV_TC_04()
    {
        new LoginPage(driver)
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
                .totalItemsValidation();
    }
    @Test
    @Description("validating the total tax of two items(back bag , bike light ) is correct (8%) ")
    @Tag("validScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void OV_TC_05()
    { new LoginPage(driver)
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
            .totalITaxValidation();

    }
    @Test
    @Description("validating the total amount for two  items(back bag , bike light ) including tax is correct  ")
    @Tag("validScenario")
    @Severity(SeverityLevel.CRITICAL)
    public  void OV_TC_06()
    {
        new LoginPage(driver)
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
                .totalIValidation();
    }

}
