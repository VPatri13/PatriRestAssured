package steps.pauth;

import steps.pauth.model.request.RefreshRequestBody;
import steps.pauth.model.response.RefreshResponseBody;
import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class Refresh {

    @Step("p-auth POST: /refresh")
    public void refresh(String refresh_token) {
        String refresh = "/refresh";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + refresh),
                Specifications.responseSpecOk200());

        RefreshRequestBody refreshRequestBody = new RefreshRequestBody(refresh_token);

         Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.AUTHENTICATION_TOKEN)
                .body(refreshRequestBody)
                .when()
                .post()
                .then().log().all()
                .extract().response();

        RefreshResponseBody refreshResponseBody = response.as(RefreshResponseBody.class);

        Assertions.assertNotNull(refreshResponseBody.getToken());
        Assertions.assertNotNull(refreshResponseBody.getRefresh_token());
        Assertions.assertNotNull(refreshResponseBody.getExp());
        Assertions.assertFalse(refreshResponseBody.getToken().isBlank());
        Assertions.assertFalse(refreshResponseBody.getRefresh_token().isBlank());
    }
}
