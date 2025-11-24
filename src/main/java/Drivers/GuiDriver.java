package Drivers;

import Readers.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GuiDriver {


    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static final  String browser = PropertyReader.getProperty("browserType");


    public static WebDriver initDriver() {
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        AbstractDriver abstractDriver = browserType.getFactory();
        WebDriver driver = ThreadGuard.protect(abstractDriver.createDriver());
        driverThreadLocal.set(driver);
        return driver;
    }


    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }

}






