package steps.panalyses.analysistypes;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetAnalysisTypesAnalysisTypeIdLabAnalyses {

    @Step("p-analyses GET: /analysis_types/{analysis_type_id}/lab_analyses/")
    public void getAnalysisTypesAnalysisTypeIdLabAnalyses(String token) {
        String analysis_types = "/analysis_types/";
        String lab_analyses = "/lab_analyses/";
        int analysis_type_id = 1;

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL
                        + analysis_types + analysis_type_id + lab_analyses), Specifications.responseSpecOk200());


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get()
                .then().log().all()
                .extract().response();
        }

}
