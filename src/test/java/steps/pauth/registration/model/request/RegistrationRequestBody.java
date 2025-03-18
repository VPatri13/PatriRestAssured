package steps.pauth.registration.model.request;

public class RegistrationRequestBody {

    private String phone;
    private String device_id;

    public RegistrationRequestBody(String phone, String device_id) {
        this.phone = phone;
        this.device_id = device_id;
    }

    public String getPhone() {
        return phone;
    }

    public String getDevice_id() {
        return device_id;
    }
}
