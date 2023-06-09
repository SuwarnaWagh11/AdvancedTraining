package tests;

import base.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MaximizeWidgetTest extends BaseTest {
    private static final Logger LOG = Logger.getLogger(MaximizeWidgetTest.class.getName());

    @Test
    public void maximizing_widget() {
        dashboard.clickOnDemoDashboard();
        //get the size of widget1
        Dimension sizeOfWidget1 = demoDashboard.getSizeOfWidget1(properties.getProperty("sizeOfWidget1"));
        //locate the handler to resize/to drag of widget 1
        WebElement resizableHandle1_draggable = demoDashboard.resizableHandle1_draggable(properties.getProperty("resizableHandle1_draggable"));
        //locate the location to drop widget 1 handler
        WebElement resizableHandle1_droppable = demoDashboard.resizableHandle1_droppable(properties.getProperty("resizableHandle1_droppable"));
        //drag and drop handler od widget1 to resize it
        actions.dragAndDrop(resizableHandle1_draggable,resizableHandle1_droppable).build().perform();
        //get the size of widget1 after resizing
        Dimension updated_sizeOfWidget1 = demoDashboard.updated_sizeOfWidget1(properties.getProperty("updated_sizeOfWidget1"));
        Assert.assertNotEquals(sizeOfWidget1, updated_sizeOfWidget1);
    }


}
