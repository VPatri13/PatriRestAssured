import Steps.authorization.AuthorizationSteps;
import Steps.registration.RegistrationSteps;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SmokeTest {

    /**
     * Регистрация нового пользователя
     */
    @Test
    @DisplayName("Регистрация")
    public void userRegistration() {
        RegistrationSteps registrationSteps = new RegistrationSteps();
        String otpToken = Allure.step("Регистрация. Создать нового пользователя на https://test.hyg-core.ru/register",
                registrationSteps::registration);

        Allure.step("Регистрация. Подтверждаем номер телефона, передав номер СМС на  https://test.hyg-core.ru/phone_verify/{phone}",
                () -> registrationSteps.phoneVerify(otpToken));
    }





    /**
     * Вход в приложение
     */
    @Test
    @DisplayName("Авторизация")
    public void authorization() {
        AuthorizationSteps authorizationSteps = new AuthorizationSteps();

        String otpToken = Allure.step("Вход. Отправка номера телефона на '/login_phone/{phone}' для получения СМС",
                authorizationSteps::login_phoneWithoutSMS);
        Allure.step("Вход. Отправка номера телефона и СМС на '/login_phone/{phone}' и получение токенов",
                () -> authorizationSteps.login_phoneWithSMS(otpToken));
    }


}
