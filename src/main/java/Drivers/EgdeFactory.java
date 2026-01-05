package Drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;


public class EgdeFactory extends AbstractDriver{

    private EdgeOptions getOptions()
    {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        return options ;
    }
    @Override
    public WebDriver createDriver() {
        return new EdgeDriver(getOptions());
    }
}
