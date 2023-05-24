package api.request.dashboard;

import api.request.BaseRequest;

public class PatchDashboard extends BaseRequest {
    public PatchDashboard(int id){
        super();
        method = "PATCH";
        url = "/dashboard/{id}";
        pathparam.put("id",String.valueOf(id));
    }
}
