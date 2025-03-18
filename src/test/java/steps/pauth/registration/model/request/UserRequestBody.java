package steps.pauth.registration.model.request;

public class UserRequestBody {
    private String username;
    private String birthday;
    private int gender_id;

    public UserRequestBody(String username, int gender_id, String birthday) {
        this.username = username;
        this.gender_id = gender_id;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getGender_id() {
        return gender_id;
    }
}
