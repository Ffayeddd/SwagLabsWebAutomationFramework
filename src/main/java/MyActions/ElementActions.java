package MyActions;

import Logs.LogUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {
private final WebDriver driver ;
private Waits wait ;

    public ElementActions(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new Waits(driver);
    }



    public ElementActions myCLick(By Locator)
    {
        wait.myWait().until(d->
        {
            try {
                WebElement element = d.findElement(Locator);
                new Actions(d).scrollToElement(element);
                element.click();
                LogUtils.info("Clicked on element: " + Locator.toString());
                return true;
            }
            catch (Exception e)
            {
                return false ;
            }
        });
        return this ;

    }

    public ElementActions MyType(By locator, String text)
    {
        wait.myWait().until(d->
        {
            try {
                WebElement element = d.findElement(locator);
                new Actions(d).scrollToElement(element);
                element.clear();
                element.sendKeys(text);
                LogUtils.info("Typed text '" + text + "' into element: " + locator.toString());
                return true;
            }
            catch (Exception e)
            {
                return false ;
            }
        });
   return this ;
    }

    public String getText(By locator) {

        return wait.myWait().until(d -> {
            try {

                WebElement element = d.findElement(locator);
                new Actions(d).scrollToElement(element);
                String msg = element.getText();

                if (!msg.isEmpty()) {
                    LogUtils.info("Fetched text: '" + msg + "' from element: " + locator.toString());
                    return msg;
                } else {
                    LogUtils.warn("Element found but text is empty: " + locator.toString());
                    return null;
                }
            } catch (Exception e) {
                LogUtils.error("Failed to get text from element: " + locator.toString() + " | " + e.getMessage());
                return null;
            }
        });
    }
    public WebElement findElement(By locator) {

        return wait.myWait().until(d -> {
            try {

                WebElement element = d.findElement(locator);
                new Actions(d).scrollToElement(element);

                    LogUtils.info("Found Element: " + locator.toString());
                    return element;

            } catch (Exception e) {
                LogUtils.error("Failed to find element: " + locator.toString());
                return null;
            }
        });
    }
    public ElementActions Dropdown(By locator, int index) {
         wait.myWait().until(d ->
                {
                    try {
                        WebElement element = d.findElement(locator);
                        new Actions(d).scrollToElement(element);
                        Select select = new Select(element);
                        select.selectByIndex(index);
                        LogUtils.info("Selected index" + index );
                        return true;
                    } catch (Exception e) {
                        LogUtils.error("Failed to select from dropdown: " + index );
                        return false;
                    }
                }
        );
        return this;
    }








}
