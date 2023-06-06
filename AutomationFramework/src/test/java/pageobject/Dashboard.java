package pageobject;

//import com.global.automation.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {//extends BaseTest {
    WebDriver ldriver;

    public Dashboard(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
    }
    @FindBy(xpath = "//a[text()='DEMO DASHBOARD'][@class='gridCell__grid-cell--3e2mS gridCell__align-left--2beIG dashboardTable__name--1sWJs']")
    WebElement demoDashboardNameLink;

    public void clickOnDemoDashboard(){
        demoDashboardNameLink.click();
    }
}
