package Steps.authorization;
import Steps.registration.model.response.RegistrationResponseBody;
import Steps.authorization.model.response.SuccessLogin;
import Steps.authorization.model.response.UserToken;
import environment.Constants;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import Steps.authorization.model.request.LoginBody;
import Steps.authorization.model.request.LoginBodyWithOtpToken;
import environment.Specifications;

import static io.restassured.RestAssured.given;

public class AuthorizationSteps {


//    @Step("Регистрация. Создать нового пользователя на https://test.hyg-core.ru/register")
//    public String registration() {
//        Specifications.installSpecification(Specifications.requestSpec(Constants.AUTH_URL), Specifications.responseSpecOk200());
//
//        RegistrationRequestBody registrationRequestBody = new RegistrationRequestBody(Constants.REGISTER_USER_PHONE, Constants.DEVICE_ID);
//        RegistrationResponseBody registrationResponseBody = given()
//                .contentType(ContentType.JSON)
//                .header("Authorization", Constants.AUTHENTICATION_TOKEN)
//                .body(registrationRequestBody)
//                .when()
//                .post(Constants.ENDPOINT_REGISTRATION )
//                .then().log().all()
//                .extract().as(RegistrationResponseBody.class);
//
//        Assertions.assertEquals(Constants.REGISTER_USER_PHONE, registrationResponseBody.getPhone());
//        Assertions.assertNotNull(registrationResponseBody.getToken());
//
//        return registrationResponseBody.getToken();
//    }
//



    @Step("Вход. Отправка номера телефона на \"/login_phone/{phone}\" для получения СМС")
    public String login_phoneWithoutSMS() {
        Specifications.installSpecification(Specifications.requestSpec(Constants.AUTH_URL), Specifications.responseSpecOk200());

        String message = "Verification code has been sent";

        LoginBody loginBody = new LoginBody(Constants.DEVICE_ID);
        SuccessLogin successLogin = given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.AUTHENTICATION_TOKEN)
                //.pathParam("{phone}", USER_PHONE)
                .body(loginBody)
                .when()
                .post(Constants.ENDPOINT_LOGIN_PHONE + Constants.USER_PHONE)
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assertions.assertTrue(successLogin.isSuccess());
        Assertions.assertEquals(message, successLogin.getMessage());

        return successLogin.getOtp_token();
    }

    @Step("Вход. Отправка номера телефона и СМС \"/login_phone/{phone}\" и получение токенов")
    public void login_phoneWithSMS() {
        Specifications.installSpecification(Specifications.requestSpec(Constants.AUTH_URL), Specifications.responseSpecOk200());
        String otp_token = login_phoneWithoutSMS();
        LoginBodyWithOtpToken loginBodyWithOtpToken = new LoginBodyWithOtpToken(Constants.DEVICE_ID, otp_token);
        UserToken userToken = given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.AUTHENTICATION_TOKEN)
                .queryParams("code", Constants.CMC_CODE)
                .body(loginBodyWithOtpToken)
                .post(Constants.ENDPOINT_LOGIN_PHONE + Constants.USER_PHONE)
                .then().log().all()
                .extract().as(UserToken.class);

        Assertions.assertNotNull(userToken.getToken());
        Assertions.assertNotNull(userToken.getRefresh_token());
        Assertions.assertNotNull(userToken.getExp());

    }


}
