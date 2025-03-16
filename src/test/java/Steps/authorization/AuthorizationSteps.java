package Steps.authorization;

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

    @Step("Вход. Отправка номера телефона на \"/login_phone/{phone}\" для получения СМС")
    public String login_phoneWithoutSMS() {
        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL
                + Constants.ENDPOINT_LOGIN_PHONE + Constants.USER_PHONE), Specifications.responseSpecOk200());

        String message = "Verification code has been sent";

        LoginBody loginBody = new LoginBody(Constants.DEVICE_ID);
        SuccessLogin successLogin = given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.AUTHENTICATION_TOKEN)
                //.pathParam("{phone}", USER_PHONE)
                .body(loginBody)
                .when()
                .post()
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assertions.assertTrue(successLogin.isSuccess());
        Assertions.assertEquals(message, successLogin.getMessage());

        return successLogin.getOtp_token();
    }

    @Step("Вход. Отправка номера телефона и СМС \"/login_phone/{phone}\" и получение токенов")
    public UserToken login_phoneWithSMS(String otp_token) {
        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL
                + Constants.ENDPOINT_LOGIN_PHONE + Constants.USER_PHONE), Specifications.responseSpecOk200());
        LoginBodyWithOtpToken loginBodyWithOtpToken = new LoginBodyWithOtpToken(Constants.DEVICE_ID, otp_token);
        UserToken userToken = given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.AUTHENTICATION_TOKEN)
                .queryParams("code", Constants.CMC_CODE)
                .body(loginBodyWithOtpToken)
                .post()
                .then().log().all()
                .extract().as(UserToken.class);

        Assertions.assertNotNull(userToken.getToken());
        Assertions.assertNotNull(userToken.getRefresh_token());
        Assertions.assertNotNull(userToken.getExp());
        Assertions.assertFalse(userToken.getToken().isBlank());
        Assertions.assertFalse(userToken.getRefresh_token().isBlank());

        return userToken;
    }


}
