package api.request.dashboard.putmethod;

import api.request.BaseRequest;
import model.dto.PutDashboardDto;

public class PutDashboard extends BaseRequest {
    public PutDashboard(int id, PutDashboardDto dto){
        super();
        method = "PUT";
        url = "/dashboard/{id}";
        pathparam.put("id",String.valueOf(id));
        body = dto;
    }
}
