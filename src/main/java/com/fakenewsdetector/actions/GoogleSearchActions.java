package com.fakenewsdetector.actions;

import com.fakenewsdetector.helper.HelperClass;
import com.fakenewsdetector.locators.GoogleSearchLocators;
import com.fakenewsdetector.locators.NewsFeedLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashSet;
import java.util.List;


public class GoogleSearchActions {

    public GoogleSearchLocators googleSearchLocators = null;

    public GoogleSearchActions(){
        this.googleSearchLocators = new GoogleSearchLocators();
        PageFactory.initElements(HelperClass.getDriver(), googleSearchLocators);
    }


    public int googleResultsAmount(String s) {
        String firstNumber = s.substring(s.indexOf(' ')+1, s.indexOf(' ', s.indexOf(' ')+1)).trim();
        String resultNumber = firstNumber.replace(",", "");
        System.out.println(resultNumber);
        return Integer.parseInt(resultNumber);
    }
}
