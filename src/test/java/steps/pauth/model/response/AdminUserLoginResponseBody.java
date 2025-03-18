package steps.pauth.model.response;

public class AdminUserLoginResponseBody {
    private String token;
    private String refresh_token;
    private Integer exp;

    public AdminUserLoginResponseBody(String token, Integer exp, String refresh_token) {
        this.token = token;
        this.exp = exp;
        this.refresh_token = refresh_token;
    }

    public AdminUserLoginResponseBody() {
    }

    public String getToken() {
        return token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public Integer getExp() {
        return exp;
    }
}
