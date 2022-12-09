package com.fakenewsdetector.definitions;

import com.fakenewsdetector.actions.FactCheckSearchActions;
import com.fakenewsdetector.actions.GoogleSearchActions;
import com.fakenewsdetector.actions.NewsFeedActions;
import com.fakenewsdetector.helper.HelperClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsValidationDefinitions {

    private static final String GOOGLE_URL_PREFIX = "https://www.google.com/search?q=";
    private static final String FACT_CHECK_URL_PREFIX = "https://toolbox.google.com/factcheck/explorer/search/";

    NewsFeedActions newsFeedActions = new NewsFeedActions();
    GoogleSearchActions googleSearchActions = new GoogleSearchActions();
    FactCheckSearchActions factCheckSearchActions = new FactCheckSearchActions();

    @Given("User is on {string}")
    public void goToNewsFeed(String url){
        HelperClass.openPage(url);
    }

    private void clickIAmHappy() {
        WebDriver wd = HelperClass.getDriver();
        WebElement iframe = wd.findElement(By.xpath("//iframe[@id='sp_message_iframe_744206']"));
        wd.switchTo().frame(iframe);
        newsFeedActions.clickYesIAmHappyButton();
    }

    @And("user clicks on \"I am Happy\" button")
    public void userClicksOnButton() {
//        clickIAmHappy();
    }

    @When("user searches the first article in Google")
    public void userSearchesArticleIn() {
        String currentTitle = newsFeedActions.newsFeedLocators.firstArticle.getAttribute("innerHTML");
        System.out.println(currentTitle);
        HelperClass.openPage(GOOGLE_URL_PREFIX + currentTitle);
    }

    @Then("more than {int} sources are displayed")
    public void moreThanSourcesAreDisplayed(int amount) {
      String results = googleSearchActions.googleSearchLocators.resultStats.getText();
      Assert.assertTrue(googleSearchActions.googleResultsAmount(results) > amount);
    }

    @When("user searches the first article in Fact Check")
    public void userSearchesTheFirstArticleInFactCheck() {
        String currentTitle = newsFeedActions.newsFeedLocators.firstArticle.getAttribute("innerHTML");
        HelperClass.openPage(FACT_CHECK_URL_PREFIX + currentTitle);
    }

    @Then("results do not contain Publisher rating False")
    public void resultsDoNotContainPublisherRatingFalse() {
        String resultDidntMatchAnyClaims = "did not match any claims.";
        String noResultsText = factCheckSearchActions.factCheckSearchLocators.noResultsText.getText();
        Assert.assertTrue(noResultsText.contains(resultDidntMatchAnyClaims));
    }
}
