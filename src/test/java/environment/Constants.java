package environment;

public class Constants {

    private Constants() {
        throw new UnsupportedOperationException("Это класс для хранения констант, его нельзя инстанцировать.");
    }
    public static final String BASE_URL = "https://test.ru";
    public static final String DEVICE_ID = "12345678-1234-1234-1234-123456789123";
    public static final String AUTHENTICATION_TOKEN = "Bearer здесь токен:)";

    public static final String ENDPOINT_LOGIN_PHONE = "/login_phone/";
    public static final String ENDPOINT_REGISTRATION = "/register";
    public static final String ENDPOINT_PHONE_VERIFY = "/phone_verify/";
    public static final String ENDPOINT_USER = "/user/";


    public static final String REGISTER_USER_PHONE = "79000070140";
    public static final String USER_PHONE = "79000000001";
    public static final String CMC_CODE = "1234";
    public static final String USER_NAME = "username36";
    public static final String BIRTHDAY = "2000-09-12";
    public static final int GENDER_ID = 2;
    public static final String GENDER = "Баба:)";



}
