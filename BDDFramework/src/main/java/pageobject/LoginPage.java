package pageobject;

//import com.global.automation.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static base.BaseTest.logger1;

public class LoginPage {//extends BaseTest {

    WebDriver ldriver;
    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(name = "login")
    WebElement loginName;

    @FindBy(name = "password")
    WebElement loginPwd;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public void clickOnLogin(){
        //logger1.info("***clicking On Login***");
        loginButton.click();
    }

    public void enterLoginName(String name){
        //logger1.info("***Entering Username***");
        loginName.sendKeys(name);
    }

    public void enterLoginPwd(String pwd){
        //logger1.info("***Entering Password***");
        loginPwd.sendKeys(pwd);
    }
}
