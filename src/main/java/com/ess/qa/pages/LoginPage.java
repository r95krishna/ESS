package com.ess.qa.pages;

import com.ess.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {


    //page Factory
    @FindBy(id="j_username")
    WebElement username;

    @FindBy(id="j_password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement loginButton;



//    @FindBy(xpath="//img[contains(@class,'')]")

    //inittalizing the page objects
    public LoginPage(){

        PageFactory.initElements(driver,this);
    }


    public String ValidateLoginPageTitle(){
        return driver.getTitle();
    }



    public  HomePage login(String username, String password)
    {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();

        return new HomePage();
    }

}
