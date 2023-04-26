package com.global.automation.model.business.pageobject;

import com.global.automation.base.BaseTest;
import com.global.automation.utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DemoDashboard extends BaseTest {

    WebDriver ldriver;

    public DemoDashboard(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "//div[@class='widgets-grid']/div/div")
    List<WebElement> totalWidget;

    @FindBy(xpath = "//div[@class='widgets-grid']")
    WebElement widgetName;

    public int getTotalWidgetPresetOnDemoDashboard(){
        return totalWidget.size();
    }

    public boolean verifyNamesOfWidgetPresetOnDemoDashboard(String name){
        Utilities utilities = new Utilities();
        utilities.scrollToElement(ldriver,ldriver.findElement(By.xpath("//*[text()='"+ name +"']")));
        return ldriver.findElement(By.xpath("//*[text()='"+ name +"']")).isDisplayed();
    }

}
