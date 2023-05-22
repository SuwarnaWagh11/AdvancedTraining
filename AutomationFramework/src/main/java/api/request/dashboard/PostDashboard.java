package api.request.dashboard;

import api.request.BaseRequest;
import model.dto.PostDashboardDto;

public class PostDashboard extends BaseRequest {

    public PostDashboard(PostDashboardDto dto){
        method = "POST";
        url = "/dashboard";
        body = dto;
    }
}
