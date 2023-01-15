import io.qameta.allure.Allure;
import org.asynchttpclient.ClientStats;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class TestRunner extends setup {
    @Test(priority = 1, description = "User can login successfully")
    public void doLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Login loginPage = new Login(driver);
        loginPage.doLogin("Admin" , "admin123");
    }
    @Test(priority = 2, description = "User Can click the Sidebar")
    public void clickPIM() throws InterruptedException {

        List<WebElement> sidebarMenu = driver.findElements(By.className("oxd-main-menu-item-wrapper"));
        sidebarMenu.get(1).click();
//        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]")).click();
//        driver.findElement(By.linkText("PIM")).click();
//        driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--secondary")).click();
//        driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")).click();

    }
    @Test (priority = 3,description = "User can click add button")
    public void add(){
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")).click();
    }
    @Test(priority = 4,description = "User can enter info")
    public void addEmployee() throws InterruptedException{
            Thread.sleep(1000);
        List<WebElement> input =driver.findElements(By.className("oxd-input"));
        input.get(1).sendKeys("Amani");
        input.get(3).sendKeys("Inaaya");
        List<WebElement> toggle =driver.findElements(By.className("oxd-switch-input"));
        toggle.get(0).click();
        List<WebElement> UserInfo = driver.findElements(By.className("oxd-input"));
        UserInfo.get(5).sendKeys("habiba6");
        UserInfo.get(6).sendKeys("Suhani@123");
        UserInfo.get(7).sendKeys("Suhani@123");
        List<WebElement> button = driver.findElements(By.className("oxd-button"));
        button.get(1).click();


    }
    @Test(priority = 5,description = "Assertion can be done")
    public void employeeInfo() throws InterruptedException{
//        Thread.sleep(3000);
        List<WebElement> txtLabel = driver.findElements(By.className("oxd-text"));

        String Name_Actual = txtLabel.get(12).getText();
        String Name_Expected = "Amani Inaaya";

        String userInfo_Actual = txtLabel.get(13).getText();
        String userInfo_Expected= "Personal Details";

        Assert.assertEquals(Name_Actual,Name_Expected);
        Assert.assertEquals(userInfo_Actual,userInfo_Expected);
    }
    @Test(priority = 6,description = "User can click again")
    public void clickAgain() throws InterruptedException{
        Thread.sleep(3000);
        List<WebElement> sidebarMenu = driver.findElements(By.className("oxd-main-menu-item-wrapper"));
        sidebarMenu.get(1).click();

        List<WebElement> employeeName = driver.findElements(By.tagName("input"));
        employeeName.get(1).sendKeys("Amani Inaaya");
        List<WebElement> employeeSearch = driver.findElements(By.tagName("button"));
        employeeSearch.get(3);

        Thread.sleep(1000);
        List<WebElement> assertLabel =driver.findElements(By.className("oxd-text--span"));
        String record_Actual = assertLabel.get(11).getText();
        String record_Expected= "(1) Record Found";

        Assert.assertEquals(record_Actual,record_Expected);

    }

//    public void addDescription(String data) throws Exception
//    {
//        try{
//            Allure.description(data);
//        }
//        catch(Exception e)
//        {
//            System.out.print(e.toString());
//        }
//    }
}
