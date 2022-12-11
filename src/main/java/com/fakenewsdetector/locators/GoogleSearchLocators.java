package com.fakenewsdetector.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class GoogleSearchLocators {

    @FindBy(id = "result-stats")
    public WebElement resultStats;

    @FindAll(@FindBy(xpath = "//*[@class='yuRUbf']//a/div/cite"))
    public List <WebElement> results;


}
