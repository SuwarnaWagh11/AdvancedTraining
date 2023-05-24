package controllers;

import api.request.dashboard.*;
import model.dto.PostDashboardDto;
import model.business.Dashboard;
import model.dto.PutDashboardDto;
import model.mappers.DashboardMapper;
import io.restassured.response.ValidatableResponse;

public class DashboardController {

    public ValidatableResponse getAllSharedDashboardLists(){
        return new GetSharedDashboards().execute();
    }
    public ValidatableResponse getAllDashboardLists(){
        return new GetDashboards().execute();

    }
    public ValidatableResponse getDashboardById(int dashboardId){
        return new GetDashboard(dashboardId).execute();

    }
    public ValidatableResponse createDashboard(Dashboard dashboardDto){
        PostDashboardDto dto = DashboardMapper.map(dashboardDto, PostDashboardDto.class);
        return new PostDashboard(dto).execute();
    }
    public ValidatableResponse deleteDashboardById(int dashboardId){
        return new DeleteDashboard(dashboardId).execute();
    }

    public ValidatableResponse updateDashboardById(int dashboardId,Dashboard dashboardDto){
        PutDashboardDto dto = DashboardMapper.map(dashboardDto, PutDashboardDto.class);
        return new PutDashboard(dashboardId, dto).execute();
    }

    public ValidatableResponse patchDashboardById(int dashboardId){
        return new PatchDashboard(dashboardId).execute();
    }
}
