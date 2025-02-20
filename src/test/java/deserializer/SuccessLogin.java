package deserializer;

public class SuccessLogin {
    public boolean success;
    public String message;
    public String otp_token;


    public void setOtp_token(String otp_token) {
        this.otp_token = otp_token;
    }

    public String getOtp_token() {
        return otp_token;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
