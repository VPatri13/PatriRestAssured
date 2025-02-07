package requestbody;

public class LoginBody {
    private String device_id;

    public LoginBody(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_id() {
        return device_id;
    }
}
