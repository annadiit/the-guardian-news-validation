package com.fakenewsdetector.actions;

import com.fakenewsdetector.helper.HelperClass;
import com.fakenewsdetector.locators.NewsFeedLocators;
import org.openqa.selenium.support.PageFactory;

public class NewsFeedActions {

    public NewsFeedLocators newsFeedLocators = null;

    public NewsFeedActions(){
        this.newsFeedLocators = new NewsFeedLocators();
        PageFactory.initElements(HelperClass.getDriver(), newsFeedLocators);
    }

}
