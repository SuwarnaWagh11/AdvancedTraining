package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        loginButton.click();
    }

    public void enterLoginName(String name){
        loginName.clear();
        loginName.sendKeys(name);
    }

    public void enterLoginPwd(String pwd){
        loginPwd.clear();
        loginPwd.sendKeys(pwd);
    }
}
