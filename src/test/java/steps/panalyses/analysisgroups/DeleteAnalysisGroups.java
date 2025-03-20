package steps.panalyses.analysisgroups;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteAnalysisGroups {

    @Step("p-analyses DELETE: /analysis_groups/{group_id}")
    public void deleteAnalysis_groups(String token, int id) {
        String analysis_groups = "/analysis_groups/";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + analysis_groups + id),
                Specifications.responseSpecOk204());


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .delete()
                .then().log().all()
                .extract().response();

    }
}
