package testkits.environment;
import deserializer.SuccessLogin;
import deserializer.UserToken;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import requestbody.LoginBody;
import requestbody.LoginBodyWithOtpToken;

import static io.restassured.RestAssured.given;

public abstract class TestSteps {

    private final static String AUTH_URL = "https://test.hyg-core.ru";
    private final static String DEVICE_ID = "12345678-1234-1234-1234-123456789123";
    private final static String AUTHENTICATION_TOKEN = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6Ijk2MDlkOGZlLWFjN2It" +
            "NDdiZC05NmQ0LTY1MTk1NjExMzg1MCIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoyLCJkZXZpY2VfaWQiOiIxMjM0NTYtMTIzN" +
            "C0xMjM0LTEyMzQtMTIzNDU2Nzg5MTIzIiwibmFtZSI6InZlcm9uaWthMTQiLCJ0eXBlIjoidXNlciIsInN1YiI6ImZyb250Iiw" +
            "iaWF0IjoxNzM2OTYzMDU2LCJleHAiOjE3NjgwNjcwNTZ9.ILLX7eq1No3GnoK7fqGdce-BjDugbwI8RLV61BJzRrFMGMwUDI3R" +
            "4JzLwRoPSvxgAiTnPW_omt4mcJCkMt60zWHFIb3wma92uWQrEz02EIHcvQWD9wtihkjPRkYDaEo3MGlafsekMAn5pPpdIe6xnz" +
            "6ZRwJY-kUV3M_rT9jhbQ4uQM-jEYMdOx1vFVWu5H3Loh3S2nMspbrlb5qgWb5gRPF8ERincd9ZwHpr-zAKVKhYe6JRfVp6F3VK" +
            "2DrAm_WJ4P_jgI4vDfPi0HiVUviMDbIQQbagpuES_nKK7imdb59z12xFQC1o2juAHJXirqYXkrjpjs1IaLxA5itGrsaRGgO9fh" +
            "evkCf0UZ1oCbUn174Kh9Erzhb4nYgLiw4ezOJ6Jd_pBA13POE6HODO26JVp7bROlZnMIn3egiuoq24d4HINAowZ4jiZQeQrge3" +
            "jP143VDIMzXOAo-MKqCu5Sg72bAET5bjjU-Mw7_syU3W1b84R5harJzOzovxuvXkgmjh6I8h6H33W0zZs1QvHKmhUUXk91YqlVL" +
            "A1mUNLGlp8CaFgZylV5ib6PxubrG6LsdN6-aKCQ7QdK33qqBMPLp3rDL9stkBNZBji8znsa1Q6-ocuK6mjB3iykvrXN4rVE6M4h" +
            "iLYHPxbXemC1SpkLIo5QOmxr4SqUQWt16U8N2Ft1A";
    private final static String ENDPOINT_LOGIN_PHONE = "/login_phone/";
    private final static String ENDPOINT_REGISTRATION = "/register";

    private final static String REGISTER_USER_PHONE = "79000070001";
    private final static String USER_PHONE = "79000000001";
    private final static String CMC_CODE = "1234";

    @Step("Регистрация. Создать нового пользователя на https://test.hyg-core.ru/register")
    public String registration() {
        Specifications.installSpecification(Specifications.requestSpec(AUTH_URL), Specifications.responseSpecOk200());


        return
    }


    @Step("Вход. Отправка номера телефона на \"/login_phone/{phone}\" для получения СМС")
    public String login_phoneWithoutSMS() {
        Specifications.installSpecification(Specifications.requestSpec(AUTH_URL), Specifications.responseSpecOk200());

        String message = "Verification code has been sent";

        LoginBody loginBody = new LoginBody(DEVICE_ID);
        SuccessLogin successLogin = given()
                .contentType(ContentType.JSON)
                .header("Authorization", AUTHENTICATION_TOKEN)
                //.pathParam("{phone}", USER_PHONE)
                .body(loginBody)
                .when()
                .post(ENDPOINT_LOGIN_PHONE + USER_PHONE)
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assertions.assertTrue(successLogin.isSuccess());
        Assertions.assertEquals(message, successLogin.getMessage());

        return successLogin.getOtp_token();
    }

    @Step("Вход. Отправка номера телефона и СМС \"/login_phone/{phone}\" и получение токенов")
    public void login_phoneWithSMS() {
        Specifications.installSpecification(Specifications.requestSpec(AUTH_URL), Specifications.responseSpecOk200());
        String otp_token = login_phoneWithoutSMS();
        LoginBodyWithOtpToken loginBodyWithOtpToken = new LoginBodyWithOtpToken(DEVICE_ID, otp_token);
        UserToken userToken = given()
                .contentType(ContentType.JSON)
                .header("Authorization", AUTHENTICATION_TOKEN)
                .queryParams("code", CMC_CODE)
                .body(loginBodyWithOtpToken)
                .post(ENDPOINT_LOGIN_PHONE + USER_PHONE)
                .then().log().all()
                .extract().as(UserToken.class);

        Assertions.assertNotNull(userToken.getToken());
        Assertions.assertNotNull(userToken.getRefresh_token());
        Assertions.assertNotNull(userToken.getExp());

    }


}
