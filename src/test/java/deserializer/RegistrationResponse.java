package deserializer;

public class RegistrationResponse {

    private String phone;
    private String token;

    public RegistrationResponse(String phone, String token) {
        this.phone = phone;
        this.token = token;
    }

    public RegistrationResponse() {
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
