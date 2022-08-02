package com.demowebshop.testscript;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.FakerUtility;
import com.demowebshop.utilities.RandomUtility;
import org.testng.Assert;
import org.testng.annotations.Test;
public class RegisterPageTest extends Base {
HomePage home;
RegisterPage register;
UserAccountPage account;
RandomUtility random;
FakerUtility fakerUtility;
    @Test
    public void verifyUserRegistration(){
        home=new HomePage(driver);
        register= home.clickOnRegisterMenu();
        random=new RandomUtility();
        fakerUtility =new FakerUtility();
        String gender="female";
        String fName= fakerUtility.firstName();
        String lName=fakerUtility.lastName();
        String email=fakerUtility.eMail();
        System.out.println(email);
        String pass="12345678";
        register.selectGender(gender);
        register.enterFirstName(fName);
        register.enterLastName(lName);
        register.enterEmail(email);
        register.enterPassword(pass);
        register.enterConfirmPassword(pass);
        account=register.clickOnRegisterButton();
        String actual_uname=account.getUserEmailId();
        System.out.println(actual_uname);
        Assert.assertEquals(actual_uname,email,"Error: Invalid Registration");
    }
}
