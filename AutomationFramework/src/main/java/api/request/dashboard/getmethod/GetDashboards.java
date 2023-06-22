package api.request.dashboard.getmethod;

import api.request.BaseRequest;

public class GetDashboards extends BaseRequest {

    public GetDashboards(){
        method = "GET";
        url = "/dashboard";
    }


}
