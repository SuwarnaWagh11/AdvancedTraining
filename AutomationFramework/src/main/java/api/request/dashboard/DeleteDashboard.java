package api.request.dashboard;

import api.request.BaseRequest;

public class DeleteDashboard extends BaseRequest {

    public DeleteDashboard(int id){
        super();
        method = "DELETE";
        url = "/dashboard/{id}";
        pathparam.put("id",String.valueOf(id));
    }
}
