package com.demowebshop.testscript;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends Base {
    HomePage home;
    ExcelUtility excelUtility;
    @Test
    public void verifyHomePageTitle() throws IOException {
        home=new HomePage(driver);
        excelUtility=new ExcelUtility();
        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\testData.xlsx";
        String expectedTitle=excelUtility.readSingleData(1,0,filepath,"HomePage");
        String actualTitle=home.getHomePageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Error: Invalid Home Page Title");
    }
}
