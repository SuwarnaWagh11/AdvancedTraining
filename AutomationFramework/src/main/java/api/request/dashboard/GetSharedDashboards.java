package api.request.dashboard;

import api.request.BaseRequest;

public class GetSharedDashboards extends BaseRequest {

    public GetSharedDashboards(){
        method = "GET";
        url = "/dashboard/shared";
    }
}
