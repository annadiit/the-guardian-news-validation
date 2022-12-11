package com.fakenewsdetector.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FactCheckSearchLocators {


    @FindBy(className = "no-results-text")
    public WebElement noResultsText;

    @FindAll(@FindBy(xpath = "//*[@title='Publisher rating']"))
    public List<WebElement> ratingLabel;
}
