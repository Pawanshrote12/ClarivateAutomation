package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks extends BaseUtil {
    Process pr;
    private final BaseUtil base;

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @After("@BrowserAutomation")
    public void quitBrowserDriver() {
        base.webDriver.quit();
        System.out.println("Quiting Browser Driver");
    }

    @Before("@DesktopAutomation")
    public void startWiniumDriver() throws IOException {
        Runtime rt = Runtime.getRuntime();
        // Executing the Winium.Desktop.Driver.exe file
        pr = rt.exec(configProp.getProperty("drivers_path").concat("Winium.Desktop.Driver.exe"));
    }

    @After("@DesktopAutomation")
    public void quitWiniumDriver() {
        // Destroying the Winium.Desktop.Driver.exe execution process
        pr.destroy();
        System.out.println("Quitting Winium Driver");
    }
}
