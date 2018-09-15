package com.ess.qa.pages;

import com.ess.qa.base.TestBase;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.servlet.annotation.WebFilter;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class HomePage extends TestBase {

    @FindBy(xpath = "//*[@id=\"gts-bounce-nav\"]/div[1]/div[1]/a[1]")
    WebElement NewEmployeePortal;


    @FindBy(xpath = "//div[@class=\'ps-content\']/ul/li[9]")
    WebElement HelpDeskTab;


    @FindBy(xpath = "//ul[@class='dropdown-menu ng-star-inserted']/li[1]/a")
    WebElement WorkflowStatus;

    @FindBy(xpath = "//button[@class='btn btn-primary ng-star-inserted']")
    WebElement NewRequest;

    @FindBy(xpath = "//div[@class='select-box-container btn-group']/button/span")
    WebElement Category;

    @FindBy(xpath = "//ul[@class='dropdown-menu ng-star-inserted']/li[3]")
    WebElement SelectCategoy_IncomeTax;

    @FindBy(xpath = "//input[@id='subject']")
    WebElement subjecttextbox;

    @FindBy(xpath = "//textarea[@id='comment']")
    WebElement discriptiontextarea;


    @FindBy(xpath = "//div[@class='attachments']")
    WebElement attachment;

    @FindBy(xpath = "//button[contains(text(),'Submit')]")
    WebElement Submitbutton;

    @FindBy(xpath = "//section[@class=\'gt-workflow-header\'](//section[@class=\'gt-workflow-header\'])[last()]")
    WebElement listing;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public String ValidateWorkflowStatus() {

        String title = WorkflowStatus.getAttribute("title");
        return title;
    }

    //Ess switch Ess button
    public boolean ValidateSwithEssButton() {
        Boolean flag = NewEmployeePortal.isDisplayed();
        return flag;
    }

    //Ess switch Ess click
    public void ValidateSwitchEss() {
        NewEmployeePortal.click();
    }

    //clicking on the Helpdesk Tab
    public void HelpdeskTabClick() {
        HelpDeskTab.click();
    }

    //Clicking on the newRequest button in help desk
    public void ValidateNewRequest() throws InterruptedException {
        //NewRequest.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", NewRequest);

        WebElement category = driver.findElement(By.xpath("//gt-select-box[@id='category']/div/button"));
        js.executeScript("arguments[0].click()", category);

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu ng-star-inserted']/li/a"));

        for (WebElement elm : list) {
            System.out.println("values :" + elm.getAttribute("title"));


            if (elm.getAttribute("title").contains("New Agent login ID needs to create .")) {
                elm.click();

                break;
            }

        }


        Thread.sleep(5000);
        subjecttextbox.sendKeys("subject");
        discriptiontextarea.sendKeys("description");

        Submitbutton.click();


    }

    public void ValidateCategory() throws InterruptedException {
        Category.click();
        Thread.sleep(2000);

    }

    public void Validatelisting() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400000)");
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,400000)");
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,400000)");
        Thread.sleep(10000);
        js.executeScript("window.scrollBy(0,400000)");
        Thread.sleep(10000);

        List<WebElement> list1 = driver.findElements(By.xpath("//section[@class='gt-workflow-header']/div[1]"));
        System.out.println("Total listing in helpdesk is : "+list1.size());
        Thread.sleep(5000);

        for (WebElement elm1 : list1) {

            System.out.println(elm1.getText());

        }

    }


}
