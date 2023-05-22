package model.business;

public class DashboardBuilder {

    String name;
    String description;
    boolean isShared;

    private Dashboard dashboard;

    public DashboardBuilder(){
        dashboard = new Dashboard();
    }

    public Dashboard build(){
        return dashboard;
    }
    public DashboardBuilder setName(String name) {
        dashboard.setName(name);
        return this;
    }

    public DashboardBuilder setDescription(String description) {
        dashboard.setDescription(description);
        return this;
    }

    public DashboardBuilder setShared(boolean shared) {
        dashboard.setShared(shared);
        return this;
    }

}
