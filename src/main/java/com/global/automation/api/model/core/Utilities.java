package com.global.automation.api.model.core;

import com.global.automation.api.model.business.DashboardService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Utilities {
    private static final Logger LOGGER = LogManager.getLogger(Utilities.class);
    public void getDashboardName(){
        LOGGER.info("dashboard name");
    }
}
