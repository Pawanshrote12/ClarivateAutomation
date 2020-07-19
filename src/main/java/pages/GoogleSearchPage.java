package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is a page class to locate elements and perform functions on Google Search HomePage
 *
 * @author Amritansh Diwakar
 */
public class GoogleSearchPage extends BaseSelenium{

    @FindBy(name = "q")
    WebElement txtSearchBox;

    /**
     * This  method is constructor used to initialize all the elements on Google Search home page
     * @param driver This is the Webdriver object
     */
    public GoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        assert isElementPresent(txtSearchBox);
    }

    /**
     * This method is used to search a keyword on Google Search page
     * @param keyword This is the String need to be searched
     */
    public void searchForKeyword(String keyword){
        submitText(txtSearchBox, keyword);
    }
}
