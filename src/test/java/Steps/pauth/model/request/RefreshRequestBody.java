package Steps.pauth.model.request;

public class RefreshRequestBody {

    private String refresh_token;

    public RefreshRequestBody(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
}
