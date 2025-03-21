package steps.panalyses.analysisgroups;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetAnalysisGroupsAnalysisGroupIdAnalysisTypes {

    @Step("p-analyses GET: /analysis_groups/{analysis_group_id}/analysis_types/")
    public void getAnalysisGroupsAnalysisGroupIdAnalysisTypes(String token) {
        String analysis_groups = "/analysis_groups/";
        int analysis_group_id = 1;
        String analysis_types = "/analysis_types/";


        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL +
                        analysis_groups + analysis_group_id + analysis_types), Specifications.responseSpecOk200());


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get()
                .then().log().all()
                .extract().response();

    }
}
