import io.qameta.allure.Allure;
import org.asynchttpclient.ClientStats;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestRunner extends setup {
    @Test(priority = 1, description = "User can login successfully")
    public void doLogin() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Login loginPage = new Login(driver);
        loginPage.doLogin("Admin" , "admin123");
    }

    public void clickPIM() throws InterruptedException {
        Thread.sleep(2000);
//        List<WebElement> sidebarMenu = driver.findElements(By.className("oxd-main-menu-item-wrapper"));
//        sidebarMenu.get(1).click();
//        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]")).click();
        driver.findElement(By.linkText("PIM")).click();
        driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--secondary")).click();
    }
    public void addDescription(String data) throws Exception
    {
        try{
            Allure.description(data);
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }
    }
}
