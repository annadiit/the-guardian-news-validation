package com.fakenewsdetector.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FactCheckSearchLocators {

    @FindBy(xpath = "/html/body/fact-check-tools/div/div[2]/fc-landing-page/div/div/fc-search-input/div/form")
    public WebElement searchField;

    @FindBy(xpath = "/html/body/fact-check-tools/div/div[2]/search-results-page/div/fc-search-input/div/form/label/button/span[1]")
    public WebElement searchButton;

    @FindBy(xpath = "/html/body/fact-check-tools/div/div[2]/search-results-page/div/div[6]/div/div/p[1]")
    public WebElement noResultsText;
}
