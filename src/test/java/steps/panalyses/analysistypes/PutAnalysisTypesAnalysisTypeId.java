package steps.panalyses.analysistypes;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import steps.panalyses.analysistypes.model.request.PutAnalysisTypesAnalysisTypeIdRequestBody;

import static io.restassured.RestAssured.given;

public class PutAnalysisTypesAnalysisTypeId {
    @Step("p-analyses PUT: /analysis_types/{analysis_type_id}")
    public void putAnalysisTypesAnalysisTypeId(String token, int analysis_type_id) {
        String analysis_types = "/analysis_types/";
        String analysis_typesName = "Обновленный тип анализа";
        int analysis_group_id = 1;


        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL
                + analysis_types + analysis_type_id), Specifications.responseSpecOk200());
        PutAnalysisTypesAnalysisTypeIdRequestBody putAnalysisTypesAnalysisTypeIdRequestBody =
                new PutAnalysisTypesAnalysisTypeIdRequestBody(analysis_typesName, analysis_group_id, true);


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(putAnalysisTypesAnalysisTypeIdRequestBody)
                .when()
                .put()
                .then().log().all()
                .extract().response();
    }
}
