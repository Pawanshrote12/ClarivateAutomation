package steps;

import enums.BrowserType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.WebDriverManager;
import pages.GoogleSearchPage;
import pages.SearchResultsPage;

import static org.junit.Assert.assertEquals;

/**
 * This is a step definitions class for Browser Related Steps
 *
 * @author Amritansh Diwakar
 */

public class BrowserAutomationSteps extends BaseUtil {
    private final BaseUtil  base;

    public BrowserAutomationSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^I open Chrome Browser$")
    public void openChromeBrowser() {
        WebDriverManager webDriverManager = new WebDriverManager();
        base.webDriver = webDriverManager.initDriver(BrowserType.CHROME);
    }

    @When("^I navigate to google.com$")
    public void navigateToGoogleCom() {
        base.webDriver.get(configProp.getProperty("google_url"));
    }

    @And("^search for \"([^\"]*)\"$")
    public void searchFor(String searchQuery) {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(base.webDriver);
        googleSearchPage.searchForKeyword(searchQuery);
    }

    @Then("^first search result should be \"([^\"]*)\"$")
    public void veridyFirstSearchResult(String expectedURL) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(base.webDriver);
        assertEquals(searchResultsPage.getFirstSearchResult().getAttribute("href"), expectedURL);
    }
}