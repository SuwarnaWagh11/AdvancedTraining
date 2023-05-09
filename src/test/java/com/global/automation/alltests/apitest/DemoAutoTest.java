package com.global.automation.alltests.apitest;

import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class DemoAutoTest {
    private static final Logger LOGGER = LogManager.getLogger(DemoAutoTest.class);
    public static final String screenshot_file_path = "screenshot/demoScreenshoot.jpg";
    @Test
    public void demoTest() throws IOException {
        String rp_message = "test message for Report Portal";
        ReportPortalMessage message = new ReportPortalMessage(new File(screenshot_file_path), rp_message);
        LOGGER.info(message);
        Assert.assertTrue(true);
    }
}
