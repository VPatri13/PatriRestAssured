package testkits;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testkits.environment.TestSteps;

public class SmokeTest extends TestSteps {

    /**
     * Регистрация нового пользователя
     */
    @Test
    @DisplayName("Регистрация")
    public void userRegistration() {
        Allure.step("Регистрация. Создать нового пользователя на https://test.hyg-core.ru/register",
                this::registration);
    }



    /**
     * Вход в приложение
     */
    @Test
    @DisplayName("Авторизация")
   public void authorization() {
        Allure.step("Вход. Отправка номера телефона на '/login_phone/{phone}' для получения СМС",
                this::login_phoneWithoutSMS);
        Allure.step("Вход. Отправка номера телефона и СМС на '/login_phone/{phone}' и получение токенов",
                this::login_phoneWithSMS);
    }


}
