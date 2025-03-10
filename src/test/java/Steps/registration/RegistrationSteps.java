package Steps.registration;

import Steps.registration.model.request.PhoneVerifyRequestBody;
import Steps.registration.model.request.RegistrationRequestBody;
import Steps.registration.model.response.PhoneVerifyResponseBody;
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
        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecOk200());

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
        Assertions.assertFalse(registrationResponseBody.getToken().isBlank());

        return registrationResponseBody.getToken();
    }

    @Step("Регистрация. Подтверждаем номер телефона, передав номер СМС на  https://test.hyg-core.ru/phone_verify/{phone}")
    public String phoneVerify(String otp_token) {

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL), Specifications.responseSpecOk200());

        PhoneVerifyRequestBody phoneVerifyRequestBody = new PhoneVerifyRequestBody(Constants.DEVICE_ID, otp_token);

        PhoneVerifyResponseBody phoneVerifyResponseBody = given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.AUTHENTICATION_TOKEN)
                .queryParams("code", Constants.CMC_CODE)
                .body(phoneVerifyRequestBody)
                .when()
                .post(Constants.ENDPOINT_PHONE_VERIFY + Constants.REGISTER_USER_PHONE)
                .then().log().all()
                .extract().as(PhoneVerifyResponseBody.class);

        Assertions.assertNotNull(phoneVerifyResponseBody.getToken());
        Assertions.assertNotNull(phoneVerifyResponseBody.getRefresh_token());
        Assertions.assertNotNull(phoneVerifyResponseBody.getExp());
        Assertions.assertFalse(phoneVerifyResponseBody.getToken().isBlank());
        Assertions.assertFalse(phoneVerifyResponseBody.getRefresh_token().isBlank());

        return phoneVerifyResponseBody.getToken();
    }


}
