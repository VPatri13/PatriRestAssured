package steps.panalyses.analysistypes.model.response;

public class PostAnalysisTypesResponseBody {

    private String name;
    private boolean is_default;
    private int analysis_group_id;
    private int id;

    public PostAnalysisTypesResponseBody(String name, boolean is_default, int analysis_group_id, int id) {
        this.name = name;
        this.is_default = is_default;
        this.analysis_group_id = analysis_group_id;
        this.id = id;
    }

    public PostAnalysisTypesResponseBody() {
    }

    public String getName() {
        return name;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public int getAnalysis_group_id() {
        return analysis_group_id;
    }

    public int getId() {
        return id;
    }
}
