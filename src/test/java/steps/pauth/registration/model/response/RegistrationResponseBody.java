package steps.pauth.registration.model.response;

public class RegistrationResponseBody {

    private String phone;
    private String token;

    public RegistrationResponseBody(String phone, String token) {
        this.phone = phone;
        this.token = token;
    }

    public RegistrationResponseBody() {
    }

    public String getPhone() {
        return phone;
    }

    public String getToken() {
        return token;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
