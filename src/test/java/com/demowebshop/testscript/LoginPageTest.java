package com.demowebshop.testscript;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.UserAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends Base {
    HomePage home;
    LoginPage login;
    UserAccountPage account;
    ExcelUtility excel;

    @Test
    public void verifyValidLogin() {
        home = new HomePage(driver);
        excel=new ExcelUtility();
        login = home.clickOnLoginMenu();
        String username= null;
        try {
            username = excel.readSingleData(1,0,"LoginPage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String password= null;
        try {
            password = excel.readSingleData(1,1,"LoginPage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        login.enterUserName(username);
        login.enterPassword(password);
        account = login.clickOnLoginButton();
        String actual_AccountName = account.getUserEmailId();
        Assert.assertEquals(actual_AccountName, username, "Error: UserLogin Failed");
    }
    @DataProvider(name="verifyValidLogin_multipleUser")
    public Object[][] getDataForValidLogin() throws IOException {
        excel=new ExcelUtility();
        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\testData.xlsx";
        Object[][] data= excel.readDataFromExcel(filepath,"LoginPage");
        return data;
    }
}
