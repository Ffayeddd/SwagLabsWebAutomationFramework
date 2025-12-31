package MyActions;

import Logs.Logutiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static java.awt.SystemColor.text;

public class ElementActions {
private WebDriver driver ;
private Waits wait ;

    public ElementActions(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new Waits(driver);
    }



    public void myCLick(By Locator)
    {
        Waits wait =new Waits (driver);
        wait.myWait().until(d->
        {
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(d.findElement(Locator)).perform();
                d.findElement(Locator).click();
                Logutiles.info("Clicked on element: " + Locator.toString());
                return true;
            }
            catch (Exception e)
            {
                return false ;
            }
        });

    }

    public void MyType(By locator, String text)
    {
        Waits waits =new Waits (driver);
        waits.myWait().until(d->
        {
            try {
                Actions actions = new Actions(driver);
                actions.moveToElement(d.findElement(locator)).perform();
                d.findElement(locator).clear();
                d.findElement(locator).sendKeys(text);
                Logutiles.info("Typed text '" + text + "' into element: " + locator.toString());
                return true;
            }
            catch (Exception e)
            {
                return false ;
            }
        });

    }

    public String getText(By locator) {
        Waits waits = new Waits(driver);
        return waits.myWait().until(d -> {
            try {

                var element = d.findElement(locator);
                Actions actions = new Actions(driver);
                actions.moveToElement(element).perform();

                // Scroll to element if needed (useful if not visible)
                new Actions(driver).scrollToElement(element).perform();

                // Get visible text
                String msg = element.getText().trim();

                if (!msg.isEmpty()) {
                    Logutiles.info("Fetched text: '" + msg + "' from element: " + locator.toString());
                    return msg;
                } else {
                    Logutiles.warn("Element found but text is empty: " + locator.toString());
                    return null;
                }
            } catch (Exception e) {
                Logutiles.error("Failed to get text from element: " + locator.toString() + " | " + e.getMessage());
                return null;
            }
        });
    }



}
