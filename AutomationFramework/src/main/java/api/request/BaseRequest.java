package api.request;

import configuration.FrameworkConfig;
import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseRequest {
    protected String method;
    protected String url;

    protected Map<String, String> headers = new HashMap<>();
    protected Map<String, String> pathparam = new HashMap<>();
    protected Map<String, String> queryParam = new HashMap<>();

    protected Object body;

    public BaseRequest(){
        headers.put("Authorization", "Bearer " + FrameworkConfig.token);
        headers.put("Content-Type", "application/json");
    }

    public ValidatableResponse execute() {
        RequestSpecification request = given().log().all()
                .baseUri(FrameworkConfig.baseUrl)
                .headers(headers)
                .pathParams(pathparam)
                .queryParams(queryParam);
        if(body != null){
            request.body(body);
        }
        return request.when()
                .request(method, url)
                .then().log().all();
    }
}
