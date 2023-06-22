package api.request;

import configuration.FrameworkConfig;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class BaseRequest {

    private static final Logger LOG = Logger.getLogger(BaseRequest.class.getName());

    protected String method;
    protected String url;
    private Properties properties;
    protected Map<String, String> headers = new HashMap<>();
    protected Map<String, String> pathparam = new HashMap<>();
    protected Map<String, String> queryParam = new HashMap<>();

    protected Object body;

    public BaseRequest(){
        try {
            properties = readPropFile();
        } catch (IOException e) {
            LOG.info("readPropFile");
        }
        headers.put("Authorization", "Bearer " + properties.getProperty("token"));
        headers.put("Content-Type", "application/json");
    }

    public ValidatableResponse execute() {
        RequestSpecification request = given().log().all()
                .baseUri(FrameworkConfig.BASE_URI)
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
    public Properties readPropFile() throws IOException {
        FileReader read = null;
        try {
            read = new FileReader("C:\\AdvancedTraining\\AutomationFramework\\src\\test\\resources\\config.properties");
            properties = new Properties();
            properties.load(read);
        } catch (NullPointerException x) {
            LOG.info("NullPointerException");
        }catch (FileNotFoundException f) {
            LOG.info("FileNotFoundException");
        } catch (IOException e) {
            LOG.info("IOException");
        }if(read != null){
            read.close();
        }
        return properties;
    }
}