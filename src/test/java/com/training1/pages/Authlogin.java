package com.training1.pages;
import java.util.List;

import com.aventstack.extentreports.ExtentTest;
import com.training1.actions.ActionClass;
import com.training1.constants.CommonVar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Authlogin {
    WebDriver driver;
    ExtentTest extentTest;

    @FindBy(how = How.NAME, using = "sign_in_with_slack")
    private WebElement lnkrocketchat;

    @FindBy(how = How.ID, using = "emailOrUsername")
    private WebElement txtEmail;

    @FindBy(how = How.ID, using = "pass")
    private WebElement txtPassword;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-card\"]/div[3]/button[1]")
    private WebElement btnLogin;

    public Authlogin(WebDriver driver, ExtentTest test) {

        this.driver = driver;
        this.extentTest = test;
        PageFactory.initElements(driver, this);
    }
    public void doSuccessfulLogin() throws InterruptedException {
        ActionClass actionclass = new ActionClass(driver,extentTest);
        Thread.sleep(8000);
        actionclass.clickOnObject(lnkrocketchat);
        Thread.sleep(12000);
        CommonVar commonVar = new CommonVar();
        actionclass.setValueinTextbox(txtEmail,commonVar.uname);
        actionclass.setValueinTextbox(txtPassword,commonVar.pass);
        actionclass.clickOnObject(btnLogin);

    }

    public void loginWithCredentials(String username, String password)
    {
        ActionClass actionclass = new ActionClass(driver,extentTest);
        actionclass.clickOnObject(lnkrocketchat);
        CommonVar commonVar = new CommonVar();
        actionclass.setValueinTextbox(txtEmail,username);
        actionclass.setValueinTextbox(txtPassword,password);
        actionclass.clickOnObject(btnLogin);

    }

}
