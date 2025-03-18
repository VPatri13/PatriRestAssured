package steps.pauth.registration.model.response;

public class Gender {
    private int id;
    private String name;

    public Gender(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Gender() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
