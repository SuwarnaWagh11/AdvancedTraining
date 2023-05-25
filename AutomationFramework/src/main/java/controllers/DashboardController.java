package controllers;

import api.request.dashboard.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import configuration.FrameworkConfig;
import model.dto.PatchDashboardDto;
import model.dto.PostDashboardDto;
import model.business.Dashboard;
import model.dto.PutDashboardDto;
import model.mappers.DashboardMapper;
import io.restassured.response.ValidatableResponse;

public class DashboardController {

    public HttpResponse<JsonNode> uniRestApiTestGet() throws UnirestException {
        return Unirest.get(FrameworkConfig.baseUrl+"/dashboard/67")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 8bb82a7d-a573-419e-9cce-c2419f308802")
                .asJson();
    }
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

    public ValidatableResponse patchDashboardById(int dashboardId, Dashboard dashboardDto){
        PatchDashboardDto dto = DashboardMapper.map(dashboardDto, PatchDashboardDto.class);
        return new PatchDashboard(dashboardId, dto).execute();
    }
}
