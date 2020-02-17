package com.training1.testcases;

import com.training1.pages.Bids;
import com.training1.utilities.DatabaseFunctions;
import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.SQLException;

public class Bid_Test extends BaseCase {

    @Test
    public void Check_connection() throws InterruptedException, IOException, SQLException, SQLException {

        DatabaseFunctions DBConnect = new DatabaseFunctions();
        DBConnect.printUserNamePassword();
        driver.quit();

    }

    @Test
    public void Success_Login() throws InterruptedException, IOException {

        logger = extent.createTest("Check If user is able to login successfully with Valid credentials");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        driver.quit();
    }

    @Test
    public void unSuccess_login() throws InterruptedException, IOException {

        logger = extent.createTest("Check If user is able to login with Invalid credentials");
        Bids login = new Bids(driver, logger);
        login.unSuccesslogin("harshad.a123ddweb@gmail.com", "addweb123");
        Thread.sleep(5000);
        login.verifyUserIsNotLoggedIn();
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void BIDURL() throws InterruptedException, IOException {
        logger = extent.createTest("Check for all validations while adding a BID");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        login.verifyBIDS();
        driver.quit();
    }

    @Test
    public void AddnewBID() throws InterruptedException, IOException {

        logger = extent.createTest("Check If user can Add multiple bids or not");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        login.addnewBIDS();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void validateBids() throws InterruptedException, IOException {
        logger = extent.createTest("Check If user can Add multiple bids or not");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        login.bidsValidation();
        driver.quit();
    }

    @Test
    public void delete_RowBid() throws InterruptedException, IOException {
        logger = extent.createTest("Check If user can Add multiple bids or not");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        login.deleteRow_BID();
    }

    @Test
    public void Update_BID() throws IOException, InterruptedException {

        logger = extent.createTest("Check If user is able to Update BID Record");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        login.update_BID();
        driver.quit();
    }

    @Test
    public void delete_BID() throws IOException, InterruptedException {

        logger = extent.createTest("Check If user is able to Delete BID");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        login.delete_BID();
        driver.quit();
    }

    @Test
    public void checkFilter() throws InterruptedException, IOException, SQLException {
        logger = extent.createTest("Check If user can Search Records as per the Filter");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        login.filterSearch();
        driver.close();
    }

    //
    @Test
    public void blankFile_UploadFile_Validation() throws InterruptedException, IOException {
        logger = extent.createTest("Check If user can Upload Blank CSV file");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        login.blankFile_UploadValidation();
        driver.quit();
    }

    @Test
    public void sameURLs_UploadFile_Validation() throws InterruptedException, IOException {
        logger = extent.createTest("Check If user can upload Same URLs");
        Bids login = new Bids(driver, logger);
        login.successlogin();
        login.sameURL_uploadValidation();
        driver.quit();
    }

   @Test
    public void Valid_URL_Upload() throws IOException, InterruptedException {
       logger = extent.createTest("Check If user can Upload Valid File");
       Bids login = new Bids(driver, logger);
       login.successlogin();
       login.valid_FileUpload();
       driver.quit();
   }
    }

