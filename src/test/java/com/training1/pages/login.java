
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login {
    @Test
    public void Valid_login() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        System.setProperty("Webdriver.chrome.driver",System.getProperty("user.dir")+"chromedriver");
        driver.get("https://www.toolsqa.com/automation-practice-form/");
        driver.manage().window().maximize();
        WebElement txtFirstName = driver.findElement(By.name("firstname"));
        txtFirstName.sendKeys("krina");
        //txtFirstName.clear();
        txtFirstName.isEnabled();
        System.out.println(txtFirstName.getText());
        Assert.assertTrue(true);
        WebElement txtLastName = driver.findElement(By.id("lastname"));
        txtLastName.sendKeys("soni");
        WebElement sex1 = driver.findElement(By.id("sex-0"));
        WebElement sex2 = driver.findElement(By.id("sex-1"));
        boolean b1 = driver.findElement(By.id("sex-0")).isDisplayed();
        Assert.assertTrue(b1);
        driver.findElement(By.id("sex-1")).isDisplayed();
        driver.findElement(By.id("sex-0")).isEnabled();
        driver.findElement(By.id("sex-1")).isEnabled();
        driver.findElement(By.id("sex-0")).click();
        driver.findElement(By.id("sex-0")).isSelected();
        driver.findElement(By.id("sex-0")).getAttribute("checked");
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("sex-1")).getAttribute("enabled");
        Thread.sleep(1200);
        WebElement exp = driver.findElement(By.id("exp-0"));
        exp.click();
        driver.findElement(By.id("datepicker")).sendKeys("23-08-1992");
        WebElement pro1 = driver.findElement(By.id("profession-0"));
        pro1.click();
        boolean autotester= driver.findElement(By.id("profession-1")).isSelected();
        if(driver.findElement(By.id("profession-0")).isSelected()){
            driver.findElement(By.id("profession-1")).clear();
        }
        else
        {
            driver.findElement(By.id("profession-1")).click();
        }
        WebElement image = driver.findElement(By.id("photo"));
        image.sendKeys("/home/addweb/Pictures/1.png");
        //driver.quit();
    }


}
