package steps.panalyses.analysisgroups;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import steps.panalyses.analysisgroups.model.request.PostAnalysisGroupsRequestBody;
import steps.panalyses.analysisgroups.model.response.PostAnalysisGroupsResponseBody;
import steps.panalyses.analysisgroups.model.response.RepeatPostAnalysisGroupsResponseBody;

import static io.restassured.RestAssured.given;

public class PostAnalysisGroups {

    @Step("p-analyses POST: /analysis_groups/")
    public PostAnalysisGroupsResponseBody analysis_groups(String token) {
        String analysis_groups = "/analysis_groups/";
        String nameAnalysisGroups = "Тестовый тип Группа анализов7";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + analysis_groups),
                Specifications.responseSpecOk200());
        PostAnalysisGroupsRequestBody postAnalysisGroupsRequestBody =
                new PostAnalysisGroupsRequestBody(nameAnalysisGroups, true);


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(postAnalysisGroupsRequestBody)
                .when()
                .post()
                .then().log().all()
                .extract().response();

        PostAnalysisGroupsResponseBody postAnalysisGroupsResponseBody = response.as(PostAnalysisGroupsResponseBody.class);

        return postAnalysisGroupsResponseBody;
    }

    @Step("p-analyses POST: /analysis_groups/")
    public RepeatPostAnalysisGroupsResponseBody repeatAnalysis_groups(String token) {
        String analysis_groups = "/analysis_groups/";
        String nameAnalysisGroups = "Тестовый тип Группа анализов";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL + analysis_groups),
                Specifications.responseSpec400());
        PostAnalysisGroupsRequestBody postAnalysisGroupsRequestBody =
                new PostAnalysisGroupsRequestBody(nameAnalysisGroups, true);


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(postAnalysisGroupsRequestBody)
                .when()
                .post()
                .then().log().all()
                .extract().response();

        RepeatPostAnalysisGroupsResponseBody repeatPostAnalysisGroupsResponseBody =
                response.as(RepeatPostAnalysisGroupsResponseBody.class);

        return repeatPostAnalysisGroupsResponseBody;
    }

}
