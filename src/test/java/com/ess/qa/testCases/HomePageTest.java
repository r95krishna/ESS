package com.ess.qa.testCases;

import com.ess.qa.base.TestBase;
import com.ess.qa.pages.HomePage;
import com.ess.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

        LoginPage loginPage;
        HomePage homePage;

    @BeforeMethod
    public void setup(){
        initialisation();
        loginPage=new LoginPage();
        homePage=new HomePage();
    }


    @Test(priority = 1)

    public void SwitchEssButtonTest() {

       loginPage.login(prop.getProperty("username"),prop.getProperty("password"));

       if (homePage.ValidateSwithEssButton()) {

           homePage.ValidateSwitchEss();

        }
        else {

           System.out.println("Allready in the new Ess Portal");
        }
    }



    @Test(priority = 2)
    public void WorkFlowStatusTest(){

        String ws=homePage.ValidateWorkflowStatus();

        if(ws.equalsIgnoreCase("Active")){



        }
    }






    @AfterMethod

    public void TearDown(){
        driver.quit();
    }
}
