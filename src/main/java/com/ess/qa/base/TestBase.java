package com.ess.qa.base;

import com.ess.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public   static WebDriver driver;
    public   static Properties prop;


    public TestBase(){

            try{
                  prop=new Properties();
                  FileInputStream fi= new FileInputStream("C:\\Users\\Rahul Krishna\\IdeaProjects\\ESS\\src\\main\\java\\com\\ess\\qa\\config\\config.properties");
                  prop.load(fi);
            }

            catch (FileNotFoundException e) {
                  e.printStackTrace();
            }


            catch (IOException e){
                  e.printStackTrace();

            }


      }


      public void initialisation(){


         String BrowserName =prop.getProperty("browser");
          System.out.println(BrowserName);

         if(BrowserName.equals("chrome")){

             System.setProperty("webdriver.chrome.driver", "C://Users//Rahul Krishna//IdeaProjects//ESS//chromedriver//chromedriver.exe");
             driver=new ChromeDriver();
         }

         /*else if(BrowserName.equals("FF")){
               System.setProperty("webdriver.gecko.driver","C:\\Users\\RAhul Krishna\\IdeaProjects\\gecko");
               WebDriver driver=new FirefoxDriver();
         }*/


          driver.manage().window().maximize();
          driver.manage().deleteAllCookies();
          driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_time,TimeUnit.SECONDS);
          driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait,TimeUnit.SECONDS);

          driver.get(prop.getProperty("url"));

      }

}
