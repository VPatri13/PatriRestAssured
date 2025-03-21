package steps.panalyses.analysisgroups;

import environment.Constants;
import environment.Specifications;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import steps.panalyses.analysisgroups.model.request.PostAnalysisGroupsRequestBody;

import static io.restassured.RestAssured.given;

public class PutAnalysisGroupsGroupId {
    @Step("p-analyses PUT: /analysis_groups/{group_id}")
    public void putAnalysisGroupsGroupId(String token, int group_id) {
        String analysis_groups = "/analysis_groups/";
        String analysis_groupsName = "Обновленная группа анализов7";

        Specifications.installSpecification(Specifications.requestSpec(Constants.BASE_URL
                + analysis_groups + group_id), Specifications.responseSpecOk204());
        PostAnalysisGroupsRequestBody postAnalysisGroupsRequestBody =
                new PostAnalysisGroupsRequestBody(analysis_groupsName, true);


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .body(postAnalysisGroupsRequestBody)
                .when()
                .put()
                .then().log().all()
                .extract().response();
    }
}
