package com.global.automation.api.model.business;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DashboardService {
    private static final Logger LOGGER = LogManager.getLogger(DashboardService.class);
    public void dashboardGet(){
        LOGGER.info("Get API");
    }
}
