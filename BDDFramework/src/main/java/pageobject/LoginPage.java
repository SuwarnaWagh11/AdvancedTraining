package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;
    @FindBy(name = "login")
    WebElement loginName;
    @FindBy(name = "password")
    WebElement loginPwd;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public void enterLoginName(String name) {
        loginName.sendKeys(name);
    }

    public void enterLoginPwd(String pwd) {
        loginPwd.sendKeys(pwd);
    }
}
