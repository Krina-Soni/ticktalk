package com.training1.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

import java.util.List;

public class datatable {
    @Test
    public void datatable(){
        WebDriver driver= new ChromeDriver();
        System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"chromedriver");
        driver.get("https://www.toolsqa.com/automation-practice-table/");
        driver.manage().window().maximize();
        List <WebElement> col = driver.findElements(By.xpath("//*[@id=\"content\"]/table/thead/tr/th"));
        System.out.println("Number os column's value: "+col.size());
        List <WebElement> row = driver.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr"));
        System.out.println("Number os column's value: "+row.size());
        List <WebElement> row1 = driver.findElements(By.xpath("//*[@id=\"content\"]/table/tbody/tr/td"));
        System.out.println("Number os td's value: "+row1.size());
        for(int i=1; i<=row.size(); i++){
            System.out.print(driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[" + i +"]/th")).getText()+ "\t");
            for(int j=1; j<col.size(); j++){
                    System.out.print(driver.findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[" + i +"]/td[" + j + "]")).getText()+ "\t");
            }
            System.out.println("");
            //*[@id="content"]/table
        }
    }
}

