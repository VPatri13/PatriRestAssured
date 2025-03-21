package steps.panalyses.analysisgroups;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetAnalysisGroups {

    @Step("p-analyses GET: /analysis_groups/")
    public void getAnalysis_groups(String token) {
        String analysis_groups = "/analysis_groups/";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + analysis_groups),
                Specifications.responseSpecOk200());


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get()
                .then().log().all()
                .extract().response();

    }
}
