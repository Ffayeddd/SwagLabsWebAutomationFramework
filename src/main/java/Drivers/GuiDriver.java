package Drivers;

import Readers.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class GuiDriver {


    private final  String browser = PropertyReader.getProperty("browserType");
    private  ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();



    public GuiDriver(){
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        AbstractDriver abstractDriver = browserType.getFactory();
        WebDriver driver = ThreadGuard.protect(abstractDriver.createDriver());
        driverThreadLocal.set(driver);
    }



    public  WebDriver get() {

        return driverThreadLocal.get();
    }

    public void quitDriver() {

        driverThreadLocal.get().quit();
    }

}






