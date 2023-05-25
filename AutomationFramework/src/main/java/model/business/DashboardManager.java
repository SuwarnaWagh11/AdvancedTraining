package model.business;

import configuration.FrameworkConfig;

public class DashboardManager {

    public static Dashboard createQADashboard(String name, String desc, boolean shared){
        return new DashboardBuilder()
                .setName(name)
                .setDescription(desc)
                .setShared(shared)
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
    public static Dashboard updateDashboardNameOnly(String name){
        return new DashboardBuilder()
                .setName(name)
                .build();
    }
}
