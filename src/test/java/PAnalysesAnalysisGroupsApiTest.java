import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.panalyses.analysisgroups.*;
import steps.pauth.AdminUserLogin;

public class PAnalysesAnalysisGroupsApiTest {

    /**
     *  POST: /analysis_groups/ Создать новую группу анализов
     */
    @Test
    @DisplayName("POST: /analysis_groups/")
    public void postAnalysis_groups() {

        PostAnalysisGroups postAnalysisGroups = new PostAnalysisGroups();
        AdminUserLogin adminUserLogin = new AdminUserLogin();
        DeleteAnalysisGroups deleteAnalysisGroups = new DeleteAnalysisGroups();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());
        int id = Allure.step("Создаем новую группу анализов на POST: /analysis_groups/",
                () -> postAnalysisGroups.analysis_groups(token).getId());
        Allure.step("Удалить группу анализа на DELETE: /analysis_groups/{group_id}",
                () -> deleteAnalysisGroups.deleteAnalysis_groups(token, id));

    }

    /**
     *  POST: /analysis_groups/ Попытка создать группу анализов с существующим названием
     */
    @Test
    @DisplayName("POST: /analysis_groups/")
    public void repeatPostAnalysis_groups() {

        PostAnalysisGroups postAnalysisGroups = new PostAnalysisGroups();
        AdminUserLogin adminUserLogin = new AdminUserLogin();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());
        Allure.step("Попытка создать группу анализов с существующим названием на POST: /analysis_groups/",
                () -> postAnalysisGroups.repeatAnalysis_groups(token));

    }

    /**
     *  GET: /analysis_groups/ Получить все группы анализа с разбивкой на страницы
     */
    @Test
    @DisplayName("GET: /analysis_groups/")
    public void getAnalysis_groups () {

        AdminUserLogin adminUserLogin = new AdminUserLogin();
        GetAnalysisGroups getAnalysisGroups = new GetAnalysisGroups();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());
        Allure.step("Получить все группы анализа с разбивкой на страницы на GET: /analysis_groups/",
                () -> getAnalysisGroups.getAnalysis_groups(token));
    }

    /**
     *  GET: /analysis_groups/{analysis_group_id}/analysis_types/ Получить все группы анализа с разбивкой на страницы
     */
    @Test
    @DisplayName("GET: /analysis_groups/")
    public void getAnalysis_groupsAnalysis_group_idAnalysis_types () {

        AdminUserLogin adminUserLogin = new AdminUserLogin();
        GetAnalysisGroupsAnalysisGroupIdAnalysisTypes getAnalysisGroupsAnalysisGroupIdAnalysisTypes =
                new GetAnalysisGroupsAnalysisGroupIdAnalysisTypes();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());
        Allure.step("Получить типы анализов в группе анализов по id группы анализов на GET: /analysis_groups/{analysis_group_id}/analysis_types/",
                () -> getAnalysisGroupsAnalysisGroupIdAnalysisTypes.getAnalysisGroupsAnalysisGroupIdAnalysisTypes(token));
    }

    /**
     *  PUT: /analysis_groups/{group_id} Обновить существующую группу анализа
     */
    @Test
    @DisplayName("PUT: /analysis_groups/{group_id}")
    public void putAnalysis_groupsGroupId() {

        PostAnalysisGroups postAnalysisGroups = new PostAnalysisGroups();
        AdminUserLogin adminUserLogin = new AdminUserLogin();
        DeleteAnalysisGroups deleteAnalysisGroups = new DeleteAnalysisGroups();
        PutAnalysisGroupsGroupId putAnalysisGroupsGroupId = new PutAnalysisGroupsGroupId();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());
        int id = Allure.step("Создаем новую группу анализов на POST: /analysis_groups/",
                () -> postAnalysisGroups.analysis_groups(token).getId());
        Allure.step("Обновить существующую группу анализа на PUT: /analysis_groups/{group_id}",
                () -> putAnalysisGroupsGroupId.putAnalysisGroupsGroupId(token, id));
        Allure.step("Удалить группу анализа на DELETE: /analysis_groups/{group_id}",
                () -> deleteAnalysisGroups.deleteAnalysis_groups(token, id));

    }


}
