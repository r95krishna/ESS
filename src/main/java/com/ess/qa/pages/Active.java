package com.ess.qa.pages;

import com.ess.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Active extends TestBase {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAhul Krishna\\IdeaProjects\\chromedriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("www.google.com");
    }


}
