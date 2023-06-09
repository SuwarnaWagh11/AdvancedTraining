package tests;

import base.BaseTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MovableWidget extends BaseTest {
    private static final Logger LOG = Logger.getLogger(MovableWidget.class.getName());
    @Test
    public void automaticMovableWidgets() {
        dashboard.clickOnDemoDashboard();
        //locate widget 2 and get it's location
        WebElement widget_2 = demoDashboard.widget2(properties.getProperty("widget_2"));
        Point before_point =  demoDashboard.widget2Location(properties.getProperty("widget_2"));
        //locate the handler to resize/to drag of widget 1
        WebElement resizableHandle1_draggable = demoDashboard.resizableHandle1_draggable(properties.getProperty("resizableHandle1_draggable"));
        //locate the location to drop widget 1 handler
        WebElement resizableHandle1_droppable = demoDashboard.resizableHandle1_droppable(properties.getProperty("resizableHandle1_droppable"));
        //drag and drop handler od widget1 to resize it
        actions.dragAndDrop(resizableHandle1_draggable,resizableHandle1_droppable).build().perform();
        //verify that widget 2 is relocated to and not preset to the previous location
        Point after_point = demoDashboard.widget2Location(properties.getProperty("widget_2"));
        Assert.assertNotEquals(before_point, after_point);
    }
}
