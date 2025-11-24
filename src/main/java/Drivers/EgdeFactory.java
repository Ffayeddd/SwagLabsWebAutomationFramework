package Drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class EgdeFactory extends AbstractDriver{

    public EdgeOptions getoption()
    {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        return options ;
    }
    @Override
    public WebDriver createDriver() {
        return new EdgeDriver(getoption());
    }
}
