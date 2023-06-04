package model.enums;

public enum DashboardEnums {
    ERRORCODE("errorCode"),
    ERROR("error"),
    STATUS("status"),
    MESSAGE("message");
    public final String label;
    private DashboardEnums(String label) {
        this.label = label;
    }
}
