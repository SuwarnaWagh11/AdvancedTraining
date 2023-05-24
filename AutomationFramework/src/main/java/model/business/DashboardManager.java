package model.business;

import configuration.FrameworkConfig;

public class DashboardManager {

    public static Dashboard createQADashboard(){
        return new DashboardBuilder()
                .setName("Dashboard11")
                .setDescription("Dashboard11 description ")
                .setShared(true)
                .build();
    }

    public static Dashboard createQADashboardWithoutName(){
        return new DashboardBuilder()
                .setDescription("And Its already 24th May")
                .setShared(true)
                .build();
    }

    public static Dashboard updateDashboard(String name, String desc, boolean shared){
        return new DashboardBuilder()
                .setName(name)
                .setDescription(desc)
                .setShared(shared)
                .build();
    }
}
