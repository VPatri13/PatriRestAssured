package steps.panalyses.analysistypes;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import steps.panalyses.analysistypes.model.response.getanalysistypesbody.AnalysisTypesResponseBody;

import static io.restassured.RestAssured.given;

public class DeleteAnalysisTypes {

    @Step("p-analyses DELETE: /analysis_types/{analysis_type_id}")
    public void deleteAnalysis_types(String token, int id) {
        String analysis_types = "/analysis_types/";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + analysis_types + id),
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
