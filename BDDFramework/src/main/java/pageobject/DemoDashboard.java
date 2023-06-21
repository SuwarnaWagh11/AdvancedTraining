package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Utilities;

import java.util.List;

public class DemoDashboard {

    WebDriver ldriver;
    @FindBy(xpath = "//div[@class='widgets-grid']/div/div")
    List<WebElement> totalWidget;
    @FindBy(xpath = "//div[@class='widgets-grid']")
    WebElement widgetName;
    @FindBy(xpath = "//div[@class='react-grid-layout']/div[1]//div[contains(@class,'launchStatisticsChart')]//span[@data-id='statistics$executions$total']/span[2]")
    WebElement statisticsTotal;
    @FindBy(xpath = "//div[@class='react-grid-layout']/div[1]//div[contains(@class,'launchStatisticsChart')]//span[@data-id='statistics$executions$passed']/span[2]")
    WebElement statisticsPassed;
    @FindBy(xpath = "//div[@class='react-grid-layout']/div[1]//div[contains(@class,'launchStatisticsChart')]//span[@data-id='statistics$executions$failed']/span[2]")
    WebElement statisticsFailed;
    @FindBy(xpath = "//div[@class='react-grid-layout']/div[1]//div[contains(@class,'launchStatisticsChart')]//span[@data-id='statistics$executions$skipped']/span[2]")
    WebElement statisticsSkipped;

    public DemoDashboard(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    public int getTotalWidgetPresetOnDemoDashboard() {
        return totalWidget.size();
    }

    public boolean verifyNamesOfWidgetPresetOnDemoDashboard(String name) {
        Utilities utilities = new Utilities();
        utilities.scrollToElement(ldriver, ldriver.findElement(By.xpath("//*[text()='" + name + "']")));
        return ldriver.findElement(By.xpath("//*[text()='" + name + "']")).isDisplayed();
    }

    public boolean verifyStatisticsExecutionTotalItemIsPresent() {
        return statisticsTotal.isDisplayed();
    }
}
