package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 * This is a base class to handle repeatable functionalities related to Selenium
 *
 * @author Amritansh Diwakar
 */

public class BaseSelenium {
    /**
     * This  method is used to enter a text ad submit form using Enter key
     * @param webElement This is the WebElement on which text needed to be entered.
     * @param charSeq This is the String needed to be entered
     */
    public void submitText(WebElement webElement, String charSeq){
        webElement.clear();
        webElement.sendKeys(charSeq);
        webElement.sendKeys(Keys.ENTER);
    }

    /**
     * This  method is used to check if an element is displayed on the page
     * @param webElement This is the WebElement for which the display condition is verified.
     * @return boolean True if element is displayed else false
     */
    public boolean isElementPresent(WebElement webElement) {
        return webElement.isDisplayed();
    }


}
