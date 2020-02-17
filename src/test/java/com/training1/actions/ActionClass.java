package com.training1.actions;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

public class ActionClass {
    public static WebDriver driver;
    public static ExtentTest test;

    public ActionClass(WebDriver driver, ExtentTest test)
    {
        this.driver=driver;
        this.test=test;
    }

    public void clickOnObject(WebElement element)
    {
        try {
            if(element.isDisplayed())
            {
                element.click();
                test.log(Status.INFO,"Sucessfully clicked on object : ");
                System.out.println("Sucessfully clicked on object : ");
            }
            else
            {
                System.out.println("Unable to find object");
                test.log(Status.FAIL,"Unable to find object");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }

    public void setValueinTextbox( WebElement element, String value)
    {
        try {
            if(element.isDisplayed())
            {
                element.click();
//                element.clear();
                element.sendKeys(value);
                element.sendKeys(Keys.ENTER);
                System.out.println("Succesfully entered '"+value+"' in object :");
                test.log(Status.INFO,"Succesfully entered '"+value+"' in object :");
            }
            else
            {
                System.out.println("Unable to find object");
                test.log(Status.FAIL,"Unable to find object");

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }
    public void setValueinURLField(WebElement element, String value) {
        try{
            if (element.isDisplayed()){
                element.click();
                element.clear();
                element.sendKeys(value);
            }else
                System.out.println("Element is not displayed");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void setValueinNewURLField(WebElement element) {

        try{
            if (element.isDisplayed()){
                element.click();
                element.sendKeys("https://javascript123.info/url");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setValueinPortalField(WebElement element) {

        try{
            if(element.isDisplayed()){
                element.click();
                element.sendKeys("Elance");
                element.sendKeys(Keys.ENTER);
                element.click();
                element.sendKeys("Freelancer");
                element.sendKeys(Keys.ENTER);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setValueinTagsfield(WebElement element) {
        try {
            if(element.isDisplayed()){
                element.click();
                element.sendKeys("10 minutes Free sessions");
                element.sendKeys(Keys.ENTER);
                element.click();
                element.sendKeys("64 bit architecture");
                element.sendKeys(Keys.ENTER);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void CompareList(ArrayList listNames, ArrayList listNames1)
    {
        try {
            if(listNames.equals(listNames1)==true)
            {
                test.log(Status.INFO,"Result Matched with DB");
                System.out.println("Result Matched with DB");

            }
            else
            {
                System.out.println("Result Doesn't match with DB");
                test.log(Status.FAIL,"Result Doesn't match with DB");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }
    public void captureScreen(String testcaseName) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        Date date = new Date();
        String datetextName = dateFormat.format(date);
        String screenshotPath = System.getProperty("user.dir") + "/test-output/screenshot/" +testcaseName + "_"+datetextName + ".png" ;
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(screenshotPath);
        FileUtils.copyFile(SrcFile, DestFile);
        test.addScreenCaptureFromPath(screenshotPath);

    }

}
