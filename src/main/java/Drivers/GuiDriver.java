package Drivers;

import Readers.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GuiDriver {


    private final static String browser = PropertyReader.getProperty("browserType");
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();



    public GuiDriver(){
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        AbstractDriver abstractDriver = browserType.getFactory();
        WebDriver driver = ThreadGuard.protect(abstractDriver.createDriver());
        driverThreadLocal.set(driver);
    }



    public static WebDriver get() {

        return driverThreadLocal.get();
    }

    public static void quitDriver() {

        driverThreadLocal.get().quit();
    }

}






