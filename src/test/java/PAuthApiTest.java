import steps.pauth.authorization.AuthorizationSteps;
import steps.pauth.AdminUserLogin;
import steps.pauth.Refresh;
import steps.pauth.VerifyToken;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PAuthApiTest {

    /**
     *  POST: /refresh
     */
    @Test
    @DisplayName("POST: /refresh")
    public void refresh() {

        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        Refresh refresh = new Refresh();

        String otpToken = Allure.step("Вход. Отправка номера телефона на '/login_phone/{phone}' для получения СМС",
                authorizationSteps::login_phoneWithoutSMS);
        String refreshToken = Allure.step("Вход. Отправка номера телефона и СМС на '/login_phone/{phone}' и получение токенов",
                () -> authorizationSteps.login_phoneWithSMS(otpToken).getRefresh_token());
        Allure.step("Обновление Access токена через refresh токен на /refresh",
                () -> refresh.refresh(refreshToken));
    }

    /**
     *  POST: /verify_token/
     */
    @Test
    @DisplayName("POST: /verify_token/")
    public void verify_token() {

        AuthorizationSteps authorizationSteps = new AuthorizationSteps();
        VerifyToken verifyToken = new VerifyToken();

        String otpToken = Allure.step("Вход. Отправка номера телефона на '/login_phone/{phone}' для получения СМС",
                authorizationSteps::login_phoneWithoutSMS);
        String token = Allure.step("Вход. Отправка номера телефона и СМС на '/login_phone/{phone}' и получение токенов",
                () -> authorizationSteps.login_phoneWithSMS(otpToken).getToken());
        Allure.step("Проверить токен пользователя на /verify_token/",
                () -> verifyToken.verify_token(token));
    }

    /**
     *  POST: /admin_user/login
     */
    @Test
    @DisplayName("POST: /admin_user/login")
    public void admin_userLogin() {

        AdminUserLogin adminUserLogin = new AdminUserLogin();

        Allure.step("Входим в систему как администратор по логину и паролю на /admin_user/login",
                adminUserLogin::admin_userLogin);
    }

}
