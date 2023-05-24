package alltests.apitest;

import controllers.Api;
import controllers.constants.ErrorCodeConstants;
import controllers.constants.ResponseCodeConstants;
import io.restassured.http.Header;
import model.business.Dashboard;
import model.business.DashboardBuilder;
import model.business.DashboardManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pojo.UpdateRQ;
import pojo.UpdateWidgets;
import pojo.WidgetPosition;
import pojo.WidgetSize;

import java.text.MessageFormat;

import static io.restassured.RestAssured.given;
import static model.enums.DashboardEnums.ERRORCODE;
import static model.enums.DashboardEnums.MESSAGE;
import static org.hamcrest.Matchers.equalTo;

public class DashboardControllerTest {
    private static final Logger LOG = Logger.getLogger(DashboardControllerTest.class.getName());
    @Test
    public void getAllSharedDashboardTest_GET(){
        LOG.info("getAllSharedDashboardTest");
        Api.dashboardController.getAllSharedDashboardLists()
                .statusCode(ResponseCodeConstants.OK);
    }
    @Test
    public void getAllDashboardListTest_GET(){
        LOG.info("getAllDashboardListTest");
       Api.dashboardController.getAllDashboardLists()
                .statusCode(ResponseCodeConstants.OK);
    }
    @Test
    public void getDashboardByIdTest_GET(){
        LOG.info("getDashboardByIdTest");
        Api.dashboardController.getDashboardById(69)
                .statusCode(ResponseCodeConstants.OK);
    }
    @Test
    public void getDashboardByIdThatDoesNotExist_GET(){
        LOG.info("getDashboardByIdThatDoesNotExist_GET");
        Api.dashboardController.getDashboardById(65)
                .statusCode(ErrorCodeConstants.NOT_FOUND)
                .body(ERRORCODE.label,equalTo(ErrorCodeConstants.ERROR_CODE_NOT_FOUND))
                .body(MESSAGE.label,equalTo(ErrorCodeConstants.NOT_FOUND_ERROR_MESSAGE));
    }
    @Test
    public void createNewDashboardByName_POST(){//69,70
        LOG.info("createNewDashboardByName");
        Dashboard dashboard = DashboardManager.createQADashboard();
        Api.dashboardController.createDashboard(dashboard)
                .statusCode(ResponseCodeConstants.CREATED);
    }
    @Test
    public void createNewDashboardWithoutName_POST(){
        LOG.info("createNewDashboardWithoutName_POST");
        Dashboard dashboard = DashboardManager.createQADashboardWithoutName();
        Api.dashboardController.createDashboard(dashboard)
                .statusCode(ErrorCodeConstants.BAD_REQUEST)
                .body(ERRORCODE.label,equalTo(ErrorCodeConstants.ERROR_CODE_BAD_REQUEST))
                .body(MESSAGE.label,equalTo(ErrorCodeConstants.BAD_REQUEST_ERROR_MESSAGE_NAME));
    }
    @Test
    public void createDuplicateDashboard_POST(){
        LOG.info("createDuplicateDashboard_POST");
        Dashboard dashboard = DashboardManager.createQADashboard();
        Api.dashboardController.createDashboard(dashboard)
                .statusCode(ErrorCodeConstants.CONFLICT)
                .body(ERRORCODE.label,equalTo(ErrorCodeConstants.DUPLICATE_DASHBOARD_BAD_REQUEST))
                .body(MESSAGE.label,equalTo(MessageFormat.format(ErrorCodeConstants.BAD_REQUEST_ERROR_MESSAGE_DUPLICATE, dashboard.getName())));
    }
    @Test
    public void deleteDashboardById_DELETE(){
        LOG.info("deleteDashboardById_DELETE");
        Api.dashboardController.deleteDashboardById(82)
                .statusCode(ResponseCodeConstants.OK)
                .body(MESSAGE.label,equalTo(MessageFormat.format(ResponseCodeConstants.DELETED_MESSAGE, 82)));
    }
    @Test
    public void deleteDashboardByIdTHatDoesNotExist_DELETE(){
        LOG.info("deleteDashboardByIdTHatDoesNotExist_DELETE");
        Api.dashboardController.deleteDashboardById(82)
                .statusCode(ErrorCodeConstants.NOT_FOUND)
                .body(ERRORCODE.label,equalTo(ErrorCodeConstants.ERROR_CODE_NOT_FOUND))
                .body(MESSAGE.label,equalTo(MessageFormat.format(ErrorCodeConstants.NOT_FOUND_ERROR_MESSAGE, 82)));
    }
    @Test
    public void updateDashboardNameRQ_UPDATE(){
        LOG.info("updateDashboardNameRQ");
        Dashboard dashboard = DashboardManager.updateDashboard("Dashboard12","Dashboard11 description updated to 12",true);
        Api.dashboardController.updateDashboardById(85, dashboard)
                .statusCode(ResponseCodeConstants.OK);
        /*given().header(new Header("Authorization","Bearer "+"8bb82a7d-a573-419e-9cce-c2419f308802"))
                .contentType("application/json")
                .when()
                .body(dashboard)
                .put("http://localhost:8080/api/v1/AUTOMATIONTESTINGADVANCEDPROGRAM/dashboard/51")
                .then()
                .statusCode(ResponseCodeConstants.OK)
                .extract().response().asPrettyString();*/

    }
    @Test
    public void updateNonExistedDashboard_PUT(){
        LOG.info("updateNonExistedDashboard_PUT");
        Dashboard dashboard = DashboardManager.updateDashboard("Dashboard12","Dashboard11 description updated to 12",true);
        Api.dashboardController.updateDashboardById(77, dashboard)
                .statusCode(ErrorCodeConstants.NOT_FOUND)
                .body(ERRORCODE.label,equalTo(ErrorCodeConstants.ERROR_CODE_NOT_FOUND))
                .body(MESSAGE.label,equalTo(MessageFormat.format(ErrorCodeConstants.NOT_FOUND_ERROR_MESSAGE, 77)));
    }

    @Test
    public void updateNullDashboard_PUT(){
        LOG.info("updateNonExistedDashboard_PUT");
        Dashboard dashboard = DashboardManager.updateDashboard("","",true);
        Api.dashboardController.updateDashboardById(77, dashboard)
                .statusCode(ErrorCodeConstants.BAD_REQUEST)
                .body(ERRORCODE.label,equalTo(ErrorCodeConstants.ERROR_CODE_BAD_REQUEST));
                //.body(MESSAGE.label,equalTo(MessageFormat.format(ErrorCodeConstants.NOT_FOUND_ERROR_MESSAGE, 77)));
    }
    //@Test
    public void updateDashboardRQ_UPDATE(){
        LOG.info("updateDashboardRQ");
        UpdateRQ urq = new UpdateRQ();
        UpdateWidgets[] uw  = new UpdateWidgets[1];
        uw[0] = new UpdateWidgets();
        uw[0].setWidgetId(53);
        uw[0].setWidgetName("LAUNCH STATISTICS AREA");
        uw[0].setShare(true);
        uw[0].setWidgetType("Cumulative trend chart");
        WidgetPosition wp = new WidgetPosition();
        wp.setPositionY(12);
        wp.setPositionX(12);
        uw[0].setWidgetPosition(wp);
        WidgetSize ws = new WidgetSize();
        ws.setHeight(5);
        ws.setWidth(5);
        uw[0].setWidgetSize(ws);
        urq.setDescription("DEMO DASHBOARD 001311");
        urq.setName("QAT Dashboard 001311");
        urq.setShare(true);
        urq.setUpdateWidgets(uw);
        given().header(new Header("Authorization","Bearer "+"8bb82a7d-a573-419e-9cce-c2419f308802"))
                .contentType("application/json")
                .when()
                .body(urq)
                .put("http://localhost:8080/api/v1/AUTOMATIONTESTINGADVANCEDPROGRAM/dashboard/51")
                .then()
                .statusCode(ResponseCodeConstants.OK)
                .extract().response().asPrettyString();
    }

}
