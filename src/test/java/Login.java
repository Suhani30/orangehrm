import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Login {
    @FindBy(name = "username")
    WebElement txtUsername;
    @FindBy(name = "password")
    WebElement txtPass;
    @FindBy(css = "[type=submit]")
    WebElement btnSubmit;


    public Login( WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void doLogin(String username, String password){
        txtUsername.sendKeys(username);
        txtPass.sendKeys(password);
        btnSubmit.click();
    }
}
