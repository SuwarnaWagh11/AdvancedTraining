package alltests.apitest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import controllers.Api;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UniRestApiTest {
    @Test
    public void a_uniRestApiTestGet() throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Api.dashboardController.uniRestApiTestGet();

        assertNotNull(jsonResponse.getBody());
        assertEquals(200, jsonResponse.getStatus());
    }
}
