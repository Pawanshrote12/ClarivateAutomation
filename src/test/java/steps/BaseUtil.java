package steps;

import dataProviders.PropertyFileReader;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * This is a base util class used only for dependency injection using pico-container
 *
 * @author Amritansh Diwakar
 */

public class BaseUtil {
    public WebDriver webDriver;
    Properties configProp;

    public BaseUtil() {
        this.configProp = new PropertyFileReader("config.properties").getProperties();
    }
}
