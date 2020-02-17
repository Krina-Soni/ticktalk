package com.training1.pages;
import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.training1.actions.ActionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddLead {
    WebDriver driver;
    ExtentTest extentTest;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[1]")
    private WebElement SidebarOPen;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Lead")
    private WebElement AccessLead;

    @FindBy(how = How.LINK_TEXT, using = "Lead Management")
    private WebElement LeadManage;
//    @FindBy(how = How.CLASS_NAME, using = "icon voyager-milestone")
//    private WebElement LeadManagement;

//    @FindBy(how = How.LINK_TEXT, using = "//*[@id=\"lead-dropdown-element\"]/div/ul/li[1]")
//    private WebElement LeadManagement;
//


    public AddLead(WebDriver driver) {

        this.driver = driver;
       // this.extentTest = extent;
        PageFactory.initElements(driver, this);
    }

    public void AddLead() throws InterruptedException {

    Actions actions = new Actions(driver);
//        ActionClass actionClass = new ActionClass(driver,extentTest);
//        WebElement menuOption = SidebarOPen;
//        actions.moveToElement(menuOption).perform();
//        System.out.println("Successfully Hovered over the Menu");
//        actionClass.clickOnObject(AccessLead);
//        actionClass.clickOnObject(LeadManage);

//        WebElement menuOptionLM = LeadManagement;
//        actions.moveToElement(menuOptionLM).perform();
      //  actionClass.clickOnObject(LeadManagement);

    }

}
