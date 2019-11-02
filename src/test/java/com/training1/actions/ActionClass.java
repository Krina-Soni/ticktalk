package com.training1.actions;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
               // test.log(Status.INFO,"Sucessfully clicked on object : "+element.getAttribute("name"));
                System.out.println("Sucessfully clicked on object : "+element.getAttribute("name"));
            }
            else
            {
                System.out.println("Unable to find object : "+element.getAttribute("name"));
     //           test.log(Status.FAIL,"Unable to find object : "+element.getAttribute("name"));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
//            test.log(Status.FAIL,e.getMessage());
        }
    }

    public void setValueinTextbox( WebElement element, String value)
    {
        try {
            if(element.isDisplayed())
            {
                element.clear();
                element.sendKeys(value);
                System.out.println("Succesfully entered '"+value+"' in object :" + element.getAttribute("name"));
                test.log(Status.INFO,"Succesfully entered '"+value+"' in object :" + element.getAttribute("name"));
            }
            else
            {
                System.out.println("Unable to find object : "+element.getAttribute("name"));
                test.log(Status.FAIL,"Unable to find object : "+element.getAttribute("name"));

            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            test.log(Status.FAIL,e.getMessage());
        }
    }

}
