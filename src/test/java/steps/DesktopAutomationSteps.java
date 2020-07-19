package steps;

import desktop.applications.Win7Calculator;
import enums.CalciKeys;
import enums.DesktopApps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.WiniumDriverManager;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

/**
 * This is a step definitions class for Desktop App Related Steps for Win 7 Calculator
 *
 * @author Amritansh Diwakar
 */

public class DesktopAutomationSteps{
    private int inputNumber;
    private Win7Calculator win7Calculator;

    @Given("^I open Windows Calculator Application$")
    public void openWindowsCalculatorApplication() throws MalformedURLException {
        WiniumDriverManager winiumDriverManager = new WiniumDriverManager();
        WiniumDriver winiumDriver = winiumDriverManager.initDriver(DesktopApps.CALCULATOR,"http://localhost:9999");
        win7Calculator = new Win7Calculator(winiumDriver);
    }

    @When("^I enter number \"([^\"]*)\"$")
    public void enterValue(int number) {
        inputNumber = number;
        win7Calculator.inputNumber(inputNumber);
    }

    @Then("^the calculate result should be correct$")
    public void clickOnSquareRootButton() {
        win7Calculator.pressButton(CalciKeys.SQUAREROOT);
    }

    @And("^click on square root button$")
    public void verifyCalulatorResult() {
        double actual = win7Calculator.getResult();
        double expected = Math.sqrt(inputNumber);
        assertEquals(actual,expected,0.001);
    }
}

