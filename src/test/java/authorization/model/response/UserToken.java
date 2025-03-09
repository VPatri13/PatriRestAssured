package authorization.model.response;



public class UserToken {
    private String token;
    private String refresh_token;
    private Integer exp;

    public UserToken(Integer exp, String token, String refresh_token) {
        this.exp = exp;
        this.token = token;
        this.refresh_token = refresh_token;
    }

    public UserToken() {
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
