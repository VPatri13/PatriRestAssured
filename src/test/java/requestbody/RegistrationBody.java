package requestbody;

public class RegistrationBody {

    private String phone;
    private String device_id;

    public RegistrationBody(String phone, String device_id) {
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
