package MyActions;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Waits {
    private final WebDriver driver;

     public Waits(WebDriver driver)
    {
        this.driver=driver;
    }

   public FluentWait<WebDriver> myWait ()

    {
          return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(100))
                  .ignoreAll(getException());

    }
private ArrayList<Class <? extends Exception>> getException () {
    ArrayList<Class<? extends Exception>> except = new ArrayList<>();
    except.add(NoSuchElementException.class);
    except.add(StaleElementReferenceException.class);
    except.add(ElementNotInteractableException.class);
    except.add(ElementClickInterceptedException.class);
    return except;
}

}
