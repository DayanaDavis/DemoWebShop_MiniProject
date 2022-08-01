package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class HomePage extends ObjectUtility {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHomePageTitle() {
        String title =page.getPageTitle(driver);
        return title;
    }

}
