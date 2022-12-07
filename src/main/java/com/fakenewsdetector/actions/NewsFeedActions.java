package com.fakenewsdetector.actions;

import com.fakenewsdetector.helper.HelperClass;
import com.fakenewsdetector.locators.NewsFeedLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewsFeedActions {

    public NewsFeedLocators newsFeedLocators = null;

    public NewsFeedActions(){
        this.newsFeedLocators = new NewsFeedLocators();
        PageFactory.initElements(HelperClass.getDriver(), newsFeedLocators);
    }

    public void clickYesIAmHappyButton(){
        newsFeedLocators.iAmHappy.click();
    }

}
