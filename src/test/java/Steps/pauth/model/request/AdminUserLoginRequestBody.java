package Steps.pauth.model.request;

public class AdminUserLoginRequestBody {

    private String username;
    private String password;

    public AdminUserLoginRequestBody(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
