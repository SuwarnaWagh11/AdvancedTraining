package alltests.apitest;

import controllers.Api;
import model.business.Dashboard;
import model.business.DashboardManager;
import pojo.UpdateRQ;
import pojo.UpdateWidgets;
import pojo.WidgetPosition;
import pojo.WidgetSize;
import io.restassured.http.Header;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DashboardControllerTest {

    @Test
    public void getAllSharedDashboardTest(){
        Api.dashboardController.getAllSharedDashboardLists()
                .statusCode(200);
    }
    @Test
    public void getAllDashboardListTest(){
       Api.dashboardController.getAllDashboardLists()
                .statusCode(200);
    }
    @Test
    public void getDashboardByIdTest(){
        Api.dashboardController.getDashboardById(67)
                .statusCode(200);
    }
    @Test
    public void createNewDashboardByName(){//69,70
        Dashboard dashboard = DashboardManager.createQADashboard();
        Api.dashboardController.createDashboard(dashboard)
                .statusCode(201);
    }
    @Test
    public void deleteDashboardById(){//  "message": "Dashboard with ID = '70' successfully deleted."
        Api.dashboardController.deleteDashboardById(73)
                .statusCode(200);
    }
    //@Test
    public void updateDashboardNameRQ(){
        UpdateRQ urq = new UpdateRQ();
        urq.setDescription("new Description");
        urq.setName("new Name");
        urq.setShare(true);
        given().header(new Header("Authorization","Bearer "+"8bb82a7d-a573-419e-9cce-c2419f308802"))
                .contentType("application/json")
                .when()
                .body(urq)
                .put("http://localhost:8080/api/v1/AUTOMATIONTESTINGADVANCEDPROGRAM/dashboard/51")
                .then()
                .statusCode(200)
                .extract().response().asPrettyString();

    }
    //@Test
    public void updateDashboardRQ(){
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
                .statusCode(200)
                .extract().response().asPrettyString();
    }

}
