package desktop.applications;
import enums.CalciKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * This is a class to handle Windows 7 calculator app
 *
 * @author Amritansh Diwakar
 */

public class Win7Calculator {
    private final WiniumDriver winiumDriver;

    public Win7Calculator(WiniumDriver winiumDriver) {
        this.winiumDriver = winiumDriver;
    }

    /**
     * This method is used to press any key on Win 7 calculator.
     * @param calciKey This is the enum Calcikeys need to be pressed by mapping the enum to automation_id
     */
    public void pressButton(CalciKeys calciKey) {
            this.winiumDriver.findElement(By.id(String.valueOf(calciKey))).click();
            System.out.println("Pressed Button :" + String.valueOf(calciKey));
    }

    /**
     * This method is used to input a number as a whole to display on calculator screen
     * and perform any operation on it.
     * @param number This is the integer value needed to be input onto calculator screen
     */
    public void inputNumber(int number) {
        for (char ch : String.valueOf(number).toCharArray()) {
            pressButton(CalciKeys.valueOf("NUM" + ch));
        }
    }

    /**
     * This method is used to fetch the currently displayed number from calculator screen
     * @return This returns a double representing the currently displayed number on calculator screen
     */
    public double getResult() {
        String displayedResult = winiumDriver.findElement(By.id("CalculatorResults")).getAttribute("name");
        return Double.parseDouble(displayedResult.split("Display is ")[1]);
    }
}
