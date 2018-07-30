package com.ess.qa.testCases;

import com.ess.qa.base.TestBase;
import com.ess.qa.pages.HomePage;
import com.ess.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage Homepage;
    public LoginPageTest(){
        super();
    }


    @BeforeMethod
    public void setup(){
        initialisation();
       loginPage=new LoginPage();
    }

    @Test(priority = 1)
    public void LoginPageTitleTest(){

        String title=loginPage.ValidateLoginPageTitle();
        Assert.assertEquals(title,"greytHR Login");

    }

    @Test(priority = 2)
    public void LoginTest()
    {
        Homepage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }



    @AfterMethod
    public void TearDown(){
        driver.quit();
    }


}
