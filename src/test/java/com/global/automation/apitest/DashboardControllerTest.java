package com.global.automation.apitest;

import com.global.automation.api.pojo.CreateDashboard;
import io.restassured.http.Header;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DashboardControllerTest {

    @Test
    public void getAllSharedDashboard(){
        given()
                .header(new Header("Authorization","Bearer "+"8bb82a7d-a573-419e-9cce-c2419f308802")).
                when()
                .get("http://localhost:8080/api/v1/AUTOMATIONTESTINGADVANCEDPROGRAM/dashboard/shared")
                .then()
                .statusCode(200)
                .extract()
                .response().
                asPrettyString();
    }
    @Test
    public void getAllDashboardList(){
        given()
                .header(new Header("Authorization","Bearer "+"8bb82a7d-a573-419e-9cce-c2419f308802")).
        when()
                .get("http://localhost:8080/api/v1/AUTOMATIONTESTINGADVANCEDPROGRAM/dashboard")
        .then()
                .statusCode(200)
                .extract().response().asPrettyString();
    }
    @Test
    public void getDashboardById(){
        given()
                .header(new Header("Authorization","Bearer "+"8bb82a7d-a573-419e-9cce-c2419f308802")).
                when()
                .get("http://localhost:8080/api/v1/AUTOMATIONTESTINGADVANCEDPROGRAM/dashboard/28")
                .then()
                .statusCode(200);
    }
    @Test
    public void createNewDashboardByName(){
        CreateDashboard cd = new CreateDashboard("Suwarna wagh A03","QA Dashboard 103",false);
        given()
                .header(new Header("Authorization","Bearer "+"8bb82a7d-a573-419e-9cce-c2419f308802")).
                contentType("application/json").
                       // .pathParam("projectName", "AUTOMATIONTESTINGADVANCEDPROGRAM").
                when()
                .body(cd)
                .post("http://localhost:8080/api/v1/AUTOMATIONTESTINGADVANCEDPROGRAM/dashboard")
                .then()
                .statusCode(201);
    }
    @Test
    public void deleteDashboardById(){
        given()
                .header(new Header("Authorization","Bearer "+"8bb82a7d-a573-419e-9cce-c2419f308802")).
                when()
                .delete("http://localhost:8080/api/v1/AUTOMATIONTESTINGADVANCEDPROGRAM/dashboard/49")
                .then()
                .statusCode(200);
    }
}
