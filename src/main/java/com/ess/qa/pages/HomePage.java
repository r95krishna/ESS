package com.ess.qa.pages;

import com.ess.qa.base.TestBase;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends TestBase {

    @FindBy(xpath="//*[@id=\"gts-bounce-nav\"]/div[1]/div[1]/a[1]")
    WebElement NewEmployeePortal;

    @FindBy(xpath = "//div[@class=\'ps-content\']/ul/li[9]")
    WebElement HelpDeskTab;



    @FindBy(xpath = "//ul[@class='dropdown-menu ng-star-inserted']/li[1]/a")
    WebElement WorkflowStatus;


    @FindBy(xpath = "//section[@class='helpdesk-review-actions']/div[4]/button")
    WebElement NewRequest;


    public HomePage(){

        PageFactory.initElements(driver,this);
    }

    public void ValidateNewRequest(){
        NewRequest.click();
    }



    public String ValidateWorkflowStatus(){

       String title=WorkflowStatus.getAttribute("title");
        return title;
    }


    //Ess switch Ess button
    public boolean ValidateSwithEssButton(){
        Boolean flag=NewEmployeePortal.isDisplayed();
        return flag;
    }

    //Ess switch Ess click
    public void ValidateSwitchEss(){
        NewEmployeePortal.click();
    }

    public void HelpdeskTabClick(){

        HelpDeskTab.click();
    }


}
