package com.ess.qa.testCases;

import com.ess.qa.base.TestBase;
import com.ess.qa.pages.HomePage;
import com.ess.qa.pages.LoginPage;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    LoginPageTest loginPageTest;


    @BeforeMethod
    public void setup() {
        initialisation();
        loginPage = new LoginPage();
        homePage = new HomePage();
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }


    @Test(priority = 1)
    public void SwitchEssButtonTest() {

        //    loginPageTest.LoginTest();

        if (homePage.ValidateSwithEssButton()) {
            homePage.ValidateSwitchEss();
        } else {
            System.out.println("Allready in the new Ess Portal");
        }
    }

    @Test(priority = 2)
    public void WorkFlowStatusTest() throws InterruptedException {
        homePage.HelpdeskTabClick();
        driver.findElement(By.xpath("//span[@class='label-name ng-star-inserted']")).click();
        Thread.sleep(5000);
        String ws = homePage.ValidateWorkflowStatus();
        System.out.println(ws);
        Assert.assertEquals(ws, "ACTIVE");
    }

    @Test(priority = 3)
    public void ValidateNewRequestTest() throws InterruptedException {
        homePage.HelpdeskTabClick();
        Thread.sleep(5000);
        homePage.ValidateNewRequest();
        //  homePage.ValidateCategory();
    }

    @Test(priority = 4)
    public void ValidateNewRequest() throws InterruptedException {

        homePage.HelpdeskTabClick();
        Thread.sleep(5000);
        homePage.ValidateNewRequest();
    }

    @Test(priority = 5)
    public void ValidatelistingTest(){
        homePage.HelpdeskTabClick();
        homePage.Validatelisting();

    }
}