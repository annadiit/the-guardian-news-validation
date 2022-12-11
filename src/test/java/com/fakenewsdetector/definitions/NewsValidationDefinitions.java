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
import java.util.HashSet;
import java.util.Set;

public class NewsValidationDefinitions {

    private static final String GOOGLE_URL_PREFIX = "https://www.google.com/search?q=";
    private static final String FACT_CHECK_URL_PREFIX = "https://toolbox.google.com/factcheck/explorer/search/";

    NewsFeedActions newsFeedActions = new NewsFeedActions();
    GoogleSearchActions googleSearchActions = new GoogleSearchActions();
    FactCheckSearchActions factCheckSearchActions = new FactCheckSearchActions();


    public HashSet<String> validSources = new HashSet<>();
    public HashSet<String> satireSources = new HashSet<>();

    @Given("User is on {string}")
    public void goToNewsFeed(String url) {
        HelperClass.openPage(url);

        validSources.add("https://www.bbc.co.uk");
        validSources.add("https://www.forbes.com");
        validSources.add("https://www.reuters.com");
        validSources.add("https://www.wsj.com");
        validSources.add("https://www.independent.co.uk");
        validSources.add("https://www.standard.co.uk");
        validSources.add("https://www.telegraph.co.uk");

        satireSources.add("https://www.thedailymash.co.uk");
        satireSources.add("https://www.theonion.com");
        satireSources.add("https://www.dailysquib.co.uk");
        satireSources.add("https://thedailywtf.com");
        satireSources.add("https://thelemonpress.co.uk");
        satireSources.add("https://www.newsbiscuit.com");
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

    @Then("results contain 0 claims")
    public void resultsDoNotContainPublisherRatingFalse() {
        String resultDidntMatchAnyClaims = "did not match any claims.";
        String noResultsText = factCheckSearchActions.factCheckSearchLocators.noResultsText.getText();
        //checking there is 0 claims
        Assert.assertTrue(noResultsText.contains(resultDidntMatchAnyClaims));
    }

    @When("User searches the fake article titled {string} on Fact Check source")
    public void userSearchesTheFakeArticleTitledOnFactCheckSource(String fakeArticleTitle) {
        HelperClass.openPage(FACT_CHECK_URL_PREFIX + fakeArticleTitle);
    }

    @Then("results contain Publisher rating not True")
    public void resultsContainPublisherRatingNotTrue() {
        String rating = factCheckSearchActions.factCheckSearchResultsRating();
        // For test verification it's assumed confirmed facts are rated as "True". example: "True", "Mostly True"
        Assert.assertFalse(rating.contains("True"));
    }

    public Integer countSearchResultsInASet(Set<String> urlsToLookFor){

        int count = 0;
        for (int i = 0; i < googleSearchActions.googleSearchLocators.results.size(); i++) {

            String resultsURL = googleSearchActions.googleSearchLocators.results.get(i).getAttribute("innerText").split(" ")[0];
            if (urlsToLookFor.contains(resultsURL)) {
                count++;
            }
        }
        return count;
    }

    @Then("results contain trusted sources")
    public void resultsContainTrustedSources() {

        int count= countSearchResultsInASet(validSources);
        Assert.assertTrue("Valid Source has not found", count > 0);

    }

    @Then("results do not contain satire sources")
    public void resultsDoNotContainSatireSources() {

        int count= countSearchResultsInASet(satireSources);
        Assert.assertEquals("Satire sources are found for this article", 0, count);

    }
}



