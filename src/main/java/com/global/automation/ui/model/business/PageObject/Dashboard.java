package com.global.automation.ui.model.business.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
    WebDriver ldriver;

    public Dashboard(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div/a")
    WebElement demoDashboardNameLink;

    public void clickOnDemoDashboard(){
        demoDashboardNameLink.click();
    }
}
