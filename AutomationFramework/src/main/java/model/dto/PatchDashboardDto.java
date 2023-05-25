package model.dto;

import lombok.Data;

@Data
public class PatchDashboardDto {
    String name;
    String description;
    boolean isShared;
}
