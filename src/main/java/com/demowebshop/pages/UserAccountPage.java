package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountPage extends ObjectUtility {
    public WebDriver driver;

    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='header-links']//a[@class='account']")
    WebElement accountName;

    public String getUserEmailId(){
        String text= page.getElementText(accountName);
        return text;

    }

}
