import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.panalyses.analysistypes.DeleteAnalysisTypes;
import steps.panalyses.analysistypes.GetAnalysisTypes;
import steps.panalyses.analysistypes.PostAnalysisTypes;
import steps.pauth.AdminUserLogin;

public class PAnalysesApiTest {

    /**
     *  GET: /analysis_types/
     */
    @Test
    @DisplayName("GET: /analysis_types/")
    public void getAnalysis_types() {

        GetAnalysisTypes getAnalysisTypes = new GetAnalysisTypes();
        AdminUserLogin adminUserLogin = new AdminUserLogin();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());

        Allure.step("Получить постраничный список всех типов анализа на /analysis_types/",
                () -> getAnalysisTypes.analysis_types(token));
    }

    /**
     *  POST: /analysis_types/ и DELETE: /analysis_types/{analysis_type_id}
     */
    @Test
    @DisplayName("POST: /analysis_types/ и DELETE: /analysis_types/{analysis_type_id}")
    public void PostAnalysis_types() {

        PostAnalysisTypes postAnalysisTypes = new PostAnalysisTypes();
        AdminUserLogin adminUserLogin = new AdminUserLogin();
        DeleteAnalysisTypes deleteAnalysisTypes = new DeleteAnalysisTypes();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());

        int id = Allure.step("Создаем новый тип анализа на /analysis_types/",
                () -> postAnalysisTypes.analysis_types(token).getId());
        Allure.step("Удаляем созданный тип анализа на /analysis_types/{analysis_type_id}",
                () -> deleteAnalysisTypes.deleteAnalysis_types(token, id));

    }

    /**
     *  POST: /analysis_types/ Попытка создать тип анализа который уже существует
     */
    @Test
    @DisplayName("POST: /analysis_types/")
    public void RepeatPostAnalysis_types() {

        PostAnalysisTypes postAnalysisTypes = new PostAnalysisTypes();
        AdminUserLogin adminUserLogin = new AdminUserLogin();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());

        Allure.step("Попытка создать тип анализа который уже существует на /analysis_types/",
                () -> postAnalysisTypes.repeatAnalysis_types(token));
    }

}
