package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ObjectUtility {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "Email")
    WebElement userName;
    @FindBy(id = "Password")
    WebElement passWord;
    @FindBy(xpath = "//input[@class='button-1 login-button']")
    WebElement loginButton;

    public void enterUserName(String uName){
        page.enterText(userName,uName);
    }
    public void enterPassword(String pass){
        page.enterText(passWord,pass);
    }
    public UserAccountPage clickOnLoginButton(){
        page.clickOnElement(loginButton);
        return new UserAccountPage(driver);
    }


}
