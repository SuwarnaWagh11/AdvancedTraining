package model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DashboardEnums {

    ERRORCODE("errorCode"),
    MESSAGE("message");
    public final String label;
    private DashboardEnums(String label) {
        this.label = label;
    }
}
