package com.training1.pages;

import com.aventstack.extentreports.ExtentTest;
import com.training1.constants.CommonVar;
import com.training1.utilities.DatabaseFunctions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.training1.actions.ActionClass;
import com.training1.actions.VerificationClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Bids {

        WebDriver driver;
        ExtentTest extentTest;
    Connection conn = null;
    //Docker
    String url = "jdbc:mysql://localhost:6603/";
    //localDB
//    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "timesheet";
    String driver1 = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";
    //    String password = "";
    Statement statement;
    ResultSet Qcount;
    ResultSet queryRs;

        @FindBy(how = How.NAME, using = "sign_in_with_slack")
        private WebElement linktorocketchat;

        @FindBy(how = How.XPATH, using = "//*[@id=\"emailOrUsername\"]\n")
        private WebElement uname;

        @FindBy(how = How.ID, using = "pass")
        private WebElement pass;

        @FindBy(how = How.XPATH, using = "/html/body/section/div/form/div[3]/button[1]\n")
        public WebElement btnlogin;

        @FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div\n")
        public WebElement lblloggedin;

        @FindBy(how = How.XPATH, using = "/html/body/div[4]/div[2]/div/form/div[3]/button[3]\n")
        public WebElement btnAuthorize;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/nav/div/ul/li[1]/a")
        public WebElement btnCache;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/nav/div/div[1]/button")
        public WebElement btnmenu;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[1]/nav/ul/li[2]/a")
        public WebElement btnLeads;

        @FindBy(how = How.XPATH, using = "//*[@id=\"leadasdsd-dropdown-element\"]/div/ul/li[1]/a")
        public WebElement btnBIDSmenu;


        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/h1/a")
        public WebElement btnAddBIDS;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div/div[1]/div/input")
        public WebElement txtAddURL;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div/div[2]/div/span/span[1]/span/ul/li/input")
        public WebElement txtAddPortal;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div/div[3]/div/span/span[1]/span/ul/li/input")
        public WebElement txtAddTags;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div/div[4]/input[1]")
        public WebElement txtAddStatus1;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div/div[4]/input[2]")
        public WebElement txtAddStatus2;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[2]/button")
        public WebElement btnSave;

        @FindBy(how = How.XPATH, using = "//*[@id=\"postData[0][bid_url]-error\"]")
        public WebElement lblBIDURL;

        @FindBy(how = How.XPATH, using = "//*[@id=\"postData[0][bid_source][]-error\"]")
        public WebElement lblPortal;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div/div[5]/div/button")
        public WebElement btnAddNewLead;

        // Find by Functionalities for New Lead elements

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div[2]/div[1]/div/input")
        public WebElement txtAddNewURL;

        @FindBy(how = How.XPATH, using = "//*[@id=\"postData[1][bid_url]-error\"]")
        public WebElement lblAddnewURL;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div[2]/div[2]/div/span/span[1]/span/ul/li/input")
        public WebElement txtAddNewPortal;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div[2]/div[3]/div/span/span[1]/span/ul/li/input")
        public WebElement txtnewAddTags;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bids-form\"]/div[1]/div[2]/div[4]/input[1]")
        public WebElement txtnewAddStatus1;

        @FindBy(how = How.XPATH, using = "//*[@id=\"postData[1][bid_source][]-error\"]")
        public WebElement lblAddNewPortal;

        @FindBy(how = How.XPATH, using = "/html/body/div[3]/div\n")
        public WebElement lblSAMEURL;

        @FindBy(how = How.XPATH, using = "//*[@id=\"remove_1\"]")
        public WebElement btnDeleteBID;

        @FindBy(how = How.CSS, using = "css=.save")
        public WebElement btnSAVEBIDS;

        @FindBy(how = How.CLASS_NAME, using = "toast-message")
        public WebElement btnToast;

        //Find By Functionalities for Filter data

        @FindBy(how = How.XPATH, using = "//*[@id=\"bread-actions\"]/a[1]")
        public WebElement viewBID;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bread-actions\"]/a[2]")
        public WebElement btnUpdate_BID;

        @FindBy(how = How.XPATH, using = "//*[@id=\"delete-88\"]")
        public WebElement btnDelete_BID;

        @FindBy(how = How.XPATH, using = "//*[@id=\"delete_form\"]/input[3]")
        public WebElement btnConfirm_Delete_BID;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/form/div/div[3]/div[2]/div/ul/li/input")
        public WebElement filter_tags_data;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/form/div/div[2]/div[2]/div/ul/li/input")
        public WebElement filter_portal_data;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/form/div/div[7]/div/div/input")
        public WebElement btnSearch;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/form/div/div[1]/div[2]/div/ul/li/input")
        public WebElement txtboxUser;

        @FindBy(how = How.XPATH, using = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[2]/span")
        public WebElement txtBIDRecord1;

        @FindBy(how = How.XPATH, using = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[1]")
        public WebElement lblUser;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/form/div/div[2]/div[2]/div/ul/li/input")
        public WebElement searchPortal;

        @FindBy(how = How.XPATH, using = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[5]")
        public WebElement searchPortaldata;

        @FindBy(how = How.XPATH, using = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[3]")
        public WebElement lblstart_date;

        @FindBy(how = How.XPATH, using = "//*[@id=\"dataTable\"]/tbody/tr[1]/td[3]")
        public WebElement lblend_date;

        @FindBy(how = How.CLASS_NAME, using = "active")
        public WebElement pageNext;

        @FindBy(how = How.NAME, using = "start_date")
        public WebElement start_date;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/form/div/div[6]/div[2]/input")
        public WebElement end_date;

        @FindBy(how = How.CSS, using = "disabled > span")
        public WebElement pageEnd;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bread-actions\"]/a[1]")
        public WebElement viewRecord;

        @FindBy(how = How.XPATH, using = "//*[@id=\"bread-actions\"]/a[2]")
        public WebElement editRecord;

        @FindBy(how = How.XPATH, using = "//*[@id=\"delete-86\"]")
        public WebElement deleteRecord;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/div[1]/form/button")
        public WebElement btnUploadFile;

        @FindBy(how = How.CLASS_NAME, using = "disabled")
        public WebElement btnPageNext;

        @FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[2]/div/div[1]/form/small/input")
        public WebElement btnSelectFile;

        @FindBy(how = How.CLASS_NAME, using = "toast-message")
        public WebElement toast_blankUploadFile;

        public Bids(WebDriver driver, ExtentTest test) {
            this.driver = driver;
            this.extentTest=test;
            PageFactory.initElements(driver, this);
        }

        public void successlogin() throws InterruptedException, IOException {

            ActionClass actionClass = new ActionClass(driver,extentTest);
            CommonVar constantVar = new CommonVar();
            actionClass.clickOnObject(linktorocketchat);
            Thread.sleep(3000);
            actionClass.setValueinTextbox(uname, CommonVar.uname);
            actionClass.setValueinTextbox(pass, CommonVar.pass);
            actionClass.clickOnObject(btnlogin);
            Thread.sleep(3000);
            actionClass.clickOnObject(btnAuthorize);
            Thread.sleep(3000);
            actionClass.captureScreen("Login successfull");

        }

        public void unSuccesslogin(String username, String password) throws InterruptedException, IOException {

            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);
            actionClass.clickOnObject(linktorocketchat);
            Thread.sleep(2000);
            CommonVar constantVar = new CommonVar();
            actionClass.setValueinTextbox(uname, username);
            actionClass.setValueinTextbox(pass, password);
            actionClass.clickOnObject(btnlogin);
            actionClass.captureScreen("Unsuccessfull login");
        }

        public void verifyUserIsNotLoggedIn() throws IOException, InterruptedException {

            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);
            verificationClass.verifyElementNotPresent(lblloggedin);
            Thread.sleep(2000);
            actionClass.captureScreen("invalid login");

        }

        public void verifyBIDS() throws InterruptedException, IOException {

            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);
            actionClass.clickOnObject(btnmenu);
            Thread.sleep(2000);
            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);
            Thread.sleep(3000);
            actionClass.clickOnObject(btnAddBIDS);

            //Check_for_Blank_Fields
            actionClass.clickOnObject(btnSave);
            verificationClass.verifyElementPresent(lblBIDURL);
            actionClass.captureScreen("All_Fields_Validation");

            //Check for Valid URL and Blank Others

            Thread.sleep(3000);
            actionClass.setValueinURLField(txtAddURL, "https://javascript.info/url");
            actionClass.clickOnObject(btnSave);
            verificationClass.verifyElementNotPresent(lblBIDURL);
            actionClass.captureScreen("ValidURL");


//        //Check for Blank Portal, Tags, status
            Thread.sleep(3000);
            actionClass.clickOnObject(btnSave);
            verificationClass.verifyElementPresent(lblPortal);
            actionClass.captureScreen("Blank_Portal");

            //Check for Valid Portal
            Thread.sleep(2000);

            actionClass.setValueinPortalField(txtAddPortal);
            actionClass.clickOnObject(btnSave);
            verificationClass.verifyElementNotPresent(lblPortal);

            //Check for Valid Portals
            Thread.sleep(2000);

            actionClass.setValueinPortalField(txtAddPortal);
            actionClass.clickOnObject(btnSave);
            verificationClass.verifyElementNotPresent(lblPortal);
            actionClass.captureScreen("Valid_Portal");

            //Check for Valid Tags
            Thread.sleep(3000);
            actionClass.setValueinTagsfield(txtAddTags);
            actionClass.clickOnObject(btnSave);
            actionClass.captureScreen("Valid_Tags");

            //Check for Single Record saving

//        actionClass.setValueinURLField(txtAddURL);
//        actionClass.setValueinPortalField(txtAddPortal);
//        actionClass.setValueinTagsfield(txtAddTags);
            actionClass.clickOnObject(txtAddStatus1);
            actionClass.clickOnObject(txtAddStatus2);
            actionClass.clickOnObject(btnSave);
            actionClass.captureScreen("Valid Status");

            //Check for Single Record Saving
//        actionClass.setValueinURLField(txtAddURL);
//        actionClass.setValueinPortalField(txtAddPortal);
//        actionClass.setValueinTagsfield(txtAddTags);
//        actionClass.clickOnObject(txtAddStatus1);
        actionClass.clickOnObject(btnSave);
        verificationClass.isElementPresent(btnToast,"Successfully Added New Bid");
        Thread.sleep(2000);
        actionClass.captureScreen("New Record Added");


        }

        public void addnewBIDS() throws InterruptedException, IOException {

            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);
            actionClass.clickOnObject(btnmenu);

            Thread.sleep(2000);

            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);
            actionClass.clickOnObject(btnAddBIDS);

            actionClass.setValueinNewURLField(txtAddURL);
            actionClass.setValueinPortalField(txtAddPortal);
            actionClass.setValueinTagsfield(txtAddTags);
            actionClass.clickOnObject(txtAddStatus1);
            actionClass.clickOnObject(txtAddStatus2);


            //Check for Blank field submission for newly added fields
            actionClass.clickOnObject(btnAddNewLead);
            actionClass.clickOnObject(btnSave);
            verificationClass.verifyElementPresent(lblAddnewURL);
            actionClass.captureScreen("NEW_LEADS-BLAnk-SUBMISSIONS");


            Thread.sleep(3000);
            //Check for Valid URL and Blank Portal
            actionClass.setValueinURLField(txtAddNewURL, "https://javascript.info/url"); //URL added
            actionClass.clickOnObject(btnSave);
            actionClass.captureScreen("Valid_New_URL");

            //Check for Blank Portal
            Thread.sleep(3000);
            actionClass.clickOnObject(btnSave);
            verificationClass.verifyElementPresent(lblAddNewPortal);
            actionClass.captureScreen("New_Blank_Portal");

            //Check for Valid Portal
            Thread.sleep(2000);
            actionClass.setValueinPortalField(txtAddNewPortal); //Portal Added
            actionClass.clickOnObject(btnSave);

            //Check for Valid tags
            actionClass.setValueinTagsfield(txtnewAddTags); //Tags added
            actionClass.clickOnObject(btnSave);
            actionClass.captureScreen("New_Valid_tags");

            //Check for Multiple Record saves

            Thread.sleep(2000);
            actionClass.clickOnObject(txtnewAddStatus1); // Status added
            actionClass.clickOnObject(btnSave);
            verificationClass.isElementPresent(btnToast,"Successfully Added New Bid");
            Thread.sleep(2000);
            actionClass.captureScreen("Multiple BIDS added");
        }

        public void bidsValidation() throws IOException, InterruptedException {


            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);

            //Routing to Add BIDS page

            actionClass.clickOnObject(btnmenu);
            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);
            actionClass.clickOnObject(btnAddBIDS);


            //Row 1

            actionClass.setValueinURLField(txtAddURL, "https://javascript.info/url");
            actionClass.setValueinPortalField(txtAddPortal);
            actionClass.setValueinTagsfield(txtAddTags);
            actionClass.clickOnObject(txtAddStatus1);
            actionClass.clickOnObject(txtAddStatus2); //Row 1 Added
            actionClass.clickOnObject(btnAddNewLead);


            //Row 2

            actionClass.setValueinURLField(txtAddNewURL, "https://pythoncript.info/url");   //URL added
            actionClass.setValueinPortalField(txtAddNewPortal); //Portal Added
            actionClass.setValueinTagsfield(txtnewAddTags);     //Tags added
            actionClass.clickOnObject(txtnewAddStatus1);// Status added

            Thread.sleep(4000);
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/form[1]/div[2]/button\n"));

            actionClass.clickOnObject(btnSave);
            Thread.sleep(3000);
            actionClass.captureScreen("Error capture");

            verificationClass.checkToast(btnToast, "BID URL on row no 2 should be unique");

//        Deleting the Second row
        /*Thread.sleep(2000);
        actionClass.clickOnObject(btnDeleteBID);
        actionClass.screenCapture("Row_Deleted");
        actionClass.clickOnObject(btnSave);
        */
        }

        public void viewBID() throws IOException, InterruptedException {

            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);

            //Routing to Add BIDS page

            actionClass.clickOnObject(btnmenu);
            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);

            actionClass.clickOnObject(viewBID);
            Thread.sleep(2000);
            actionClass.captureScreen("View_BID");

        }

        public void update_BID() throws IOException, InterruptedException {


            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);

            //Routing to Add BIDS page

            actionClass.clickOnObject(btnmenu);
            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);

            //Updating BID

            actionClass.clickOnObject(btnUpdate_BID);
            actionClass.setValueinURLField(txtAddURL,"https://helloDevelop.google.com/speed/pagespeed/insights/");
            actionClass.setValueinTextbox(txtAddPortal,"Upwork");
            actionClass.setValueinTextbox(txtAddTags,"angular");

            actionClass.clickOnObject(btnSAVEBIDS);
            verificationClass.isElementPresent(btnToast,"Successfully Updated Bid");
            Thread.sleep(2000);
            actionClass.captureScreen("BID_Success_Update");

        }

        public void delete_BID() throws IOException, InterruptedException {


            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);

            //Routing to Add BIDS page

            actionClass.clickOnObject(btnmenu);
            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);

            actionClass.setValueinTextbox(txtboxUser, "johnny21.1.2");
            actionClass.clickOnObject(btnSearch);

            Thread.sleep(2000);
//            actionClass.clickOnObject(btnDelete_BID);
            btnDelete_BID.click();
//
//        driver.findElement(By.className("btn btn-danger pull-right delete-confirm")).click();
//            actionClass.clickOnObject(btnConfirm_Delete_BID);
            btnConfirm_Delete_BID.click();
            Thread.sleep(3000);
            verificationClass.isElementPresent(btnToast,"Successfully Deleted Bid");
            Thread.sleep(2000);
            actionClass.captureScreen("BID_Delete_Success");
        }

        public void deleteRow_BID() throws IOException, InterruptedException {


            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);

            //Routing to Add BIDS page

            actionClass.clickOnObject(btnmenu);
            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);
            actionClass.clickOnObject(btnAddBIDS);


            //Row 1

            actionClass.setValueinURLField(txtAddURL, "https://javascript567.info/url");
            actionClass.setValueinPortalField(txtAddPortal);
            actionClass.setValueinTagsfield(txtAddTags);
            actionClass.clickOnObject(txtAddStatus1);
            actionClass.clickOnObject(txtAddStatus2); //Row 1 Added
            actionClass.clickOnObject(btnAddNewLead);


            //Row 2

            actionClass.setValueinURLField(txtAddNewURL, "https://javascript567.info/url");   //URL added
            actionClass.setValueinPortalField(txtAddNewPortal); //Portal Added
            actionClass.setValueinTagsfield(txtnewAddTags);     //Tags added
            actionClass.clickOnObject(txtnewAddStatus1);// Status added
            Thread.sleep(4000);

            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/form[1]/div[2]/button\n"));

            actionClass.clickOnObject(btnSave);
            Thread.sleep(3000);
            actionClass.captureScreen("Error capture");

//        Deleting the Second row for the duplicate URL
            Thread.sleep(3000);
            actionClass.clickOnObject(btnDeleteBID);
            actionClass.captureScreen("Row_Deleted");
            actionClass.clickOnObject(btnSave);

        }

        public void filterSearch() throws InterruptedException, SQLException, IOException {


            VerificationClass verificationClass = new VerificationClass(driver, extentTest);
            ActionClass actionClass = new ActionClass(driver, extentTest);

            //Routing to Add BIDS page
            actionClass.clickOnObject(btnmenu);
            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);
            ///=====================

            //Clear Cache
            Thread.sleep(3000);
            actionClass.clickOnObject(btnCache);

//        //Filter by name searches
            Thread.sleep(3000);
            actionClass.setValueinTextbox(txtboxUser, "johnny21.1.2");
            verificationClass.isElementPresent(lblUser, "johnny21.1.2");
            actionClass.captureScreen("Filter_user_done");
//            txtboxUser.sendKeys(Keys.ENTER);//
            actionClass.clickOnObject(btnSearch);
            ///=====================

            List<WebElement> ListStudent = driver.findElements(By.xpath("//*[@id=\"dataTable\"]/tbody/tr"));
            int ClassStudentsize = ListStudent.size();
            ArrayList listNames1 = new ArrayList();
            ArrayList listNames2 = new ArrayList();

            for (int i = 1; i <= ClassStudentsize; i++) {
//                String s = driver1.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[" + i + "]/td[1]")).getText();
//                System.out.println("Value in list is: " + s);
                listNames1.add(driver.findElement(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[" + i + "]/td[1]")).getText());
            }
            DatabaseFunctions DAB = new DatabaseFunctions();
            conn = DAB.connect();
            statement = conn.createStatement();
            String query = "SELECT users.name FROM `bids` INNER JOIN users ON users.id=bids.created_by WHERE bids.created_by='163' AND users.active='1'";
            queryRs = statement.executeQuery(query);

            while (queryRs.next()) {

                listNames2.add(queryRs.getString("users.name"));

            }
            System.out.println(listNames1.equals(listNames2));
            actionClass.CompareList(listNames1, listNames2);
            Thread.sleep(3000);

            ///=====================
            actionClass.captureScreen("Check with username & Date");
            //Filter by Portal and Tags
            Thread.sleep(3000);
            actionClass.setValueinTextbox(filter_portal_data, "Freelancer");
            actionClass.setValueinTextbox(filter_portal_data, "Elance");
            actionClass.setValueinTextbox(filter_portal_data, "Upwork");

            Thread.sleep(2000);

            actionClass.setValueinTextbox(filter_tags_data, "Video Processing");
            actionClass.setValueinTextbox(filter_tags_data, "143544");
            actionClass.setValueinTextbox(filter_tags_data, "10 minutes Free sessions");

            Thread.sleep(3000);
            start_date.sendKeys("01012020");
            end_date.sendKeys("20022020");

            actionClass.clickOnObject(btnSearch);
            Thread.sleep(2000);
            actionClass.captureScreen("Check with username, Date, portal & tags");
            ///=====================

        }

        public void blankFile_UploadValidation() throws IOException, InterruptedException {


            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);

            actionClass.clickOnObject(btnmenu);
            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);


            //Uploading a Blank file
            WebElement uploadElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[1]/form/small/input"));
            uploadElement.sendKeys("/home/addweb/Downloads/bids_data_import_Blank_report (2).csv");
            actionClass.clickOnObject(btnUploadFile);
            verificationClass.checkToast(toast_blankUploadFile,"Upload file is empty.");
            Thread.sleep(2000);
            actionClass.captureScreen("Blank_BIDfile");
            ///=====================

        }

        public void sameURL_uploadValidation() throws IOException, InterruptedException {

            VerificationClass verificationClass = new VerificationClass(driver,extentTest);
            ActionClass actionClass = new ActionClass(driver,extentTest);

            //Routing to Add BIDS page
            actionClass.clickOnObject(btnmenu);
            actionClass.clickOnObject(btnLeads);
            actionClass.clickOnObject(btnBIDSmenu);
            ///=====================

            //Uploading duplicate entries file
            WebElement uploadElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[1]/form/small/input"));
            uploadElement.sendKeys("/home/addweb/Downloads/sameURLs_UploadValidation - Sheet1.csv");
            ///=====================

            actionClass.clickOnObject(btnUploadFile);
            verificationClass.checkToast(toast_blankUploadFile,"Bid Url value in row number 1 is duplicate, please use different one");
            Thread.sleep(2000);
            actionClass.captureScreen("Duplicate_BIDvalue");
        }

    public void valid_FileUpload() throws InterruptedException, IOException {

        ActionClass actionClass = new ActionClass(driver,extentTest);
        VerificationClass verificationClass = new VerificationClass(driver,extentTest);

//Routing to Add BIDS page
        actionClass.clickOnObject(btnmenu);
        actionClass.clickOnObject(btnLeads);
        actionClass.clickOnObject(btnBIDSmenu);
///=====================

        WebElement uploadElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div[1]/form/small/input"));
        uploadElement.sendKeys("/home/addweb/Downloads/valid_File_UploadValidation - Sheet1.csv");
        Thread.sleep(2000);
        actionClass.captureScreen("Valid_BIDFile");
    }
}









