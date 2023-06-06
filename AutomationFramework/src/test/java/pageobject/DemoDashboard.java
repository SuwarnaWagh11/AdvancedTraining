package pageobject;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilitiesClass;

import java.util.List;
import java.util.Properties;

public class DemoDashboard extends BaseTest {//extends BaseTest {

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
        UtilitiesClass.scrollToElement(ldriver,ldriver.findElement(By.xpath("//*[text()='"+ name +"']")));
        return ldriver.findElement(By.xpath("//*[text()='"+ name +"']")).isDisplayed();
    }

    public Dimension getSizeOfWidget1(String xpath) {
        return ldriver.findElement(By.xpath(xpath)).getSize();
    }

    public WebElement resizableHandle1_draggable(String xpath) {
        return ldriver.findElement(By.xpath(xpath));
    }
    public Dimension presizableHandle1_droppable(String xpath) {
        return ldriver.findElement(By.xpath(xpath)).getSize();
    }

    public WebElement resizableHandle1_droppable(String xpath) {
        return ldriver.findElement(By.xpath(xpath));
    }

    public Dimension updated_sizeOfWidget1(String xpath) {
        return ldriver.findElement(By.xpath(xpath)).getSize();
    }

    public WebElement widget2(String xpath) {
        return ldriver.findElement(By.xpath(xpath));
    }

    public Point widget2Location(String xpath) {
        return ldriver.findElement(By.xpath(xpath)).getLocation();
    }

}
