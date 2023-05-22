package api.request.dashboard;

import api.request.BaseRequest;

public class GetDashboard extends BaseRequest {

    public GetDashboard(int id){
        super();
        method = "GET";
        url = "/dashboard/{id}";
        pathparam.put("id",String.valueOf(id));
    }


}
