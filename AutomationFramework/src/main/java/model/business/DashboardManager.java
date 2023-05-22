package model.business;

import configuration.FrameworkConfig;

public class DashboardManager {

    public static Dashboard createQADashboard(){
        return new DashboardBuilder()
                .setName("Its time to really")
                .setDescription("sleeep!!! Good Night")
                .setShared(true)
                .build();
    }
}
