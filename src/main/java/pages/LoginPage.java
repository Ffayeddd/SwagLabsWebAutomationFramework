package pages;
import MyActions.ElementActions;
import Readers.PropertyReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;



public class LoginPage {

    //variable
    private final WebDriver driver;
    private final ElementActions elementActions;



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


    }

    //actions
    @Step("login with username and password")
    public LoginPage login(String username, String pass) {
        elementActions.MyType(userName, username);
        elementActions.MyType(password, pass);
        elementActions.myCLick(loginButton);
        return this;
    }

    @Step("login with valid username and password")
    public LoginPage validLogin()
    {
        login(PropertyReader.getProperty("validUsername"),
                PropertyReader.getProperty("validPassword"));
        return this;
    }

    //validations
    @Step("Validate that the user is logged in")
    public HomePage isLoggedIn(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl,"User is not logged in with valid credentials");
        return new HomePage(driver);
    }

    @Step("Validate that the user is NOT logged in")
    public LoginPage isNotLoggedIn(String baseUrl) {
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl,"User is logged in with invalid credentials");
        return this;
    }


    @Step("Validate the displayed error message for the locked account")
    public LoginPage verifyErrorMessage(String expectedmsgForLockedAcc) {
        String actualMessage = elementActions.getText(lockedAccErrorMessage);
        Assert.assertEquals(actualMessage, expectedmsgForLockedAcc,"Locked account error message is not as expected");
        return this;
    }

    @Step("Validate the displayed error message for the invalid username or password field")
    public LoginPage verifyUserOrPassErrorMsg(String expectedmsgForInvalidusernameOrpassword) {
        String actualMessage = elementActions.getText(invalidUserOrPass);
        Assert.assertEquals(actualMessage, expectedmsgForInvalidusernameOrpassword,"error message is not as expected");
        return this;
    }


    @Step("Validate the displayed error message for the empty username")
    public LoginPage verifyemptyUserErrorMsg(String expectedmsgForEmptyusername) {

        String actualMessage = elementActions.getText(emptyUserOrPass);
        Assert.assertEquals(actualMessage, expectedmsgForEmptyusername,"error message is not as expected");
        return this;
    }


    @Step("Validate the displayed error message for the empty password")
    public LoginPage verifyemptyPassErrorMsg(String expectedmsgForEmptypassword) {
        String actualMessage = elementActions.getText(emptyUserOrPass);
        Assert.assertEquals(actualMessage, expectedmsgForEmptypassword,"error message is not as expected");
        return this;
    }


}