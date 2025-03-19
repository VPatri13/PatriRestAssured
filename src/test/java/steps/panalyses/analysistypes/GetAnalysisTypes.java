package steps.panalyses.analysistypes;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import steps.panalyses.analysistypes.model.response.getanalysistypesbody.AnalysisTypesResponseBody;

import static io.restassured.RestAssured.given;

public class GetAnalysisTypes {

    @Step("p-analyses GET: /analysis_types/")
    public void analysis_types(String token) {
        String analysis_types = "/analysis_types/";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + analysis_types),
                Specifications.responseSpecOk200());


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .when()
                .get()
                .then().log().all()
                .extract().response();

        AnalysisTypesResponseBody analysisTypesResponseBody = response.as(AnalysisTypesResponseBody.class);
    }


}
