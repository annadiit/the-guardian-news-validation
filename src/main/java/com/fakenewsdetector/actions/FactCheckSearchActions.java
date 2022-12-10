package com.fakenewsdetector.actions;

import com.fakenewsdetector.helper.HelperClass;
import com.fakenewsdetector.locators.FactCheckSearchLocators;
import com.fakenewsdetector.locators.GoogleSearchLocators;
import org.openqa.selenium.support.PageFactory;

public class FactCheckSearchActions {
    public FactCheckSearchLocators factCheckSearchLocators = null;

    public FactCheckSearchActions(){
        this.factCheckSearchLocators = new FactCheckSearchLocators();
        PageFactory.initElements(HelperClass.getDriver(), factCheckSearchLocators);
    }

    public void factCheckSearchInput(String searchString){
        factCheckSearchLocators.searchField.sendKeys(searchString);
        factCheckSearchLocators.searchButton.click();
    }

    public String factCheckSearchResultsRating(){
      String rating = factCheckSearchLocators.ratingLabel.getAttribute("outerText");
      return rating;
    }
}
