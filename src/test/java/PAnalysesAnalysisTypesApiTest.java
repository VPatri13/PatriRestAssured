import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.panalyses.analysistypes.*;
import steps.pauth.AdminUserLogin;

public class PAnalysesAnalysisTypesApiTest {

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
    public void postAnalysis_types() {

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
    public void repeatPostAnalysis_types() {

        PostAnalysisTypes postAnalysisTypes = new PostAnalysisTypes();
        AdminUserLogin adminUserLogin = new AdminUserLogin();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());

        Allure.step("Попытка создать тип анализа который уже существует на /analysis_types/",
                () -> postAnalysisTypes.repeatAnalysis_types(token));
    }

    /**
     *  GET: /analysis_types/{analysis_type_id}/lab_analyses/ Получить список лабораторных анализов
     */
    @Test
    @DisplayName("GET: /analysis_types/{analysis_type_id}/lab_analyses/")
    public void getAnalysisTypesAnalysisTypeIdLabAnalyses() {

        GetAnalysisTypesAnalysisTypeIdLabAnalyses getAnalysisTypesAnalysisTypeIdLabAnalyses =
                new GetAnalysisTypesAnalysisTypeIdLabAnalyses();
        AdminUserLogin adminUserLogin = new AdminUserLogin();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());

        Allure.step("Получить список лабораторных анализов на /analysis_types/{analysis_type_id}/lab_analyses/",
                () -> getAnalysisTypesAnalysisTypeIdLabAnalyses.getAnalysisTypesAnalysisTypeIdLabAnalyses(token));
    }

    /**
     *  PUT: /analysis_types/{analysis_type_id} Обновить существующий тип анализа
     */
    @Test
    @DisplayName("PUT: /analysis_types/{analysis_type_id}/lab_analyses/")
    public void putAnalysisTypesAnalysisTypeId() {

        PutAnalysisTypesAnalysisTypeId putAnalysisTypesAnalysisTypeId = new PutAnalysisTypesAnalysisTypeId();
        AdminUserLogin adminUserLogin = new AdminUserLogin();
        PostAnalysisTypes postAnalysisTypes = new PostAnalysisTypes();
        DeleteAnalysisTypes deleteAnalysisTypes = new DeleteAnalysisTypes();

        String token = Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                () -> adminUserLogin.admin_userLogin().getToken());

        int id = Allure.step("Создаем новый тип анализа на /analysis_types/",
                () -> postAnalysisTypes.analysis_types(token).getId());

        Allure.step("Обновить существующий тип анализа на /analysis_types/{analysis_type_id}",
                () -> putAnalysisTypesAnalysisTypeId.putAnalysisTypesAnalysisTypeId(token, id));

        Allure.step("Удаляем созданный тип анализа на /analysis_types/{analysis_type_id}",
                () -> deleteAnalysisTypes.deleteAnalysis_types(token, id));
    }

}
