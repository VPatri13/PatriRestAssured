package Steps.registration;

import Steps.registration.model.request.RegistrationRequestBody;
import Steps.registration.model.response.RegistrationResponseBody;
import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class RegistrationSteps {

    @Step("Регистрация. Создать нового пользователя на https://test.hyg-core.ru/register")
    public String registration() {
        Specifications.installSpecification(Specifications.requestSpec(Constants.AUTH_URL), Specifications.responseSpecOk200());

        RegistrationRequestBody registrationRequestBody = new RegistrationRequestBody(Constants.REGISTER_USER_PHONE, Constants.DEVICE_ID);
        RegistrationResponseBody registrationResponseBody = given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.AUTHENTICATION_TOKEN)
                .body(registrationRequestBody)
                .when()
                .post(Constants.ENDPOINT_REGISTRATION )
                .then().log().all()
                .extract().as(RegistrationResponseBody.class);

        Assertions.assertEquals(Constants.REGISTER_USER_PHONE, registrationResponseBody.getPhone());
        Assertions.assertNotNull(registrationResponseBody.getToken());

        return registrationResponseBody.getToken();
    }

}
