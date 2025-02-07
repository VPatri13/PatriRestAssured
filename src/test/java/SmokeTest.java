import deserializer.SuccessLogin;
import deserializer.UserToken;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import requestbody.LoginBody;

import static io.restassured.RestAssured.given;

public class SmokeTest {

    private final static String AUTH_URL = "https://dev.p-auth.hyg-core.ru";
    private final static String DEVICE_ID = "12345678-1234-1234-1234-123456789123";

    private final static String ENDPOINT_LOGIN_PHONE = "/login_phone/{phone}";

    private final static long USER_PHONE = 79000000001L;




    @Test
    public void authorization() {
        Specifications.installSpecification(Specifications.requestSpec(AUTH_URL), Specifications.responseSpecOk200());

        String message = "Verification code has been sent";

        LoginBody loginBody = new LoginBody(DEVICE_ID);
        SuccessLogin successLogin = given()
                .contentType(ContentType.JSON)
                //.pathParam("{phone}", USER_PHONE)
                .body(loginBody)
                .when()
                .post("/login_phone/79000000001")
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assertions.assertTrue(successLogin.isSuccess());
        Assertions.assertEquals(message, successLogin.getMessage());

    }

}
