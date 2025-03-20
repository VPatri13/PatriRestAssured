package steps.panalyses.analysisgroups.model.response;

public class PostAnalysisGroupsResponseBody {

    private String name;
    private boolean is_default;
    private int id;

    public PostAnalysisGroupsResponseBody(String name, boolean is_default, int id) {
        this.name = name;
        this.is_default = is_default;
        this.id = id;
    }

    public PostAnalysisGroupsResponseBody() {
    }

    public String getName() {
        return name;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public int getId() {
        return id;
    }
}
