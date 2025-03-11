package Steps.registration.model.response;

public class Gender {
    public int id;
    public String name;

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
