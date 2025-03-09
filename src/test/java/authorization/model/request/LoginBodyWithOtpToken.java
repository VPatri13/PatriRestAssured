package authorization.model.request;

public class LoginBodyWithOtpToken {
    public String device_id;
    public String otp_token;

    public LoginBodyWithOtpToken(String device_id, String otp_token) {
        this.device_id = device_id;
        this.otp_token = otp_token;
    }

    public String getDevice_id() {
        return device_id;
    }

    public String getOtp_token() {
        return otp_token;
    }
    
}
