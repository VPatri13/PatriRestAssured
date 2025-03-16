package Steps.pauth.model.response;

public class VerifyTokenResponseBody {

    private boolean is_verified;
    private String username;
    private String role;

    public VerifyTokenResponseBody(boolean is_verified, String username, String role) {
        this.is_verified = is_verified;
        this.username = username;
        this.role = role;
    }

    public VerifyTokenResponseBody() {
    }

    public boolean isIs_verified() {
        return is_verified;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }
}
