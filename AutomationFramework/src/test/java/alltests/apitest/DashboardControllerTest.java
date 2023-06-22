package alltests.apitest;

import controllers.Api;
import controllers.constants.ErrorCodeConstants;
import controllers.constants.ResponseCodeConstants;
import io.restassured.path.json.JsonPath;
import model.business.Dashboard;
import model.business.DashboardManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.text.MessageFormat;

import static model.enums.DashboardEnums.*;
import static org.hamcrest.Matchers.equalTo;

public class DashboardControllerTest {
    private static final Logger LOG = Logger.getLogger(DashboardControllerTest.class.getName());
    public int dashboardId;
    String response;
    JsonPath jsonPath;

    @Test
    public void a_getAllSharedDashboardTest_GET() {
        LOG.info("a_getAllSharedDashboardTest_GET");
        Api.dashboardController.getAllSharedDashboardLists()
                .statusCode(ResponseCodeConstants.OK);
    }

    @Test
    public void b_getAllDashboardListTest_GET() {
        LOG.info("b_getAllDashboardListTest_GET");
        Api.dashboardController.getAllDashboardLists()
                .statusCode(ResponseCodeConstants.OK);
    }

    @Test
    public void c_getDashboardByIdTest_GET() {
        LOG.info("c_getDashboardByIdTest_GET");
        Api.dashboardController.getDashboardById(67)
                .statusCode(ResponseCodeConstants.OK);
    }

    @Test
    public void d_getDashboardByIdThatDoesNotExist_GET() {
        LOG.info("getDashboardByIdThatDoesNotExist_GET");
        Api.dashboardController.getDashboardById(dashboardId)
                .statusCode(ErrorCodeConstants.NOT_FOUND)
                .body(ERRORCODE.label, equalTo(ErrorCodeConstants.ERROR_CODE_NOT_FOUND))
                .body(MESSAGE.label, equalTo(MessageFormat.format(ErrorCodeConstants.NOT_FOUND_ERROR_MESSAGE, dashboardId)));
    }

    @Test
    public void f_createNewDashboardByName_POST() {//69,70
        LOG.info("f_createNewDashboardByName_POST");
        Dashboard dashboard = DashboardManager.createQADashboard("QAT Dashboard A02", "QAT Dashboard description A02", true);
        response = Api.dashboardController.createDashboard(dashboard)
                .statusCode(ResponseCodeConstants.CREATED).extract().response().asString();
        // String resp = response.asString();
        jsonPath = new JsonPath(response);
        dashboardId = jsonPath.get("id");
    }

    @Test
    public void e_createNewDashboardWithoutName_POST() {
        LOG.info("e_createNewDashboardWithoutName_POST");
        Dashboard dashboard = DashboardManager.createQADashboardWithoutName();
        Api.dashboardController.createDashboard(dashboard)
                .statusCode(ErrorCodeConstants.BAD_REQUEST)
                .body(ERRORCODE.label, equalTo(ErrorCodeConstants.ERROR_CODE_BAD_REQUEST))
                .body(MESSAGE.label, equalTo(ErrorCodeConstants.BAD_REQUEST_ERROR_MESSAGE_NAME));
    }

    @Test
    public void g_createDuplicateDashboard_POST() {
        LOG.info("g_createDuplicateDashboard_POST");
        Dashboard dashboard = DashboardManager.createQADashboard("QAT Dashboard A02", "QAT Dashboard description A02", true);
        Api.dashboardController.createDashboard(dashboard)
                .statusCode(ErrorCodeConstants.CONFLICT)
                .body(ERRORCODE.label, equalTo(ErrorCodeConstants.DUPLICATE_DASHBOARD_BAD_REQUEST))
                .body(MESSAGE.label, equalTo(MessageFormat.format(ErrorCodeConstants.BAD_REQUEST_ERROR_MESSAGE_DUPLICATE, dashboard.getName())));
    }

    @Test
    public void h_updateDashboardNameRQ_UPDATE() {
        LOG.info("h_updateDashboardNameRQ_UPDATE");
        Dashboard dashboard = DashboardManager.updateDashboard("Updated QAT Dashboard A02 to A03", "Updated Dashboard A02 description updated to A03", true);
        Api.dashboardController.updateDashboardById(dashboardId, dashboard)
                .statusCode(ResponseCodeConstants.OK);
    }
    @Test
    public void i_updateDashboardNameRQ_PATCH() {
        LOG.info("i_updateDashboardNameRQ_PATCH");
        Dashboard dashboard = DashboardManager.updateDashboardNameOnly("Updated QAT Dashboard A03 to A04");
        Api.dashboardController.patchDashboardById(dashboardId, dashboard)
                .statusCode(ErrorCodeConstants.METHOD_NOT_ALLOWED)
                .body(ERROR.label, equalTo(ErrorCodeConstants.METHOD_NOT_ALLOWED_ERROR))
                .body(STATUS.label, equalTo(ErrorCodeConstants.METHOD_NOT_ALLOWED));
    }
    @Test
    public void j_updateDashboardWithNull_PATCH() {
        LOG.info("j_updateDashboardWithNull_PATCH");
        Dashboard dashboard = DashboardManager.updateDashboardNameOnly("");
        Api.dashboardController.patchDashboardById(dashboardId, dashboard)
                .statusCode(ErrorCodeConstants.METHOD_NOT_ALLOWED)
                .body(ERROR.label, equalTo(ErrorCodeConstants.METHOD_NOT_ALLOWED_ERROR))
                .body(STATUS.label, equalTo(ErrorCodeConstants.METHOD_NOT_ALLOWED));
    }
    @Test
    public void k_deleteDashboardById_DELETE() {
        LOG.info("k_deleteDashboardById_DELETE");
        Api.dashboardController.deleteDashboardById(dashboardId)
                .statusCode(ResponseCodeConstants.OK)
                .body(MESSAGE.label, equalTo(MessageFormat.format(ResponseCodeConstants.DELETED_MESSAGE, dashboardId)));
    }

    @Test
    public void l_deleteDashboardByIdThatDoesNotExist_DELETE() {
        LOG.info("l_deleteDashboardByIdThatDoesNotExist_DELETE");
        Api.dashboardController.deleteDashboardById(dashboardId)
                .statusCode(ErrorCodeConstants.NOT_FOUND)
                .body(ERRORCODE.label, equalTo(ErrorCodeConstants.ERROR_CODE_NOT_FOUND))
                .body(MESSAGE.label, equalTo(MessageFormat.format(ErrorCodeConstants.NOT_FOUND_ERROR_MESSAGE, dashboardId)));
    }

    @Test
    public void m_updateNonExistedDashboard_PUT() {
        LOG.info("m_updateNonExistedDashboard_PUT");
        Dashboard dashboard = DashboardManager.updateDashboard("Dashboard12", "Dashboard11 description updated to 12", true);
        Api.dashboardController.updateDashboardById(dashboardId, dashboard)
                .statusCode(ErrorCodeConstants.NOT_FOUND)
                .body(ERRORCODE.label, equalTo(ErrorCodeConstants.ERROR_CODE_NOT_FOUND))
                .body(MESSAGE.label, equalTo(MessageFormat.format(ErrorCodeConstants.NOT_FOUND_ERROR_MESSAGE, dashboardId)));
    }

    @Test
    public void m_updateNullDashboard_PUT() {
        LOG.info("m_updateNullDashboard_PUT");
        Dashboard dashboard = DashboardManager.updateDashboard("", "", true);
        Api.dashboardController.updateDashboardById(69, dashboard)
                .statusCode(ErrorCodeConstants.BAD_REQUEST)
                .body(ERRORCODE.label, equalTo(ErrorCodeConstants.ERROR_CODE_BAD_REQUEST));
    }
}