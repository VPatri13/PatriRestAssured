package steps.panalyses.analysistypes;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import steps.panalyses.analysistypes.model.request.PostAnalysisTypesRequestBody;
import steps.panalyses.analysistypes.model.response.PostAnalysisTypesResponseBody;
import steps.panalyses.analysistypes.model.response.RepeatPostAnalysisTypesResponseBody;

import static io.restassured.RestAssured.given;

public class PostAnalysisTypes {
    @Step("p-analyses POST: /analysis_types/")
    public PostAnalysisTypesResponseBody analysis_types(String token) {
        String analysis_types = "/analysis_types/";
        String nameAnalysisTypes = "Тестовый тип анализа5";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + analysis_types),
                Specifications.responseSpecOk200());
        PostAnalysisTypesRequestBody postAnalysisTypesRequestBody =
                new PostAnalysisTypesRequestBody(nameAnalysisTypes, true, 1);


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(postAnalysisTypesRequestBody)
                .when()
                .post()
                .then().log().all()
                .extract().response();

        PostAnalysisTypesResponseBody postAnalysisTypesResponseBody = response.as(PostAnalysisTypesResponseBody.class);

        return postAnalysisTypesResponseBody;
    }

    @Step("p-analyses POST: /analysis_types/ Попытка создать уже существующий тип анализа")
    public RepeatPostAnalysisTypesResponseBody repeatAnalysis_types(String token) {
        String analysis_types = "/analysis_types/";
        String nameAnalysisTypes = "Тестовый тип анализа";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + analysis_types),
                Specifications.responseSpec409());
        PostAnalysisTypesRequestBody postAnalysisTypesRequestBody =
                new PostAnalysisTypesRequestBody(nameAnalysisTypes, true, 1);


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(postAnalysisTypesRequestBody)
                .when()
                .post()
                .then().log().all()
                .extract().response();

        RepeatPostAnalysisTypesResponseBody repeatPostAnalysisTypesResponseBody =
                response.as(RepeatPostAnalysisTypesResponseBody.class);



        return repeatPostAnalysisTypesResponseBody;
    }
}
