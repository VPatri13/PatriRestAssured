package steps.pauth;

import steps.pauth.model.request.AdminUserLoginRequestBody;
import steps.pauth.model.response.AdminUserLoginResponseBody;
import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class AdminUserLogin {
    @Step("p-auth POST: /admin_user/login")
    public void admin_userLogin() {
        String admin_userLogin = "/admin_user/login";
        String username = "qa";
        String password = "admin12345hhkk";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + admin_userLogin),
                Specifications.responseSpecOk200());

        AdminUserLoginRequestBody adminUserLoginRequestBody = new AdminUserLoginRequestBody(password, username);

        Response response = given()
                .contentType(ContentType.JSON)
                .body(adminUserLoginRequestBody)
                .post()
                .then().log().all()
                .extract().response();

        AdminUserLoginResponseBody adminUserLoginResponseBody = response.as(AdminUserLoginResponseBody.class);

        Assertions.assertNotNull(adminUserLoginResponseBody.getToken());
        Assertions.assertNotNull(adminUserLoginResponseBody.getRefresh_token());
        Assertions.assertNotNull(adminUserLoginResponseBody.getExp());
        Assertions.assertFalse(adminUserLoginResponseBody.getToken().isBlank());
        Assertions.assertFalse(adminUserLoginResponseBody.getRefresh_token().isBlank());

    }
}