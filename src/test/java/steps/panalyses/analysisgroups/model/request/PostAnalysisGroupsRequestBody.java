package steps.panalyses.analysisgroups.model.request;

public class PostAnalysisGroupsRequestBody {

    private String name;
    private boolean is_default;

    public PostAnalysisGroupsRequestBody(String name, boolean is_default) {
        this.name = name;
        this.is_default = is_default;
    }

    public String getName() {
        return name;
    }

    public boolean isIs_default() {
        return is_default;
    }
}
