package com.global.automation.ui.model.business.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver ldriver;

    public LoginPage(WebDriver rdriver){
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
        loginName.sendKeys(name);
    }

    public void enterLoginPwd(String pwd){
        loginPwd.sendKeys(pwd);
    }
}
