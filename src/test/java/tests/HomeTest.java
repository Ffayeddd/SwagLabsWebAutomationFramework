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

public class HomeTest {
    WebDriver driver ;

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


    @Test
    @Description("verify that user can add backbag to the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)

    public void HM_TC_01() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .addToCartValidation();
    }

    @Test
    @Description("verify that user can add bike light to the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_02() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBikeLightToCart()
                .addToCartValidation();

    }
    @Test
    @Description("verify that user can add bolt t-shirt to the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_03() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBoltTShirtToCart()
                .addToCartValidation();
    }
    @Test
    @Description("verify that user can add fidget spinner to the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_04() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addFleeceJacketToCart()
                .addToCartValidation();
    }

    @Test
    @Description("verify that user can add onesie to the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)

    public void HM_TC_05() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addOnesieToCart()
                .addToCartValidation();
    }

    @Test
    @Description("verify that user can add red t-shirt to the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)

    public void HM_TC_06() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addRedTShirtToCart()
                .addToCartValidation();
    }

    @Test
    @Description("verify that user can add all products to the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_07() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .oneItemInCartValidation()
                .addBikeLightToCart()
                .twoItemsInCartValidation()
                .addBoltTShirtToCart()
                .threeItemsInCartValidation()
                .addFleeceJacketToCart()
                .fourItemsInCartValidation()
                .addOnesieToCart()
                .fiveItemsInCartValidation()
                .addRedTShirtToCart()
                .sixItemsInCartValidation();
    }

    @Test
    @Description("verify that user can remove backbag from the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_08() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .removeBackbagFromCart()
                .removeOneFromCartValidation();
    }

    @Test
    @Description("verify that user can remove bike light from the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_09() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBikeLightToCart()
                .removeBikeLightFromCart()
                .removeOneFromCartValidation();
    }

    @Test
    @Description("verify that user can remove bolt t-shirt from the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_10() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBoltTShirtToCart()
                .removeBoltTShirtFromCart()
                .removeOneFromCartValidation();
    }

    @Test
    @Description("verify that user can remove fleece jacket from the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_11() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addFleeceJacketToCart()
                .removeFleeceJacketFromCart()
                .removeOneFromCartValidation();
    }

    @Test
    @Description("verify that user can remove onesie from the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_12() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addOnesieToCart()
                .removeOnesieFromCart()
                .removeOneFromCartValidation();
    }

    @Test
    @Description("verify that user can remove red t-shirt from the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_13() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addRedTShirtToCart()
                .removeRedTShirtFromCart()
                .removeOneFromCartValidation();

    }

    @Test
    @Description("verify that user can remove all products from the cart")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_14() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .addBackbagToCart()
                .oneItemInCartValidation()
                .addBikeLightToCart()
                .twoItemsInCartValidation()
                .addBoltTShirtToCart()
                .threeItemsInCartValidation()
                .addFleeceJacketToCart()
                .fourItemsInCartValidation()
                .addOnesieToCart()
                .fiveItemsInCartValidation()
                .addRedTShirtToCart()
                .sixItemsInCartValidation()
                .removeBackbagFromCart()
                .fiveItemsInCartValidation()
                .removeBikeLightFromCart()
                .fourItemsInCartValidation()
                .removeBoltTShirtFromCart()
                .threeItemsInCartValidation()
                .removeFleeceJacketFromCart()
                .twoItemsInCartValidation()
                .removeOnesieFromCart()
                .oneItemInCartValidation()
                .removeRedTShirtFromCart()
                .removeOneFromCartValidation();
    }

    @Test
    @Description("validate that all details displayed correctly after clicking on backbag image on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_15() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnBackbagImage()
                .backbagDetailsValidation();

    }
    @Test
    @Description("validate that all details displayed correctly after clicking on backbag header on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_16() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnBackbagHeader()
                .backbagDetailsValidation();
    }

    @Test
    @Description("validate that all details displayed correctly after clicking on bike light image on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_17() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnBikeLightImage()
                .bikeLightDetailsValidation();
    }

    @Test
    @Description("validate that all details displayed correctly after clicking on bike light header on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_18() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnBikeLightHeader()
                .bikeLightDetailsValidation();
    }

    @Test
    @Description("validate that all details displayed correctly after clicking on bolt t-shirt image on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_19() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnBoltTShirtImage()
                .boltTShirtDetailsValidation();
    }
    @Test
    @Description("validate that all details displayed correctly after clicking on bolt t-shirt header on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_20() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnBoltTShirtHeader()
                .boltTShirtDetailsValidation();
    }

    @Test
    @Description("validate that all details displayed correctly after clicking on fleece jacket image on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_21() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnFleeceJacketImage()
                .fleeceJacketDetailsValidation();
    }

    @Test
    @Description("validate that all details displayed correctly after clicking on fleece jacket header on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_22() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnFleeceJacketHeader()
                .fleeceJacketDetailsValidation();
    }

    @Test
    @Description("validate that all details displayed correctly after clicking on onesie image on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_23() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnOnesieImage()
                .onesieDetailsValidation();
    }
    @Test
    @Description("validate that all details displayed correctly after clicking on onesie header on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_24() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnOnesieHeader()
                .onesieDetailsValidation();
    }
   @Test
    @Description("validate that all details displayed correctly after clicking on red t-shirt image on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_25() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnRedTShirtImage()
                .redTShirtDetailsValidation();
    }

    @Test
    @Description("validate that all details displayed correctly after clicking on red t-shirt header on home page")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void HM_TC_26() {
        new LoginPage(driver).
                validLogin()
                .isLoggedIn(getProperty("expectedUrl"))
                .clickOnRedTShirtHeader()
                .redTShirtDetailsValidation();
    }


    @Test
    @Description("validate that hamburger button works properly")
    @Tag("valid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void HM_TC_27()
    { new LoginPage(driver).
            validLogin()
            .isLoggedIn(getProperty("expectedUrl"))
            .hamburgerButtonClick()
            .hamburgerButtonValidation();

    }

    @Test
    @Description("validate that about hyperlink  works properly")
    @Tag("valid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void HM_TC_28()
    { new LoginPage(driver).
            validLogin()
            .isLoggedIn(getProperty("expectedUrl"))
            .hamburgerButtonClick()
            .hamburgerButtonValidation()
            .aboutLinkClick()
            .aboutlinkValidaiton();

    }

    @Test
    @Description("validate that logout hyperlink  works properly")
    @Tag("valid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void HM_TC_29()
    { new LoginPage(driver).
            validLogin()
            .isLoggedIn(getProperty("expectedUrl"))
            .hamburgerButtonClick()
            .hamburgerButtonValidation()
            .logoutLinkClick()
            .logOutValidaiton();

    }

    @Test
    @Description("Verify products are sorted A-Z when selecting first dropdown option")
    @Tag("valid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void HM_TC_30() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .filterByFirstOption()
                .isSortedAtoZ();
    }

    @Test
    @Description("Verify products are sorted Z-A when selecting second dropdown option")
    @Tag("valid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void HM_TC_31() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .filterBySecondOption()
                .isSortedZtoA();
    }


    @Test
    @Description("Verify products are sorted (low-high price) when selecting third dropdown option")
    @Tag("valid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void HM_TC_32() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .filterByThirdOption()
                .isSortedasc();
    }

    @Test
    @Description("Verify products are sorted (high-low price) when selecting fourth dropdown option")
    @Tag("valid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void HM_TC_33() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"))
                .filterByFourthOption()
                .isSorteddesc();
    }


}






