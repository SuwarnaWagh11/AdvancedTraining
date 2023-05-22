package model.dto;

import lombok.Data;

@Data
public class PutDashboardDto {
    String name;
    String description;
    boolean isShared;
}
