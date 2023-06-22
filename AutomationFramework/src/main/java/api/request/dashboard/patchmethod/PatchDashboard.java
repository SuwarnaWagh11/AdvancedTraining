package api.request.dashboard.patchmethod;

import api.request.BaseRequest;
import model.dto.PatchDashboardDto;

public class PatchDashboard extends BaseRequest {
    public PatchDashboard(int id, PatchDashboardDto dto){
        super();
        method = "PATCH";
        url = "/dashboard/{id}";
        pathparam.put("id",String.valueOf(id));
        body = dto;
    }
}
