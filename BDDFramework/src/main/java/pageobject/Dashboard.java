package pageobject;

//import com.global.automation.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static base.BaseTest.logger1;

public class Dashboard {//extends BaseTest {
    WebDriver ldriver;

    public Dashboard(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "//*[@id='app']/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/div/a")
    WebElement demoDashboardNameLink;

    public void clickOnDemoDashboard(){
        //logger1.info("***clicking On DemoDashboard***");
        demoDashboardNameLink.click();
    }
}
