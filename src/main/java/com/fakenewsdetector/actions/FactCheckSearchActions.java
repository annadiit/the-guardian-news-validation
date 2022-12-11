package com.fakenewsdetector.actions;

import com.fakenewsdetector.helper.HelperClass;
import com.fakenewsdetector.locators.FactCheckSearchLocators;
import org.openqa.selenium.support.PageFactory;

public class FactCheckSearchActions {
    public FactCheckSearchLocators factCheckSearchLocators = null;

    public FactCheckSearchActions(){
        this.factCheckSearchLocators = new FactCheckSearchLocators();
        PageFactory.initElements(HelperClass.getDriver(), factCheckSearchLocators);
    }


    public String factCheckSearchResultsRating(){
        return factCheckSearchLocators.ratingLabel.get(0).getAttribute("outerText");
    }
}
