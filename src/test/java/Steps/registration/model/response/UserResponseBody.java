package Steps.registration.model.response;

import java.util.ArrayList;

public class UserResponseBody {
    private int id;
    private String username;
    private Object path_thumbnail;
    private String online_status;
    private String birthday;
    private String description;
    private double rating;
    private Gender gender;
    private ArrayList<Object> photos;
    private int count_sub;
    private int count_sub_on_me;
    private int count_certificates;

    public UserResponseBody() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Object getPath_thumbnail() {
        return path_thumbnail;
    }

    public String getOnline_status() {
        return online_status;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public Gender getGender() {
        return gender;
    }

    public ArrayList<Object> getPhotos() {
        return photos;
    }

    public int getCount_sub() {
        return count_sub;
    }

    public int getCount_sub_on_me() {
        return count_sub_on_me;
    }

    public int getCount_certificates() {
        return count_certificates;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPath_thumbnail(Object path_thumbnail) {
        this.path_thumbnail = path_thumbnail;
    }

    public void setOnline_status(String online_status) {
        this.online_status = online_status;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhotos(ArrayList<Object> photos) {
        this.photos = photos;
    }

    public void setCount_sub(int count_sub) {
        this.count_sub = count_sub;
    }

    public void setCount_sub_on_me(int count_sub_on_me) {
        this.count_sub_on_me = count_sub_on_me;
    }

    public void setCount_certificates(int count_certificates) {
        this.count_certificates = count_certificates;
    }
}
