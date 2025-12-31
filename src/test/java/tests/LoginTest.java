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

public class LoginTest {
    //variables
    private WebDriver driver;
    @Test
    @Description("verify that user redirected to home page after valid username and password")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)


    public void LG_TC_01() {
        new LoginPage(driver).
                login(getProperty("validUsername"), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("verify that user can not redirect to home page with invalid username")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.CRITICAL)

    public void LG_TC_02() {
        new LoginPage(driver).

                login(getProperty("invalidUsername"), getProperty("validPassword"))
                .isNotLoggedIn(getProperty("baseUrl"))
                .verifyUserOrPassErrorMsg(getProperty("expectedmsgForInvalidusernameOrpassword"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("verify that user can not redirect to home page with invalid password")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.CRITICAL)

    public void LG_TC_03() {
        new LoginPage(driver).
                login(getProperty("validUsername"), getProperty("invalidPassword"))
                .isNotLoggedIn(getProperty("baseUrl"))
                .verifyUserOrPassErrorMsg(getProperty("expectedmsgForInvalidusernameOrpassword"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("Verify that user cannot log in with spaces in username")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void LG_TC_04() {
        new LoginPage(driver)
                .login(getProperty("spaceUsername"), getProperty("validPassword"))
                .isNotLoggedIn(getProperty("baseUrl"))
                .verifyUserOrPassErrorMsg(getProperty("expectedmsgForInvalidusernameOrpassword"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("Verify that user cannot log in with spaces in password")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void LG_TC_05() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("spacePassword"))
                .isNotLoggedIn(getProperty("baseUrl"))
                .verifyUserOrPassErrorMsg(getProperty("expectedmsgForInvalidusernameOrpassword"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("Verify that user cannot login with empty username")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void LG_TC_06() {
        new LoginPage(driver)
                .login("", getProperty("validPassword"))
                .isNotLoggedIn(getProperty("baseUrl"))
                .verifyemptyUserErrorMsg(getProperty("expectedmsgForEmptyusername"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("Verify that user cannot login with empty password")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void LG_TC_07() {
        new LoginPage(driver)
                .login(getProperty("validUsername"), "")
                .isNotLoggedIn(getProperty("baseUrl"))
                .verifyemptyPassErrorMsg(getProperty("expectedmsgForEmptypassword"));
        LoginPage.softAssert.assertAll();
    }


    @Test
    @Description("Verify that user cannot login with username with uppercase letters")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void LG_TC_08() {
        new LoginPage(driver)
                .login(getProperty("validUsername").toUpperCase(), getProperty("validPassword"))
                .isNotLoggedIn(getProperty("baseUrl"))
                .verifyUserOrPassErrorMsg(getProperty("expectedmsgForInvalidusernameOrpassword"));
        LoginPage.softAssert.assertAll();
    }



    @Test
    @Description("Verify that locked out user cannot login")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void LG_TC_09() {
        new LoginPage(driver)
                .login(getProperty("lockedUser"), getProperty("validPassword"))
                .verifyErrorMessage(getProperty("expectedmsgForLockedAcc"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("Verify that problem_user can login")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void LG_TC_10() {
        new LoginPage(driver)
                .login((getProperty("problemUser")), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("Verify that performance_glitch_user can login")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void LG_TC_11() {
        new LoginPage(driver)
                .login((getProperty("performanceGlitchUser")), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("Verify that error_user can login")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void LG_TC_12() {
        new LoginPage(driver)
                .login((getProperty("errorUser")), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"));
        LoginPage.softAssert.assertAll();
    }


    @Test
    @Description("Verify that visual_user can login")
    @Tag("valid scenario")
    @Severity(SeverityLevel.CRITICAL)
    public void LG_TC_13() {
        new LoginPage(driver)
                .login((getProperty("visualUser")), getProperty("validPassword"))
                .isLoggedIn(getProperty("expectedUrl"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("Verify that user cannot login with both empty username and password")
    @Tag("invalid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void LG_TC_14() {
        new LoginPage(driver)
                .login("", "")
                .isNotLoggedIn(getProperty("baseUrl"))
                .verifyemptyUserErrorMsg(getProperty("expectedmsgForEmptyusername"));
        LoginPage.softAssert.assertAll();
    }

    @Test
    @Description("Verify that the password field is masked(password is not visible)")
    @Tag("valid scenario")
    @Severity(SeverityLevel.NORMAL)
    public void LG_TC_15() {
        new LoginPage(driver)
                .verifyPasswordFieldMasked();
    }

    //before and after configuration
    @BeforeMethod
    public void setup() {
        driver = GuiDriver.initDriver();
        driver.get(getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            GuiDriver.quitDriver();
        }
    }
}




