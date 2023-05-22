package api.request.dashboard;

import api.request.BaseRequest;

public class GetDashboards extends BaseRequest {

    public GetDashboards(){
        method = "GET";
        url = "/dashboard";
    }


}
