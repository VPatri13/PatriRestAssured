import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.panalyses.analysisgroups.DeleteAnalysisGroups;
import steps.panalyses.analysisgroups.PostAnalysisGroups;
import steps.pauth.AdminUserLogin;

public class PAnalysesAnalysisGroupsApiTest {

    /**
     *  POST: /analysis_groups/ Создать новую группу анализов
     */
    @Test
    @DisplayName("POST: /analysis_groups/")
    public void postAnalysis_types() {

        PostAnalysisGroups postAnalysisGroups = new PostAnalysisGroups();
        AdminUserLogin adminUserLogin = new AdminUserLogin();
        DeleteAnalysisGroups deleteAnalysisGroups = new DeleteAnalysisGroups();


        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());

        int id = Allure.step("Создаем новую группу анализов на /analysis_groups/",
                () -> postAnalysisGroups.analysis_groups(token).getId());
        Allure.step("Удалить группу анализа на /analysis_groups/{group_id}",
                () -> deleteAnalysisGroups.deleteAnalysis_groups(token, id));

    }

}
