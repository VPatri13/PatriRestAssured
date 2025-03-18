package steps.pauth;

import steps.pauth.model.response.VerifyTokenResponseBody;
import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class VerifyToken {

    @Step("p-auth POST: /verify_token/")
    public void verify_token(String token) {
        String verify_token = "/verify_token";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + verify_token),
                Specifications.responseSpecOk200());


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .post()
                .then().log().all()
                .extract().response();

        VerifyTokenResponseBody verifyTokenResponseBody = response.as(VerifyTokenResponseBody.class);


        Assertions.assertNotNull(verifyTokenResponseBody.getUsername());
        // Тут допиши проверки

    }
}
