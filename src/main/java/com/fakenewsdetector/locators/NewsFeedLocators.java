package com.fakenewsdetector.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsFeedLocators {

    @FindBy(xpath = "//*[@id=\"notice\"]/div[3]/div/div/button[1]")
    public WebElement iAmHappy;

    @FindBy(xpath = "/html/body/div[10]//div/div/div/section/div/div[2]/div/div[3]/div/div[1]/div[2]/button")
    public WebElement closeSupportBanner;

    @FindBy(xpath = "//*[@id=\"top\"]/div[3]/div/section[1]/div/div/div[1]/ul/li[1]/div/div/a")
    public WebElement firstArticle;

}
