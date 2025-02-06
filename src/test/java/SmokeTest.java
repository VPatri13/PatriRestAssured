import deserializer.UserToken;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SmokeTest {

    private final static String AUTH_URL = "https://dev.p-auth.hyg-core.ru/";



    @Test
    public void authorization() {
        Specifications.installSpecification(Specifications.requestSpec(AUTH_URL), Specifications.responseSpecOk200());
        Response response = given()
                .when()
                .contentType(ContentType.JSON)
                .

    }

}
