package Drivers;

import Readers.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GuiDriver {

    private static final String browser = PropertyReader.getProperty("browserType");

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    public static WebDriver getDriver() {
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        AbstractDriver abstractDriver = browserType.getFactory();
        return abstractDriver.createDriver();
    }

    public static WebDriver initDriver() {
        WebDriver driver = ThreadGuard.protect(getDriver());
        driverThreadLocal.set(driver);
        return driverThreadLocal.get();
    }
    public static WebDriver get() {
        return driverThreadLocal.get();
    }
    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }

}






