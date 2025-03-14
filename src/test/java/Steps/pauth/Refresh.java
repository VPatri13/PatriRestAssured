package Steps.pauth;

import Steps.authorization.model.response.UserToken;
import Steps.pauth.model.request.RefreshRequestBody;
import Steps.pauth.model.response.RefreshResponseBody;
import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Refresh {

    @Step("p-auth POST: /refresh")
    public void refresh(String refresh_token) {
        String refresh = "/refresh";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + refresh),
                Specifications.responseSpecOk200());

        RefreshRequestBody refreshRequestBody = new RefreshRequestBody(refresh_token);

        RefreshResponseBody refreshResponseBody = given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.AUTHENTICATION_TOKEN)
                .body(refreshRequestBody)
                .post()
                .then().log().all()
                .extract().as(RefreshResponseBody.class);


    }
}
