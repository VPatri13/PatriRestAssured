package steps.pauth.registration.model.response;

public class PhoneVerifyResponseBody {

    private String token;
    private String refresh_token;
    private int exp;

    public PhoneVerifyResponseBody( String token, String refresh_token, int exp) {
        this.token = token;
        this.refresh_token = refresh_token;
        this.exp = exp;
    }

    public PhoneVerifyResponseBody() {
    }

    public String getToken() {
        return token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public int getExp() {
        return exp;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
