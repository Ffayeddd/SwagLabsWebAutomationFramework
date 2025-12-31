package pages;
import MyActions.ElementActions;
import Readers.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginPage {

    //variable
    private final WebDriver driver;
    private final ElementActions elementActions;
    public static SoftAssert softAssert;


    //locator
    private final By userName = By.id(PropertyReader.getProperty("userNameLocator"));
    private final By password = By.id(PropertyReader.getProperty("passwordLocator"));
    private final By loginButton = By.id(PropertyReader.getProperty("loginButtonLocator"));
    private final By lockedAccErrorMessage = By.cssSelector(PropertyReader.getProperty("errormessageLockedLocator"));
    private final By invalidUserOrPass = By.xpath(PropertyReader.getProperty("expectedmsgForInvalidusernameOrpasswordLocator"));
    private final By emptyUserOrPass = By.cssSelector(PropertyReader.getProperty("expectedmsgForEmptyusernameOrpasswordLocator"));
    //constructor
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementActions = new ElementActions(driver);
        softAssert = new SoftAssert();

    }

    //actions
    @Step("login with username and password")
    public LoginPage login(String username, String pass) {
        elementActions.MyType(userName, username);
        elementActions.MyType(password, pass);
        elementActions.myCLick(loginButton);
        return this;
    }

    public LoginPage validLogin()
    {
        login(PropertyReader.getProperty("validUsername"),
                PropertyReader.getProperty("validPassword"));
        return this;
    }

    //validations
    @Step("Validate that the user is logged-in")
    public HomePage isLoggedIn(String expectedUrl) {
        softAssert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        return new HomePage(driver);
    }

    @Step("Validate that the user is NOT logged in")
    public LoginPage isNotLoggedIn(String baseUrl) {
        softAssert.assertEquals(driver.getCurrentUrl(), baseUrl);
        return this;
    }


    @Step("Validate that password field is masked (password isnot visible)")
    public LoginPage verifyPasswordFieldMasked() {
        WebElement passwordField = driver.findElement(password);
        String fieldType = passwordField.getAttribute("type");
        if(!"password".equals(fieldType)) {
            throw new AssertionError("Password field is not masked! Actual type: " + fieldType);
        }
        return this;
    }

    @Step("Validate the displayed error message for the locked account")
    public LoginPage verifyErrorMessage(String expectedmsgForLockedAcc) {
        String actualMessage = elementActions.getText(lockedAccErrorMessage);
        softAssert.assertEquals(actualMessage, expectedmsgForLockedAcc);
        return this;
    }

    @Step("Validate the displayed error message for the invlaid username or password field")
    public LoginPage verifyUserOrPassErrorMsg(String expectedmsgForInvalidusernameOrpassword) {
        String actualMessage = elementActions.getText(invalidUserOrPass);
        softAssert.assertEquals(actualMessage, expectedmsgForInvalidusernameOrpassword);
        return this;
    }


    @Step("Validate the displayed error message for the empty username")
    public LoginPage verifyemptyUserErrorMsg(String expectedmsgForEmptyusername) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(invalidUserOrPass));

        String actualMessage = elementActions.getText(emptyUserOrPass);
        softAssert.assertEquals(actualMessage, expectedmsgForEmptyusername);
        return this;
    }


    @Step("Validate the displayed error message for the empty password")
    public LoginPage verifyemptyPassErrorMsg(String expectedmsgForEmptypassword) {
        String actualMessage = elementActions.getText(emptyUserOrPass);
        softAssert.assertEquals(actualMessage, expectedmsgForEmptypassword);
        return this;
    }


}