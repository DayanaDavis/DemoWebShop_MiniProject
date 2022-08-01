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
    @Test(dataProvider ="readHomePageTitle" )
    public void verifyHomePageTitle(String expTitle){
        home=new HomePage(driver);
        String expectedTitle=expTitle;
        String actualTitle=home.getHomePageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Error: Invalid Home Page Title");
    }
    @DataProvider(name = "readHomePageTitle")
    public Object[][] homePageData() throws IOException {
        String filepath = System.getProperty("user.dir") + "\\src\\main\\resources\\testData.xlsx";
        excelUtility=new ExcelUtility();
        Object[][] data=excelUtility.readDataFromExcel(filepath,"HomePage");
        return data;
    }
}
