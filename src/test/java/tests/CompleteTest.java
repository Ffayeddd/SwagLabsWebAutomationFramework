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
import pages.OverViewPage;

import static Readers.PropertyReader.getProperty;

public class CompleteTest {
    private WebDriver driver;
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
    @Description("validating that all details of complete page appears  ")
    @Tag("validScenario")
    @Severity(SeverityLevel.NORMAL)
    public  void C_TC_01()
    {  new OverViewPage(driver)
            .validScenario()
            .completeAssertion();

    }
    @Test
    @Description("validating the functionality of backhome button ")
    @Tag("validScenario")
    @Severity(SeverityLevel.NORMAL)
    public  void C_TC_02()
    {  new OverViewPage(driver)
            .validScenario()
            .backHomeClick()
            .backHomeValidation();

    }

   /* @Test
    public  void C_TC_()
    {  new LoginPage(driver)
            .validLogin()
            .isLoggedIn(PropertyReader.getProperty("expectedUrl"))
            .addBackbagToCart()
            .cartClick();
        System.out.println(driver.findElement(By.cssSelector("[data-test=\"inventory-item-desc\"]")).getText());

    }*/
}
