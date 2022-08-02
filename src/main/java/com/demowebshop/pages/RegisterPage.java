package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends ObjectUtility {
    public WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "gender-male")
    WebElement male;
    @FindBy(id = "gender-female")
    WebElement female;
    @FindBy(id = "FirstName")
    WebElement firstName;
    @FindBy(id = "LastName")
    WebElement lastName;
    @FindBy(id ="Email")
    WebElement email;
    @FindBy(id="Password")
    WebElement passWord;
    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;
    @FindBy(id = "register-button")
    WebElement registerButton;

    public void selectGender(String gender){
    if(gender.equalsIgnoreCase("male")){
        page.clickOnElement(male);
    }
    else {
        page.clickOnElement(female);
    }
    }
    public void enterFirstName(String fname){
    page.enterText(firstName,fname);
    }
    public void enterLastName(String lname){
    page.enterText(lastName,lname);
    }
    public void enterEmail(String emailid){
    page.enterText(email,emailid);
    }
    public void enterPassword(String pass){
    page.enterText(passWord,pass);
    }
    public void enterConfirmPassword(String pass){
    page.enterText(confirmPassword,pass);
    }
    public UserAccountPage clickOnRegisterButton(){
        page.clickOnElement(registerButton);
        return new UserAccountPage(driver);
    }
}
