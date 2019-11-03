package com.training1.testcases;
import java.sql.SQLException;

import com.training1.constants.CommonVar;
import com.training1.reports.ReportClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
public class BaseCase extends ReportClass {

    public static WebDriver driver;

    /*
 Below method will execute before each testcase.
     */
    @BeforeMethod
    public void initialize() throws SQLException
    {
        System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"chromedriver");
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe" );
        driver = new ChromeDriver();
        //driver.get("http://toolsqa.com/automation-practice-form/");
        //driver.get("http://toolsqa.com/automation-practice-table/");
        //driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
        CommonVar common = new CommonVar();
        driver.get(common.url);
        driver.manage().window().maximize();
    }


    /*
 Below method will execute after each testcase.
     */
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}

