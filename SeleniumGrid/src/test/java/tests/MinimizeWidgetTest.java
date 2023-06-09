package tests;

import base.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UtilitiesClass;

import java.time.Duration;

public class MinimizeWidgetTest extends BaseTest {
    private static final Logger LOG = Logger.getLogger(MinimizeWidgetTest.class.getName());

    @Test
    public void minimizing_widget() {
        dashboard.clickOnDemoDashboard();
        WebElement resizableHandle1_draggable = demoDashboard.resizableHandle1_draggable(properties.getProperty("resizableHandle1_draggable"));
        UtilitiesClass.scrollToElement(driver,resizableHandle1_draggable);
        //drag the handler to minimize the size of widget 1
        WebElement presizableHandle1_droppable = demoDashboard.resizableHandle1_droppable(properties.getProperty("presizableHandle1_droppable"));
        Dimension presizableHandle1_dimension = demoDashboard.presizableHandle1_droppable(properties.getProperty("presizableHandle1_droppable"));
        actions.dragAndDrop(resizableHandle1_draggable,presizableHandle1_droppable).build().perform();
        Duration timeoutDuration = Duration.ofSeconds(3000);
        UtilitiesClass.setFluentWait(driver, timeoutDuration, timeoutDuration,By.xpath(properties.getProperty("resizableHandle1_draggable")));
        Dimension updated_presizeOfWidgetDimension = driver.findElement(By.xpath(properties.getProperty("updated_sizeOfWidget1"))).getSize();
        Assert.assertNotEquals(presizableHandle1_dimension, updated_presizeOfWidgetDimension);
    }
}
