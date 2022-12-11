package com.fakenewsdetector.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsFeedLocators {

    @FindBy(xpath = "//*[@id=\"top\"]/div[3]/div/section[1]/div/div/div[1]/ul/li[1]/div/div/a")
    public WebElement firstArticle;
}
