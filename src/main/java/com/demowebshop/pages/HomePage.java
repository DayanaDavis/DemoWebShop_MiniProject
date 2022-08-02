package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class HomePage extends ObjectUtility {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='ico-login']")
    WebElement loginMenu;
    @FindBy(xpath = "//a[@class='ico-register']")
    WebElement registerMenu;

    public String getHomePageTitle() {
        String title =page.getPageTitle(driver);
        return title;
    }
    public LoginPage clickOnLoginMenu(){
        page.clickOnElement(loginMenu);
        return new LoginPage(driver);
    }
    public RegisterPage clickOnRegisterMenu(){
    page.clickOnElement(registerMenu);
    return new RegisterPage(driver);
    }

}
